package com.techtree.ttshoppingcart.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.techtree.ttshoppingcart.model.OrderBean;
import com.techtree.ttshoppingcart.model.Transactions;
import com.techtree.ttshoppingcart.model.orders;
import com.techtree.ttshoppingcart.model.response;
import com.techtree.ttshoppingcart.model.walletResponse;
import com.techtree.ttshoppingcart.repos.OrderRepo;
import com.techtree.ttshoppingcart.repos.Repository;
import com.techtree.ttshoppingcart.repos.TranscationRepo;
import com.techtree.ttshoppingcart.repos.walletsRepository;
import com.techtree.ttshoppingcart.service.service;


@Service
public class serviceimpl implements service {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(serviceimpl.class);
	
	
	@Value("${cashback.bonus}")
	public double CBpercent;

	@Value("${cashback.cashbackupto}")
	public double cashbackupto;
	
	@Value("${cashback.expirydate}")
	public int expirydate;

	@Value("${cashback.fromdate}")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public Date fromdate;
		
	@Value("${cashback.todate}")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	public Date todate;
	@Autowired
	private walletsRepository walletrepo;
	
	@Autowired
	private Repository userrepo;

	@Override
	public ResponseEntity<Object> get() {
		JSONObject json = new JSONObject();
		try {
			List<Object[]> resp = walletrepo.get();
			List<response> list = new ArrayList<response>();
			for (Object[] data : resp) {
				response response = new response();
				response.setWalletid((int) data[0]);
				response.setCashbackExpiry(data[1].toString());
				response.setAmountStatus(data[2].toString());
				response.setPaidAmount((double) data[3]);
				response.setCashbackAmount((double) data[4]);
				response.setTranscationStatus(data[5].toString());
				response.setEmail(data[6].toString());
				response.setFirstName(data[7].toString());
				response.setLastName(data[8].toString());
				response.setPhonenumber(data[9].toString());
				list.add(response);
			}
			json.put("data", list);
			return new ResponseEntity<Object>(json, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<Object> getbyId(Integer id, String amounttype) {
		JSONObject json = new JSONObject();
		try {
			List<walletResponse> wallletresponse = new ArrayList<>();
			SimpleDateFormat Cashbackformatter = new SimpleDateFormat("dd-MMM-Y hh:mm:ss");
			if (id != null) {
				List<Object[]> Objects = walletrepo.findbyid((int) id);
				for (Object[] data : Objects) {
					walletResponse walletrep = new walletResponse();
					walletrep.setId((int) data[0]);
					// Date thisdate=(Date)data[1];
					// thisdate.
					// System.out.println("--------->"+thisdate);
					// thisdate.UTC(0, 0, 0, 0, + 10, 0);
					// walletrep.setCreationTime(();
					// walletrep.setModifiedTime((Date)data[2]);
					// Systemimport org.apache.catalina.connector.Response;.out.println(thisdate);
					walletrep.setCreationBy(data[3].toString());
					walletrep.setModifiedBy(data[4].toString());
					walletrep.setAmount((double) data[5]);
					String StrCashBackDate = Cashbackformatter.format((Date) data[6]);
					walletrep.setExpiryCashbackDateTime(StrCashBackDate);
					walletrep.setAmountType(data[7].toString());
					wallletresponse.add(walletrep);
				}
				json.put("data", wallletresponse);
				return new ResponseEntity<Object>(json, HttpStatus.OK);
			}
			if (amounttype.isEmpty() != true && amounttype.isBlank() != true && amounttype != null) {
				List<Object[]> Objects = walletrepo.findbyamounttype(amounttype);
				for (Object[] data : Objects) {
					walletResponse walletrep = new walletResponse();
					System.out.println((int) data[0]);
					walletrep.setId((int) data[0]);
					// walletrep.setCreationTime((Date)data[1]);
					// walletrep.setModifiedTime();
					walletrep.setCreationBy(data[3].toString());
					walletrep.setModifiedBy(data[4].toString());
					walletrep.setAmount((double) data[5]);
					String StrCashBackDate = Cashbackformatter.format((Date) data[6]);
					walletrep.setExpiryCashbackDateTime(StrCashBackDate);
					walletrep.setAmountType(data[7].toString());
					wallletresponse.add(walletrep);
				}
				json.put("data", wallletresponse);
				return new ResponseEntity<Object>(json, HttpStatus.OK);
			}

			else {
				List<Object[]> Objects = walletrepo.findALL();
				for (Object[] data : Objects) {
					walletResponse walletrep = new walletResponse();
					System.out.println((int) data[0]);
					walletrep.setId((int) data[0]);
					// walletrep.setCreationTime((Date)data[1]);
					// walletrep.setModifiedTime((Date)data[2]);
					walletrep.setCreationBy(data[3].toString());
					walletrep.setModifiedBy(data[4].toString());
					walletrep.setAmount((double) data[5]);
					String StrCashBackDate = Cashbackformatter.format((Date) data[6]);
					walletrep.setExpiryCashbackDateTime(StrCashBackDate);
					walletrep.setAmountType(data[7].toString());
					wallletresponse.add(walletrep);
				}

				json.put("data", wallletresponse);
				return new ResponseEntity<Object>(json, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> pickobject() throws ParseException {
		int id=0;
		String s = "{\"message\":\"success\",\"courseList\":[{\"courseOid\":4,\"courseID\":\"97101-201-0000000002\",\"courseName\":\"Championship Course\",\"clubImage\":\"/brand/1612261963461_golf.jpeg\",\"courseStartTime\":\"06:00\",\"courseEndTime\":\"18:40\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":2,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617692039536_10th_Hole_3.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1582456664711_DC_CH2.jpg\",\"videoUrl\":\"https://www.youtube.com/watch?v=cqBPziUJW0A\",\"websiteUrl\":\"https://www.dubaigolf.com/dubai-creek-golf-yacht-club/golf/courses/the-championship-course/\",\"phoneNumber\":\"97142956000\",\"latitude\":\"25.241959\",\"longitude\":\"55.333497\",\"holes\":[{\"hole\":9,\"returnTime\":\"5\"},{\"hole\":18,\"returnTime\":\"7\"}],\"galleryImages\":[\"/brandCategory/1581581544186_6th_Hole_1.jpg\",\"/brandCategory/1581581544205_5th_Hole_4.jpg\",\"/brandCategory/1581581544222_2nd_Hole_1.jpg\",\"/brandCategory/1581581544290_5th_Hole_3.jpg\",\"/brandCategory/1581581544212_10th_Hole_3.jpg\",\"/brandCategory/1581581544268_10th_Hole_4.jpg\",\"/brandCategory/1581581544521_DSC_3036.jpg\",\"/brandCategory/1581581544522_DSC_3025.jpg\",\"/brandCategory/1581581544591_DSC_3050.jpg\",\"/brandCategory/1581581544665_DSC_3055.jpg\",\"/brandCategory/1584874294058_6th_Hole_3_6.JPG\",\"/brandCategory/1584874294060_10th_Hole_4_5.JPG\",\"/brandCategory/1584874294038_18th_Hole_Creek_1_3.JPG\",\"/brandCategory/1584874294166_DSC_4172_7.JPG\",\"/brandCategory/1584874476002_10th_Hole_2_1.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617692037116_10th_Hole_3.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"},{\"isDefault\":false,\"isDynamic\":true,\"playerTypeID\":1090,\"playerTypeName\":\"Viya Golf Dynamic\"}],\"coursePlayerList\":[],\"clubName\":\"Dubai Golf and Yacht Club\"},{\"courseOid\":2,\"courseID\":\"97101-201-0000000019\",\"courseName\":\"Earth Course\",\"clubImage\":\"/brand/Jumeirah_earth_course.jpg\",\"courseStartTime\":\"06:00\",\"courseEndTime\":\"18:24\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":3,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617691702633_P1133030_LR.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691704852_P1133030_LR.jpg\",\"videoUrl\":\"https://www.youtube.com/watch?v=H4pPKIuj_fY\",\"websiteUrl\":\"https://www.dubaigolf.com/golf/courses/earth-course/\",\"phoneNumber\":\"97148182000\",\"latitude\":\"25.0208802\",\"longitude\":\"55.1997795\",\"holes\":[{\"hole\":9,\"returnTime\":\"3\"},{\"hole\":18,\"returnTime\":\"3\"}],\"galleryImages\":[\"/brandCategory/1581581433967_P1133030.jpg\",\"/brandCategory/1581581434049_5th_Hole_1.jpg\",\"/brandCategory/1581581434065_5th_Hole_DPTWC_2.jpg\",\"/brandCategory/1581581434100_P1122658_Pano.jpg\",\"/brandCategory/1581581434128_16th_Hole_2_SMALL.jpg\",\"/brandCategory/1581581434144_10th_Hole_1.jpg\",\"/brandCategory/1581581434341_8th_Hole_JGE.jpg\",\"/brandCategory/1581581434343_17th_Hole_1.jpg\",\"/brandCategory/1581581434815_P1133067.jpg\",\"/brandCategory/1581581434832_P1133055.jpg\",\"/brandCategory/1581581435001_P1133049.jpg\",\"/brandCategory/1583401730534_P1122765.JPG\",\"/brandCategory/1583401730537_P1122772.JPG\",\"/brandCategory/1583401764030_P1133025.JPG\",\"/brandCategory/1583401764177_P1122778.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691698738_P1133030_LR.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Jumeirah Golf Estates\"},{\"courseOid\":1,\"courseID\":\"97101-201-0000000013\",\"courseName\":\"Par 3 Course\",\"clubImage\":\"/brand/EGC_Par_3.jpg\",\"courseStartTime\":\"07:00\",\"courseEndTime\":\"22:54\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":1,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617691826911_1486.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691829203_1486.jpg\",\"videoUrl\":\"https://www.youtube.com/watch?v=su_lZ_6QpfE\",\"websiteUrl\":\"https://www.dubaigolf.com/emirates-golf-club/golf/courses/par-3-academy-course/\",\"phoneNumber\":\"97144179999\",\"latitude\":\"25.087955\",\"longitude\":\"55.157461\",\"holes\":[{\"hole\":9,\"returnTime\":\"5\"}],\"galleryImages\":[\"/brandCategory/1581581342096_EGC_Par_3..jpg\",\"/brandCategory/1581581342341_9801.jpg\",\"/brandCategory/1581581342433_9761.jpg\",\"/brandCategory/1581581342356_1486.jpg\",\"/brandCategory/1581581342383_9766.jpg\",\"/brandCategory/1581581342370_1467.jpg\",\"/brandCategory/1583390274745_Academy_1.JPG\",\"/brandCategory/1583390275089_Academy_2.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691823976_1486.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Emirates Golf Club\"},{\"courseOid\":3,\"courseID\":\"97101-201-0000000020\",\"courseName\":\"Fire Course\",\"clubImage\":\"/brand/Jumeirah_earth_course.jpg\",\"courseStartTime\":\"06:05\",\"courseEndTime\":\"18:30\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":3,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617691299509_DSC_0736.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691368144_DSC_0736.jpg\",\"videoUrl\":\"https://www.youtube.com/watch?v=H4pPKIuj_fY\",\"websiteUrl\":\"https://www.dubaigolf.com/golf/courses/fire-course/\",\"phoneNumber\":\"97148182000\",\"latitude\":\"25.021187\",\"longitude\":\"55.199776\",\"holes\":[{\"hole\":9,\"returnTime\":\"10\"},{\"hole\":18,\"returnTime\":\"5\"}],\"galleryImages\":[\"/brandCategory/1581581393219_2nd_Hole_Fire_JGE_2.jpg\",\"/brandCategory/1581581393293_6th_Hole_1.jpg\",\"/brandCategory/1581581393317_2nd_Hole_Fire_JGE.jpg\",\"/brandCategory/1581581393381_12th_Hole_1.jpg\",\"/brandCategory/1581581393415_6th_Hole_2_2.jpg\",\"/brandCategory/1581581393460_6th_Hole_2.jpg\",\"/brandCategory/1581581393549_10th_Hole_1.jpg\",\"/brandCategory/1581581393631_42636072_9A9E_44D6_8D72_5514987F8008.jpg\",\"/brandCategory/1581581393665_JGE_053.jpg\",\"/brandCategory/1583389987552_3rd_Hole_Fire_JGE.JPG\",\"/brandCategory/1583402297539_JGE_053.JPG\",\"/brandCategory/1583402297514_14th_Hole_1.JPG\",\"/brandCategory/1583402297470_10th_Hole_1.JPG\",\"/brandCategory/1583402297525_18th_Hole_Fire.JPG\",\"/brandCategory/1583403422630_DSC_3961.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617691290736_DSC_0736.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Jumeirah Golf Estates\"},{\"courseOid\":5,\"courseID\":\"97101-201-0000000005\",\"courseName\":\"Majlis Course\",\"clubImage\":\"/brand/EGC_Par_3.jpg\",\"courseStartTime\":\"06:20\",\"courseEndTime\":\"18:00\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":1,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1620365991308_download.jpeg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore\",\"videoUrl\":\"https://www.youtube.com/watch?v=su_lZ_6QpfE\",\"websiteUrl\":\"https://www.dubaigolf.com/emirates-golf-club/golf/courses/the-majlis/\",\"phoneNumber\":\"97144179999\",\"latitude\":\"25.088072\",\"longitude\":\"55.157376\",\"holes\":[{\"hole\":9,\"returnTime\":\"5\"},{\"hole\":18,\"returnTime\":\"5\"}],\"galleryImages\":[\"/brandCategory/1581581633832_12th_Hole_1.jpg\",\"/brandCategory/1581581633797_11th_Hole_1.jpg\",\"/brandCategory/1581581633826_creekgolf_043.jpg\",\"/brandCategory/1581581633811_7th_Hole_2.jpg\",\"/brandCategory/1581581633797_13th_Hole_2.jpg\",\"/brandCategory/1581581633879_8th_Tee.jpg\",\"/brandCategory/1581581634018_Grandstand.jpg\",\"/brandCategory/1581581634131_creekgolf_122.jpg\",\"/brandCategory/1583404940114_3rd_Hole_.JPG\",\"/brandCategory/1583404963072_3rd_Hole_2.JPG\",\"/brandCategory/1583404976026_7th_Hole_3.JPG\",\"/brandCategory/1583404988088_8th_Hole_5.JPG\",\"/brandCategory/1583405009955_17th_Hole_1.JPG\",\"/brandCategory/1583405019279_Birdge_1.JPG\",\"/brandCategory/1583405036298_8th_Tee.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1620365972489_1617704208801_00000000_XX_8316_6FEEBE6C910AEAB12442EDB2558F01F6.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Emirates Golf Club\"},{\"courseOid\":6,\"courseID\":\"97101-201-0000000006\",\"courseName\":\"Faldo Course\",\"clubImage\":\"/brand/EGC_Par_3.jpg\",\"courseStartTime\":\"06:25\",\"courseEndTime\":\"22:55\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":1,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617704272608_creekgolf_116.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore\",\"videoUrl\":\"https://www.youtube.com/watch?v=su_lZ_6QpfE\",\"websiteUrl\":\"https://www.dubaigolf.com/emirates-golf-club/golf/courses/the-faldo-course/\",\"phoneNumber\":\"97144179999\",\"latitude\":\"25.0919075\",\"longitude\":\"55.1529462\",\"holes\":[{\"hole\":9,\"returnTime\":\"5\"},{\"hole\":18,\"returnTime\":\"5\"}],\"galleryImages\":[\"/brandCategory/1581581594396_4th_Hole_2.jpg\",\"/brandCategory/1581581594429_9th_Hole_4.jpg\",\"/brandCategory/1581581594397_9th_Hole_3.jpg\",\"/brandCategory/1581581594423_3rd_Hole_3.jpg\",\"/brandCategory/1581581594417_5th_Hole_1.jpg\",\"/brandCategory/1581581594500_6th_Hole_1.jpg\",\"/brandCategory/1581581594677_16th_Hole_2_SMALL.jpg\",\"/brandCategory/1581581594776_17th_Hole_3_SMALL.jpg\",\"/brandCategory/1581581594831_Faldo_no_text.jpg\",\"/brandCategory/1581581594913_18th_Hole_3.jpg\",\"/brandCategory/1581581594937_18th_Hole_1.jpg\",\"/brandCategory/1583389158982_Faldo_Emirates_9th_9043.JPG\",\"/brandCategory/1583389158914_Faldo_Emirates_4th_9387.JPG\",\"/brandCategory/1583389159072_New_Lights_1.JPG\",\"/brandCategory/1583389179023_Faldo_Emirates_15th_9484.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617704266396_creekgolf_116.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Emirates Golf Club\"},{\"courseOid\":20,\"courseID\":\"97101-201-0000000028\",\"courseName\":\"Championship Course\",\"clubImage\":\"/brand/1578835594783_Trump.jpg\",\"courseStartTime\":\"06:00\",\"courseEndTime\":\"18:00\",\"courseIntervalTime\":10,\"bookingDays\":365,\"shotgunDays\":null,\"clubID\":4,\"courseImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/store/1617692145402_trump_dubai_17th_behind_6005_web.jpg\",\"image360\":\"https://waslbucketuat.blob.core.windows.net/wsstore\",\"videoUrl\":\"https://www.youtube.com/watch?v=npCQOt8aqkk\",\"websiteUrl\":\"https://www.trumpgolfdubai.com/course\",\"phoneNumber\":\"97142453939\",\"latitude\":\"25.024640\",\"longitude\":\"55.253962\",\"holes\":[{\"hole\":9,\"returnTime\":\"4\"},{\"hole\":18,\"returnTime\":\"4\"}],\"galleryImages\":[\"/brandCategory/1581581215383_Trump_Dubai_8th_master_4838.jpg\",\"/brandCategory/1581581215460_download.jpg\",\"/brandCategory/1581581215459_1_16a083910df.1975588_4167900062_16a083910df_medium.jpg\",\"/brandCategory/1581581215506_merchant_profile__hero__image_slide.1__retina_.jpg\",\"/brandCategory/1581581215521_trump_international_golf_club_dubai_37_xl.jpg\",\"/brandCategory/1584859378230_5th_Hole_10_5.JPG\",\"/brandCategory/1584859378292_8th_Hole_8_7.JPG\",\"/brandCategory/1584859378148_9th_Hole_4_1.JPG\",\"/brandCategory/1584859378360_9th_Hole_2_2.JPG\",\"/brandCategory/1584859378404_8th_Hole_4_4.JPG\",\"/brandCategory/1584859378405_15th_Hole_5_10.JPG\",\"/brandCategory/1584859378644_17th_Hole_1_3.JPG\",\"/brandCategory/1584859378663_Clock_2_6.JPG\",\"/brandCategory/1584859378687_18th_Hole_5_9.JPG\",\"/brandCategory/1584859378761_Sven_Bunker_1_KM_8.JPG\"],\"isRedemptionAllowed\":1,\"courseListingImg\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brandCategory/1617692141395_trump_dubai_17th_behind_6005_web.jpg\",\"maintenanceDays\":[],\"playerTypeList\":[{\"isDefault\":false,\"isDynamic\":false,\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\"}],\"coursePlayerList\":[],\"clubName\":\"Trump International Golf Club\"}],\"playerTypeList\":[{\"playerTypeID\":1088,\"playerTypeName\":\"Viya Golf\",\"isDefault\":false,\"isDynamic\":false,\"isWebDefaultPlayer\":true},{\"playerTypeID\":1090,\"playerTypeName\":\"Viya Golf Dynamic\",\"isDefault\":false,\"isDynamic\":true,\"isWebDefaultPlayer\":false}],\"brandList\":[{\"clubName\":\"Emirates Golf Club\",\"content\":\"Emirates Golf Club was the first grass course in the region and with 31 years of experience it is the most established in the Middle East. Through its premier facilities and golf academy, the Emirates Golf Club remains at the forefront of golfing development\",\"clubImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brand/EGC_Par_3.jpg\",\"latitude\":\"25.08586647814732\",\"longitude\":\"55.159406731228124\",\"websiteUrl\":\"https://www.dubaigolf.com/emirates-golf-club.aspx\",\"contact\":\"971504539265\"},{\"clubName\":\"Jumeirah Golf Estates\",\"content\":\"Jumeirah Golf Estates is a world-class golf destination offering state-of-the-art leisure facilities amidst two internationally-acclaimed championship golf courses, creating an unmatched lifestyle experience in the heart of new Dubai. Set across 1,119 hectares of lush green landscape, the development is an unrivalled destination offering world-class amenities.\",\"clubImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brand/Jumeirah_earth_course.jpg\",\"latitude\":\"25.021045\",\"longitude\":\"55.199975\",\"websiteUrl\":\"https://www.dubaigolf.com/jumeirah-golf-estates/\",\"contact\":\"97143174515\"},{\"clubName\":\"Dubai Golf and Yacht Club\",\"content\":\"Dubai Golf and Yacht Club\",\"clubImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brand/1612261963461_golf.jpeg\",\"latitude\":\"25.243985\",\"longitude\":\"55.334037\",\"websiteUrl\":\"https://www.jaresortshotels.com/dubai/ja-the-resor\",\"contact\":\"97142054666\"},{\"clubName\":\"Trump International Golf Club\",\"content\":\"The Championship style, 18- Hole golf course designed by world- renowned architect Gil Hanse, provides a one of a kind experience for golfers of all skill levels.\\n\\nRouted over 500 acres, Trump International Golf Club has become a pre-eminent destination in the golf world. \\n\\nAspects of the design blended with the desert climate work in cohesion to provide a special golf experience and a true test of the game.\\n\\nThe many layers of the course are key to developing play strategy and increasingly unveil themselves as golfer's progress through all 18 holes.\",\"clubImage\":\"https://waslbucketuat.blob.core.windows.net/wsstore/brand/1578835594783_Trump.jpg\",\"latitude\":\"27.311995\",\"longitude\":\"54.550835\",\"websiteUrl\":\"https://www.trumpgolfdubai.com/tee-times\",\"contact\":\"971889292929\"}],\"couponDetails\":null,\"holes\":[18,9],\"serverCurrentTime\":\"2022-09-01 17:32:29\"}";
		org.json.JSONObject json = new org.json.JSONObject(s);
		org.json.JSONArray courseList = (org.json.JSONArray) json.get("courseList");
		System.out.println(json.get("courseList"));
		Iterator<Object> iterator = courseList.iterator();
		while (iterator.hasNext()) {
			org.json.JSONObject jsonChildObject = (org.json.JSONObject) iterator.next();
			System.out.println(jsonChildObject.get("courseID"));
			String bigid = jsonChildObject.get("courseID").toString();
			if (bigid.compareTo("97101-201-0000000013") == 0) {
				 id = (int) jsonChildObject.get("courseOid");
				System.out.println(id);
			}
		}
		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonnew = (org.json.simple.JSONObject) parser.parse(json.toString());
		Object jsonobj=null;
//		JSONArray jsonobj1 =(org.json.simple.JSONArray) jsonnew.get("courseList");
//			if((int)jsonobj1.get(2)==id){	
//			jsonobj1.;
//		}
		
		// jsonnew.
		return new ResponseEntity<Object>(jsonnew, HttpStatus.OK);
	}


	@Scheduled(cron = "0 0 17 5 9 *")
	public void schedule() {
		try {
			Calendar thisdate= Calendar.getInstance();
		String date=thisdate.getTime().toString();
			
			LOGGER.info("sheduler started at "+date);			
		int i=walletrepo.scheduledcashback(fromdate,todate, CBpercent, cashbackupto, expirydate);
		System.out.println(i);
		LOGGER.info("the total no of user "+i);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	TranscationRepo transrepo;
	
	
	@Override
	public ResponseEntity<Object> placeOrder(OrderBean data) {	
		try {
		orders order = new orders();
		order.setcreationBy("admin");
		order.setModifiedBy("admin");
		order.setItemname(data.getItemname());
		order.setDate(Calendar.getInstance().getTime());
		order.setUserid(userrepo.getById((long)data.getUserid()));
		order.setAmount(data.getAmount());
		order.setNo_of_item(data.getNo_of_item());
		
		Transactions transcantion = new Transactions();
		transcantion.setBILL_AMOUNT(CBpercent);
		transcantion.setDISCOUNT_AMOUNT(CBpercent);
		transcantion.setPAID_AMOUNT(CBpercent);
		transcantion.setT_DATE(Calendar.getInstance().getTime());
		transcantion.setTRANSCATION_STATUS(data.getTRANSCATION_STATUS());
		
		
		order.setTRANSACTIONS_ID(transcantion);
		
		return new ResponseEntity<Object>(orderRepo.save(order), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
