package com.mycompany.myapp8;

//      https://easyodds.com/football/india/jamshedpur-v-chennaiyin/full-time-result/3638510

//
// TODO:
// See below...
/*
 
 
*/
//
//You can use any Web Scraper/Crawler API to fetch data from web site.
//
//For example: JSOUP API For Java And Android
//
//Update
//
//Step By Step guide to solve the mentioned problem
//
//Add Jsoup dependency to the app level of your build.gradle.
//implementation 'org.jsoup:jsoup:1.11.1'
//
//Add Internet permission to the Android Manifest file for internet access.
//<uses-permission android:name="android.permission.INTERNET" />
//
//Add button and text view in your app to get data from website on button click and display the result on text view.
//Below is the sample code:
//

// Sample code my arse! This is my half 
//  arsed effort...

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
//import org.jsoup.*;
//import org.jsoup.parser;
import org.jsoup.parser.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

// import org.jsoup.internal;

import org.jsoup.internal.*;
import java.io.*;
import android.text.method.*;
import java.util.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;



//import org.apache.commons.*;

//import org.apache.commons.lang3.StringUtils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.util.*;
import android.content.Context;
// import core.util.StringUtils;

public class MainActivity extends Activity
{

	Context context = this;
	String[] splitsTemp; // = new String[0];

	final static String  allDOM = " Sports Casino EasyOdds sports Home Betting Tips All Sports Free Bets Search " +
	"Football HomeTournamentsTeamsFootball TipsLive StreamingShow All Home Betting Tips All Sports " +
	"Free Bets Search EasyOdds sports EasyOddsCasino Home Betting Tips Free Bets Promo Codes Bookmaker " +
									"Reviews Betting Guides Live Streaming Browse by Sports FootballHorse RacingTennisBoxing & " +
	"UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce " +
	"HockeyAussie Rules FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor " +
	"SportBasketballBaseballCyclingHandballIce HockeyAussie Rules Odds format Fractional Decimal American Location United KingdomChange" +
	"English, GMT, GBP Apply Cancel Changes Location (see Odds and Offers for) Australia Austria Brazil Finland Germany Greece India " +
	"Ireland Italy Kenya New Zealand Nigeria Norway Poland Russia South Africa Spain Sweden Switzerland United Kingdom World Time " +
	"Zone Select a timezone { GMT-12:00 International Date Line West { GMT-11:00 Midway Island, Samoa { GMT-10:00 Hawaii { GMT-9:00 Alaska" +
	"{ GMT-8:00 Pacific Time (US & Canada), Tijuana { GMT-7:00 Arizona, Mountain Time (US & Canada), Chihuahua, M... { GMT-6:00 Central Time" +
	"(US & Canada), Central America, Guada... { GMT-5:00 Eastern Time (US & Canada), Indiana (East), Bogota... { GMT-4:00 Atlantic Time (Canada), " +
	"Caracas, La Paz, Santiago { GMT-3:30 Newfoundland { GMT-3:00 Brasilia, Buenos Aires, Georgetown, Greenland { GMT-2:00 Mid-Atlantic " +
	"{ GMT-1:00 Azores, Cape Verde Is. { GMT Dublin, Edinburgh, London, Lisbon, Monrovia { GMT+1:00 Amsterdam, Berlin, Brussels, Madrid, " +
	"Paris, Rome,... { GMT+2:00 Athens, Bucharest, Cairo, Helsinki, Istanbul, Mins... { GMT+3:00 Baghdad, Kuwait, Moscow, Nairobi, St. Petersburg " +
	"{ GMT+3:30 Tehran { GMT+4:00 Abu Dhabi, Baku, Muscat, Tbilisi, Yerevan { GMT+4:30 Kabul { GMT+5:00 Ekaterinburg, Islamabad, Karachi, Tashkent " +
	"{ GMT+5:30 Chennai, Kolkata, Mumbai, New Delhi { GMT+5:45 Kathmandu { GMT+6:00 Almaty, Astana, Dhaka, Novosibirsk, Sri Jayawarden... { GMT+6:30 Rangoon" +
	"{ GMT+7:00 Bangkok, Hanoi, Jakarta, Krasnoyarsk { GMT+8:00 Beijing, Chongqing, Hong Kong, Kuala Lumpur, Perth... { GMT+9:00 Osaka, Sapporo, Seoul, " +
	"Tokyo, Yakutsk { GMT+9:30 Adelaide, Darwin { GMT+10:00 Brisbane, Canberra, Guam, Hobart, Melbourne, Port... { GMT+11:00 Magadan, New Caledonia, Solomon Is. " +
	"{ GMT+12:00 Auckland, Fiji, Kamchatka, Marshall Is., Wellingto... { GMT+13:00 Nuku'alofa Currency { AUD Australian Dollar { BRL Brazilian Real { CHF Swiss Franc " +
	"{ EUR Euro { GBP Pound Sterling { INR Indian Rupee { KES Kenyan Shilling { NGN Nigerian Naira { NOK Norwegian Krone { PLN Polish Zloty { RUB Russian Ruble " +
	"{ SEK Swedish Krona { USD US Dollar { ZAR South African Rand Apply Cancel Changes Football Betting Odds Premier LeagueChampionshipEuro 2024UEFA Champions " +
	"LeagueLa LigaBundesligaSee All Tournaments Featured Matches Today / 19:45 Euro 2024 5/1 Greece 8/13 France 3/1 Draw Today / 19:45 Euro 2024 90/1 Gibraltar " +
	"1/100 Netherlands 40/1 Draw Today / 19:45 Euro 2024 1/6 Croatia 18/1 Armenia 7/1 Draw Today / 19:45 Euro 2024 6/4 Wales 2/1 Turkey 5/2 Draw Today / 19:45 Euro " +
	"2024 11/4 Romania 21/20 Switzerland 5/2 Draw Today's Offers 10% Cashback on ALL Losses Sign up and place a bet to earn 10% cashback on any lost bets. Cashback " +
	"is cash without restrictions. No Max cashout. New18+ customers only. T&Cs apply. Gambling can be addictive, please play responsibly. BeGambleAware.org. #ad " +
	"Claim Offer Bet £10. Get £30 in FREE Bets 18+ New customers only. Opt in, bet £10 at odds 2.00+ within 7 days, no cashout. Get 6x £5 Free Bets, set events at " +
	"odds 2.00+. 7 day bonus expiry. Debit Card / Apple Pay payments only. T&Cs apply. Gamble Responsibly. BeGambleAware.org. #ad Claim Offer Football - Bet £10 " +
	"Get £30 18+ New customers only. Opt in, and bet £10 on football markets (odds 2.00+). No cash out. Get 6x£5 football free bets at specified odds for set " +
									"markets, which expire after 7 days. Offer valid from 12:00 UK";
	// allTextElems ==== Sports Casino EasyOdds sports Home Betting Tips All Sports Free Bets Search Football HomeTournamentsTeamsFootball TipsLive StreamingShow All Home Betting Tips All Sports Free Bets Search EasyOdds sports EasyOddsCasino Home Betting Tips Free Bets Promo Codes Bookmaker Reviews Betting Guides Live Streaming Browse by Sports FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules Odds format Fractional Decimal American Location United KingdomChange English, GMT, GBP Apply Cancel Changes Location (see Odds and Offers for) Australia Austria Brazil Finland Germany Greece India Ireland Italy Kenya New Zealand Nigeria Norway Poland Russia South Africa Spain Sweden Switzerland United Kingdom World Time Zone Select a timezone { GMT-12:00 International Date Line West { GMT-11:00 Midway Island, Samoa { GMT-10:00 Hawaii { GMT-9:00 Alaska { GMT-8:00 Pacific Time (US & Canada), Tijuana { GMT-7:00 Arizona, Mountain Time (US & Canada), Chihuahua, M... { GMT-6:00 Central Time (US & Canada), Central America, Guada... { GMT-5:00 Eastern Time (US & Canada), Indiana (East), Bogota... { GMT-4:00 Atlantic Time (Canada), Caracas, La Paz, Santiago { GMT-3:30 Newfoundland { GMT-3:00 Brasilia, Buenos Aires, Georgetown, Greenland { GMT-2:00 Mid-Atlantic { GMT-1:00 Azores, Cape Verde Is. { GMT Dublin, Edinburgh, London, Lisbon, Monrovia { GMT+1:00 Amsterdam, Berlin, Brussels, Madrid, Paris, Rome,... { GMT+2:00 Athens, Bucharest, Cairo, Helsinki, Istanbul, Mins... { GMT+3:00 Baghdad, Kuwait, Moscow, Nairobi, St. Petersburg { GMT+3:30 Tehran { GMT+4:00 Abu Dhabi, Baku, Muscat, Tbilisi, Yerevan { GMT+4:30 Kabul { GMT+5:00 Ekaterinburg, Islamabad, Karachi, Tashkent { GMT+5:30 Chennai, Kolkata, Mumbai, New Delhi { GMT+5:45 Kathmandu { GMT+6:00 Almaty, Astana, Dhaka, Novosibirsk, Sri Jayawarden... { GMT+6:30 Rangoon { GMT+7:00 Bangkok, Hanoi, Jakarta, Krasnoyarsk { GMT+8:00 Beijing, Chongqing, Hong Kong, Kuala Lumpur, Perth... { GMT+9:00 Osaka, Sapporo, Seoul, Tokyo, Yakutsk { GMT+9:30 Adelaide, Darwin { GMT+10:00 Brisbane, Canberra, Guam, Hobart, Melbourne, Port... { GMT+11:00 Magadan, New Caledonia, Solomon Is. { GMT+12:00 Auckland, Fiji, Kamchatka, Marshall Is., Wellingto... { GMT+13:00 Nuku'alofa Currency { AUD Australian Dollar { BRL Brazilian Real { CHF Swiss Franc { EUR Euro { GBP Pound Sterling { INR Indian Rupee { KES Kenyan Shilling { NGN Nigerian Naira { NOK Norwegian Krone { PLN Polish Zloty { RUB Russian Ruble { SEK Swedish Krona { USD US Dollar { ZAR South African Rand Apply Cancel Changes Football Betting Odds Premier LeagueChampionshipEuro 2024UEFA Champions LeagueLa LigaBundesligaSee All Tournaments Featured Matches Today / 19:45 Euro 2024 5/1 Greece 8/13 France 3/1 Draw Today / 19:45 Euro 2024 90/1 Gibraltar 1/100 Netherlands 40/1 Draw Today / 19:45 Euro 2024 1/6 Croatia 18/1 Armenia 7/1 Draw Today / 19:45 Euro 2024 6/4 Wales 2/1 Turkey 5/2 Draw Today / 19:45 Euro 2024 11/4 Romania 21/20 Switzerland 5/2 Draw Today's Offers 10% Cashback on ALL Losses Sign up and place a bet to earn 10% cashback on any lost bets. Cashback is cash without restrictions. No Max cashout. New18+ customers only. T&Cs apply. Gambling can be addictive, please play responsibly. BeGambleAware.org. #ad Claim Offer Bet £10. Get £30 in FREE Bets 18+ New customers only. Opt in, bet £10 at odds 2.00+ within 7 days, no cashout. Get 6x £5 Free Bets, set events at odds 2.00+. 7 day bonus expiry. Debit Card / Apple Pay payments only. T&Cs apply. Gamble Responsibly. BeGambleAware.org. #ad Claim Offer Football - Bet £10 Get £30 18+ New customers only. Opt in, and bet £10 on football markets (odds 2.00+). No cash out. Get 6x£5 football free bets at specified odds for set markets, which expire after 7 days. Offer valid from 12:00 UK";
	
	
	private static final String TAG_INFO = "info:..";
	private Elements elementsAll;
	private Elements elementsAllChildren = new Elements();
	
    private TextView result;
    private Button fetch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        result = (TextView) findViewById(R.id.result);
		result.setMovementMethod(new ScrollingMovementMethod());

        fetch = (Button) findViewById(R.id.fetch);
		
		
	//	localTest();
		
		
		
        fetch.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					
					
					System.out.println("click");
					Log.i(TAG_INFO, "Click");
					
					
					
					getBodyText();
				}
			});
			
			
		
    }
	
	StringBuilder builder = new StringBuilder();
	
    private void getBodyText() {
        new Thread(new Runnable() {
				@Override
				public void run() {
		//			StringBuilder builder = new StringBuilder();



					
					Double a[] = {2d,2d,2d};




					try {
						//			String url="https://www.oddschecker.com/football/english/premier-league/brighton-v-liverpool/winner";//your website url

						//		String url="https://www.poetryfoundation.org/poems/48860/the-raven";//your website url
						String url;
						url="https://www.oddschecker.com/";// NB: oddschecker seems to have anti-scraping shit: Workaround pain in arse
						url = "https://www.oddschecker.com/cheltenham-festival";

						url = "https://easyodds.com/";
						url = "https://easyodds.com/football";

						// https://easyodds.com/
						
						
						Connection con = Jsoup.connect(url);
						System.out.println("CCOnn");
						Log.i(TAG_INFO, "Connection");

						con.ignoreHttpErrors(true);
						System.out.println("ignor");
						Log.i(TAG_INFO, "Ignor http errors");
						

						Document doc = con.get();
						System.out.println("get");
						Log.i(TAG_INFO, "Get Document");
						builder = calcOdds(doc);

					} catch (IOException e) {


						builder.append("IOException: " + e.getMessage());

						Log.e(TAG_INFO, e.getMessage());
						Log.i(TAG_INFO, "Attempt to read Document from File");
						
						String readString = readFromFile(context);
						System.out.println("readString===" + readString);
						
	
						buildMap(readString);
						
						
					}

					runOnUiThread(new Runnable() {
							@Override
							public void run() {
								result.setText(builder.toString());
							}
						});
				}
			}).start();
    }
	
	
	private void buildMap(String allText){
		ArrayList matches = new ArrayList();
		ArrayList<String> matchesList = new ArrayList<String>();
		ArrayList<String> resultsList = new ArrayList<String>();
		ArrayList<String> bookiesList = new ArrayList<String>();
		ArrayList<String> oddsList = new ArrayList<String>();
		
		
		
		String matchRegEx = "data-event-name=\"";
		String resultRegEx = "data-selection-name=\"";
		String bookieRegEx = "data-partner-name=\"";
		String oddsRegEx = "data-fraction=\"";
		
		
		
		
		System.out.println("buildList call...");
		Log.i(TAG_INFO, "buildMatchesList call...");
		matchesList = buildMatchesList(allText, matchRegEx);
	
	//
//		int i = 0;
//		for (String m : matchesList){
//			if (i > 20){continue;}
//			System.out.println((i++) + ": matchesList = " + m);
//		}
	//
	
		Log.i(TAG_INFO, "buildList(data-selection-name) call...");
		resultsList = buildList(allText, resultRegEx);
		
		//
//		i = 0;
//		for (String m : resultsList){
//			if (i > 20){continue;}
//			System.out.println((i++) + ": resultsList = " + m);
//		}
		//
		Log.i(TAG_INFO, "buildList(bookieRegEx) call...");
		bookiesList = buildList(allText, bookieRegEx);
		//
//		i = 0;
//		for (String m : bookiesList){
//			if (i > 20){continue;}
//			System.out.println((i++) + ": bookiesList = " + m);
//		}
		//
		
		Log.i(TAG_INFO, "buildList(data-oddsRegEx) call...");
		oddsList = buildList(allText, oddsRegEx);
		
		//
//		i = 0;
//		for (String m : oddsList){
//			if (i > 20){continue;}
//			System.out.println((i++) + ": oddsList = " + m);
//		}
		//
	
		Map<String, String> matchesResultsMap = new HashMap<String, String>();
		Map<String, String> resultsBookiesMap = new HashMap<String, String>();
		Map<String, String> bookiesOddsMap = new HashMap<String, String>();
		
		Iterator matchesIt = matchesList.iterator();
		Iterator resultsIt = resultsList.iterator();
		Iterator bookiesIt = bookiesList.iterator();
		Iterator oddsIt = oddsList.iterator();
		int ix = 0;
		
		while (matchesIt.hasNext()){
			String tmp1 = (String) matchesIt.next();
			String tmp2 = "";
			if (matchesIt.hasNext()){
				tmp2 = (String) matchesIt.next();
			}else{
				break;
			}
			String tmp3 = "";
			if (matchesIt.hasNext()){
				tmp3 = (String) matchesIt.next();
			}else{
				break;
			}
			
			if (tmp1.equals(tmp2) && tmp2.equals(tmp3)){
				String nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp1, nextResult);
				String nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				String nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);
				
				System.out.println(tmp1 + " > " + nextResult + " > " + nextBookie + " > " + nextodds);
				
				nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp2, nextResult);
				nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);


				System.out.println(tmp1 + " > " + nextResult + " > " + nextBookie + " > " + nextodds);
				
				
				nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp3, nextResult);
				nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);
				

				System.out.println(tmp1 + " > " + nextResult + " > " + nextBookie + " > " + nextodds);
				System.out.println("____");
			}
			
//			showMap(matchesResultsMap);
//			showMap(resultsBookiesMap);
//			showMap(bookiesOddsMap);
			
		}
		/*
		TODO:
		 If matchesList[0]==[1]==[2]:    =>>(maps to) 
		 	match =>> Result =>> Bookie =>> odds
		 0: data-event-name =>>  data-selection-name =>>  data-partner-name =>>  data-fraction
		 1: data-event-name =>>  data-selection-name =>>  data-partner-name =>>  data-fraction
		 2: data-event-name =>>  data-selection-name =>>  data-partner-name =>>  data-fraction
		 Repeat for matchesList[n+0]==[n+1]==[n+2]... n+=3
		*/
/*
		 data-event-name="Rennes v Villarreal" 
		 data-market-name="Full Time Result" 
		 data-selection-name="Rennes" 
		 data-partner-name="10Bet" 
		 data-fraction="11/10" data-decimal="2.10"> 11/10 </span> | 1 <|||> 4 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603342536" data-market-id="23" data-event-id="3627821" data-partner-id="452" 
		 data-event-name="Rennes v Villarreal" 
		 data-market-name="Full Time Result"
		 data-selection-name="Villarreal" 
		 data-partner-name="PariMatch" 
		 data-fraction="27/10" data-decimal="3.70"> 27/10 </span> | 1 <|||> 5 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13598016986" data-market-id="23" data-event-id="3627821" data-partner-id="13" 
		 data-event-name="Rennes v Villarreal" 
		 data-market-name="Full Time Result" 
		 data-selection-name="Draw" 
		 data-partner-name="bet365" 
		 data-fraction="14/5" data-decimal="3.80"> 14/5 </span> | 1 <|||> 6 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600071172" data-market-id="23" data-event-id="3627822" data-partner-id="41" 
		 
*/
		
	}
	
	private ArrayList<String> buildList(String allText, String regExp) {



		ArrayList<String> list = new ArrayList<String>();

		

		int nx = 0;

		String[] splitText = allText.split(regExp);

		splitText = Arrays.copyOfRange(splitText, 1, splitText.length);
	//	System.out.println("splitText len = " + splitText.length);
		String[] splitList = new String[splitText.length + 1];


	//	for (String text : splitText){
		for (String text : splitText){
				

	//		System.out.println((nx) + ": " + text);
			
			int end = text.indexOf("\"");
			splitList[nx] = text.substring(0, end);

	//		System.out.println((nx) + ": " + splitList[nx]);

			list.add(splitList[nx]);

			nx++;
		}


		

		System.out.println("List: " + list);
		




		return list;

	}
	
	
	private ArrayList<String> buildMatchesList(String allText, String regExp) {
	
	

		ArrayList<String> list = new ArrayList<String>();
		
		
		int nx = 0;
		
	
		String[] splitText = allText.split(regExp);
		
		System.out.println("elems2 len = " + splitText.length);
		String[] splitList = new String[splitText.length + 1];
		
		
		for (String text : splitText){
	
			System.out.println((nx) + ": " + text);
	
			/*
			TODO:
			Check:
			After " immeadiatly followed by...
			 " data-market-name="Full Time Result" 
			else skip (continue;) loop
			
			Also repeats?
			*/
			String[] marketText = new String[2];
			if (regExp == "data-event-name=\""){
				String market = "data-market-name=\"";
		//		String[]
				marketText = text.split(market);
			}
//			System.out.println("s[]=" + marketText);
//			for (String ss : marketText){
//				System.out.println("s[[]=" + ss);
//			}
	//		System.out.println("s[1]=" + marketText[marketText.length - 1]);
			if (!marketText[marketText.length - 1].startsWith("Full Time Result")){
				System.out.println("s[1]=" + marketText[marketText.length - 1]);
				
				continue;
			}
			
			
			if (nx == 0){
		//		nx++; 
		//		continue;
			}
			int end = text.indexOf("\"");
			splitList[nx] = text.substring(0, end);
	
	//		System.out.println((nx) + ": " + oddsFractionList[nx]);
	
			list.add(splitList[nx]);
			
			nx++;
		}
		
		
		System.out.format("oddsFractionList === [%s]\n", splitList);
		System.out.println("oddsFractionList === " + splitList);
		System.out.format("oddsFractionList === [%s]\n", splitList);
		
//		for (String fracs : splitList){
//	//		System.out.println("fraca=" + fracs);
//		}
		
		System.out.println("List: " + list);
		for (String s : list){
	//		System.out.println(s);
		}
		
		
		

		return list;

	}
	
	
	
	
	
	
	StringBuilder calcOdds(Document doc){
		
		StringBuilder builder = new StringBuilder();
		
		
		String[] temps = new String[3];
		Double[] tempd = new Double[3];
		List<Double[]> trips = new ArrayList<Double[]>();
		List<String[]> odds = new ArrayList<String[]>();
		
		

		elementsAll = doc.body().select("*");
		elementsAll = doc.body().select("*:matches(^[0-9]*/[0-9]*$)");


		String allAsText = listChildren(elementsAll);
		writeToFile(allAsText, context);

		String elementsAllText = elementsAll.text();



		System.out.println("elms sz = "+ elementsAll.size());
		System.err.println("elms sz = "+ elementsAll.size());


//						String allText = doc.toString();
//						System.err.println("*********************");
//						System.out.println("*********************");
//						
//						allText = allText.replaceAll("\\s", "");
//						System.out.println(elementsAllText);
//					
//						System.out.println("*********************");
//						System.err.println("*********************");

		System.out.println("call: listMatches(elementsAllText)--nb: with white space");
		listMatches(elementsAllText);
		System.out.println("return: listMatches(elementsAllText)");




		int nix = 0;

		Elements elemsAll = doc.body().select("*:matches(Italy)");
		//	Elements elemsAll = doc.body().select("*:matches(Italy)");
		//		Elements elemSingle = doc.body().select("*:matches(Serbia)");
		//			Elements elemSingle = doc.body().select("*:matches(Armenia)");


		//	elemsAll[18] = "";


		elemsAll.size();



		String allTextElems = elemsAll.text();

		System.err.println("0 ==== " + allTextElems);

		String namesAndOddEtc = "";
		

		System.err.println("namesAndOddEtc === " + namesAndOddEtc);


		System.out.println("allDOM === " + allDOM);
		System.err.println("allDOM === " + allDOM);

		String readString = readFromFile(context);
		System.out.println("readString===" + readString);


		Element names = doc.select("className.side-name").first();
		// div with class=masthead



		//			Elements elems2 = doc.body().select("*:contains(d)");
		//		Elements elems2 = doc.body().select("*:matches(/)");
		//		Elements elems2 = doc.body().select("*:matches([0-9]/|(Draw))");
		//	Elements elems2 = doc.body().select("*:matches(^[0-9]*/[0-9]*$|(Draw))");
		Elements elems2 = doc.body().select("*:matches(^[0-9]*/[0-9]*$)");


		int nx = 0;
		for (Element elementOdds : elems2) {
			String s = elementOdds.ownText();
			//				System.out.println((nx++) + " | " + s);
		}


		int n = 0;
//						temps = new String[3];
//						tempd = new Double[3];
		for (Element element : elems2) {

			double r = 0;
			String s = element.ownText();
//							temps = new String[3];
//							tempd = new Double[3];
			if (!s.isEmpty()){
				r = parse(s);
				int ix = n % 3;
				if (ix==0){
					temps = new String[3];
					tempd = new Double[3];
					temps[0] = s;
					tempd[0] = r;
				}
				if (ix==1){
					temps[1] = s;
					tempd[1] = r;
				}
				if (ix==2){
					temps[2] = s;
					tempd[2] = r;
					Arrays.sort(tempd);
					trips.add(tempd);
					temps = sortOdds(temps);
					odds.add(temps);
				}



//								System.out.print(ix + "ix ===" + n);
//						
//								System.err.print(element.ownText() + "=element.ownText() String ==" + s);
//								System.err.print(element.ownText() + "=element.ownText() parsed ==" + r);

				System.out.print(ix + "ix ===" + n);

				System.err.print(element.ownText() + "=element.ownText() String ==" + s);
				System.err.print(element.ownText() + "=element.ownText() parsed ==" + r);

				n++;	
			}


		}

		for (int i = 0; i < trips.size();i++) 
		{ 		      
			//		System.out.println(trips.get(i)); 	
			Double[] t = trips.get(i);
			String[] s = odds.get(i);
			double min = t[0];
			double oddsl = t[1];
			double oddsh = t[2];
			double winMin = 100 * min;
			double totStake = 100 + winMin;
			double tot = winMin / (oddsl +  oddsh);
			double stakel = oddsl * tot;
			double stakeh = oddsh * tot;

			double stake1 = totStake / (1 + oddsl);
			double stake2 = totStake - 100 - stake1;

			double win1 = (1 + oddsl) * stake1;
			double win2 = (1 + oddsh) * stake2;

			double winA = stakel * (1 + oddsh);
			double winB = stakeh * (1 + oddsl);




//							System.out.println(t[0] + "|||" + t[1] + "|||" + t[2]);
//							System.out.println(s[0] + "|||" + s[1] + "|||" + s[2]);
//
//							System.out.println("100.00"  + "|||" + stake1 + "|||" + stake2);
//									System.out.println(winMin  + "|||" + winA + "|||" + winB);
//							System.out.println(winMin  + "|||" + win1 + "|||" + win2);
//							System.out.println("____________________");
//





			if (win2 > win1){
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			}
			builder.append((s[0] + "|||" + s[1] + "|||" + s[2])).append("\n");
			builder.append(("100.00"  + "|||" + stake1 + "|||" + stake2)).append("\n");
			builder.append((winMin  + "|||" + win1 + "|||" + win2)).append("\n");
			builder.append(("____________________")).append("\n");

			if (win2 > win1){
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			}



		}   

		//	Document doc = Jsoup.connect(url).get();

		//		Element body = doc.body();
		//		builder.append(body.text());


		//		Document doc = Jsoup.connect("https://stackoverflow.com/questions/11970938/java-html-parser-to-extract-specific-data").get();
		//		Elements spans = doc.select("span[class=hidden-text]");
		//		for (Element span: spans) {
		//			System.out.println(span.text());
		//		}


//		Element body = doc.body();

		//		builder.append("b.xxx");
		//		builder.append(body.text());

		//		System.out.println(body.text());
		
		return builder;
		
	}

	double parse(String ratio) {
	//	System.out.println("ratio to parse === " + ratio);
		if (ratio.contains("/")) {
			String[] rat = ratio.split("/");
			return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
		} else {
			return Double.parseDouble(ratio);
		}
	}

	private String[] sortOdds(String s[]){
		if (parse(s[0]) > parse(s[1])){
			String tmp =s[0];
			s[0] = s[1];
			s[1] = tmp;
		}
		if (parse(s[1]) > parse(s[2])){
			String tmp =s[1];
			s[1] = s[2];
			s[2] = tmp;
		}
		if (parse(s[0]) > parse(s[1])){
			String tmp =s[0];
			s[0] = s[1];
			s[1] = tmp;
		}
		return s;
	}
	
	
	
	
	
	private ArrayList<String> listMatches(String DOMString){

		ArrayList<String> matchsList = new ArrayList<String>();
		


		int namesEndPos = -1;
		int oddsPos = -1;
		int nextNamesEndPos = -1;
		int nextOddsPos = -1;
		Pattern oddsPattern = Pattern.compile("([0-9]{1,4}/[0-9]{1,4})");  // Find odds ie. 2/11 or 99/1 etc
		Pattern endPattern = Pattern.compile("Draw");  // Find the word "Draw". Name pairs (matches) end with this

		Pattern urlFindPattern = Pattern.compile("1");  // XXXX-= Find the word "Draw". Name pairs (matches) end with this
		Matcher urlMatch = urlFindPattern.matcher(elementsAll.text());
		

		Pattern hrefPattern = Pattern.compile("href");  // XXXX-= Find the word "Draw". Name pairs (matches) end with this
		Matcher hrefMatch = hrefPattern.matcher(elementsAll.text());
		
		
		System.out.println("...  hrefMatch.toString..." + hrefMatch.toString());
		
		
		
//		
////		System.out.println(elementsAll.ownText() + "===" + urlMatch.);
////		System.out.println("... element.id())..." + urlMatch..id());
////		System.out.println("... element.tagName())..." + urlMatch.tag);
////		System.out.println("... element.tag())..." + elementsAll.tag());
////		System.out.println("... element.className())..." + urlMatch.classNames.className());
		System.out.println("... element.data())..." + urlMatch.toString());
//	//	System.out.println("... element.cssSelector())..." + urlMatch.group());   //.cssSelector());
//		System.out.println("... element.attributes())..." + urlMatch.groupCount());    //.attributes());
//		System.out.println("... element.classNames())..." + urlMatch.hasAnchoringBounds());    //.classNames());
//		System.out.println("... element.text())..." + urlMatch.end());    //.text());
//		System.out.println("... element.ownText())..." + urlMatch.find());    //.ownText());
//		System.out.println("... element.nodeName())..." + urlMatch.hitEnd());    //.nodeName());
//
//		System.out.println("... element.outerHtml())..." + urlMatch.lookingAt());    //.outerHtml());
//		System.out.println("... element.hasText())..." + urlMatch.matches());    //.hasText());
//		System.out.println("... element.hasText())..." + urlMatch.pattern());    //.hasText());
//
//		System.out.println("... element.text().length(.." + urlMatch.regionEnd());    //.text().length());
//		System.out.println("... element.text().length(.." + urlMatch.regionStart());    //.text().length());
//		System.out.println("... element.text().length(.." + urlMatch.requireEnd());    //.text().length());
//		System.out.println("... element.text().length(.." + urlMatch.start());    //.text().length());
//		System.out.println("... element.text().length(.." + urlMatch.toMatchResult());    //.text().length());
//		System.out.println("... element.text().length(.." + urlMatch.toString());    //.text().length());
//	//	System.out.println("... element.text().length(.." + urlMatch.regionStart());    //.text().length());
//		
//		
//		
//		
//		System.out.println("... element.text().length(.." + urlMatch.reset());    //.text().length());
//		
//	//	 System.out.println(element.ownText() + "===" + r);
//		 
		
		
		
		
		
		
		
		Matcher oddsMatch = oddsPattern.matcher(DOMString);




		if (oddsMatch.find()) {
			oddsPos = oddsMatch.start();
		}
		String tmpNew = DOMString.substring(oddsPos);

		
		
//		System.out.println("________");
//		System.out.println("________");
//		System.out.println("________");
		System.out.println("________");
		System.err.println("tmpNew === " + tmpNew);
		System.out.println("________");
		
		
		Matcher endMatch = endPattern.matcher(tmpNew);
		if (endMatch.find()) {
			namesEndPos = endMatch.start();
		}
		String nextNew = "";
		if (namesEndPos > 0){
			tmpNew.substring(0, namesEndPos);
			
		}else{
			namesEndPos = tmpNew.length();
			tmpNew.substring(0, namesEndPos);
			
		}
		
		
		
//		System.out.println(oddsPos + "< oddsPos ||| " + nextNew + "  namesEndPos > " + namesEndPos);
//
//		System.out.println("________");
//		System.out.println("________");

		
		String nextAll = tmpNew.substring(namesEndPos);
		
		
		System.out.println("________");
		System.err.println("nxNew = " + nextNew + "____=____");
		System.out.println("________");
		System.err.println("nxAll = " + nextAll + "____=____");
		System.out.println("________");


		matchsList.add(nextNew);

		// TODO: WTF is with for loop!!!
		//	while (namesEndPos < DOMString.length()){
			for (int i = 0; i < 5; i++){


			oddsMatch = oddsPattern.matcher(nextAll);
			if (oddsMatch.find()) {
				oddsPos = oddsMatch.start();
				System.out.println("oddsMatch.find() : oddsPos === " + oddsPos);
			}else{
				System.out.println("oddsMatch.find() === " + oddsMatch.find());
			}
			tmpNew = nextAll.substring(oddsPos);

			endMatch = endPattern.matcher(tmpNew);
			if (endMatch.find()) {
				namesEndPos = endMatch.start();
			}else{
				System.out.println("endMatch.find() === " + endMatch.find());
				return matchsList;
			}


			nextNew = tmpNew.substring(0, namesEndPos);

			nextAll = tmpNew.substring(namesEndPos);


//			System.out.println("____tmpNew____");
//			System.err.println(tmpNew + "____=____");
//			System.out.println("___tmpNew___");
//			System.out.println("____nxtAll____");
//			System.err.println(nextAll + "____=____");
//			System.out.println("___nxtAll_____");


			matchsList.add(nextNew);

		}






		for (int i = 0; i < matchsList.size(); i++){
			System.out.println(i + " : " + matchsList.get(i));
		}


		//	String tmpName = 
		//	allDOM.substring(oddsPos, namesEndPos);
//	
//		System.out.println("tmpName === " + tmpName);

		return matchsList;
	}
	
	private Elements kidsE;
	private Elements allE;
	private int totalEs = 0;
	private StringBuilder allText = new StringBuilder();
	private StringBuilder allText2 = new StringBuilder();
	private StringBuilder allText3 = new StringBuilder();
	private String currentBitofText; // = new String();
	
	private String listChildren(Elements origPage){
		int count = 0;
		Iterator elementsIter = origPage.iterator();
		while (elementsIter.hasNext()){
			Element currentElem = (Element) elementsIter.next();
			allE = currentElem.getAllElements();
			kidsE = currentElem.children();
			
			elementsAllChildren.addAll(allE);
			
			currentBitofText = currentElem.text();
			allText.append(currentBitofText);
			
			Elements tmp = currentElem.getAllElements();
			currentBitofText = tmp.outerHtml();
			allText2.append(currentBitofText);
			
			currentBitofText = currentElem.html();		
			allText3.append(currentBitofText);
			
//			System.out.println((count) + ": getAllElements.size === " + allE.size() + 
//							   " ||| children.size === " + kidsE.size());
			totalEs += allE.size();
			
			System.out.print(count + " : " + allE + " | " + allE.size() + " <|||running total-> " + totalEs);
			count++;
			if (count % 10 == 0){
				System.out.println("__________");
			}
			
			}
		System.out.println(count + " < count : total n of Elements:" + totalEs);
		System.out.println("allText: " + allText);
		System.out.println("allText2: " + allText2);
		System.out.println("allText3: " + allText3);
		
		return allText2.toString();
	}
	
	
	
	private void writeToFile(String data,Context context) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		}
		catch (IOException e) {
			Log.e("Exception", "File write failed: " + e.toString());
		} 
	}
	
	
	
	private String readFromFile(Context context) {

		String ret = "";

		try {
			InputStream inputStream = context.openFileInput("config.txt");

			if ( inputStream != null ) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();

				while ( (receiveString = bufferedReader.readLine()) != null ) {
					stringBuilder.append("\n").append(receiveString);
				}

				inputStream.close();
				ret = stringBuilder.toString();
			}
		}
		catch (FileNotFoundException e) {
			Log.e("login activity", "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e("login activity", "Can not read file: " + e.toString());
		}

		return ret;
	}
	
	
	private void showMap(Map map){

		for (Map.Entry<String,String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " > " + value);
		}
		
	}

}


/*
String
text()
Gets the normalized, combined text 
of this element and all its children.

*/


/*                   
Edit
 <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243984" data-market-id="23" data-event-id="3627823" data-partner-id="482"
 data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" 
 data-selection-name="Sheriff Tiraspol"
 data-partner-name="SBK"
 data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 11 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243982" data-market-id="23" data-event-id="3627823" data-partner-id="482"
 data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result"
 data-selection-name="Draw"
 data-partner-name="SBK"
 data-fraction="39/5" data-decimal="8.80"> 39/5 </span>



span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243984" data-market-id="23" data-event-id="3627823" data-partner-id="482"

data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result"
data-selection-name="Sheriff Tiraspol"
data-partner-name="SBK"
data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 11 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243982" data-market-id="23" data-event-id="3627823" data-partner-id="482"
data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" 
data-selection-name="Draw"
data-partner-name="SBK"
data-fraction="39/5" data-decimal="8.80"> 39/5 </span> | 1 <|||> 12 




: <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13593225111" data-market-id="23" data-event-id="3627824" data-partner-id="117" 
data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" 
data-selection-name="Slavia Prague"
data-partner-name="Betway" 
data-fraction="4/11" data-decimal="1.36"> 4/11 </span> | 1 <|||> 13 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244982" data-market-id="23" data-event-id="3627824" data-partner-id="482" 
data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result"
data-selection-name="Servette"
data-partner-name="SBK" 
data-fraction="42/5" data-decimal="9.40"> 42/5 </span> | 1 <|||> 14 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244981" data-market-id="23" data-event-id="3627824" data-partner-id="482" 
data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" 
data-selection-name="Draw" 
data-partner-name="SBK" 
data-fraction="22/5" data-decimal="5.40"> 22/5 </span>




| 1 <|||> 15 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13593237224" data-market-id="23" data-event-id="3627823" data-partner-id="117" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Roma" data-partner-name="Betway" data-fraction="2/11" data-decimal="1.18"> 2/11 </span> | 1 <|||> 16 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243984" data-market-id="23" data-event-id="3627823" data-partner-id="482" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Sheriff Tiraspol" data-partner-name="SBK" data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 17 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243982" data-market-id="23" data-event-id="3627823" data-partner-id="482" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="39/5" data-decimal="8.80"> 39/5 </span> | 1 <|||> 18 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600074675" data-market-id="23" data-event-id="3627821" data-partner-id="41" data-event-name="Rennes v Villarreal" data-market-name="Full Time Result" data-selection-name="Rennes" data-partner-name="10Bet" data-fraction="11/10" data-decimal="2.10"> 11/10 </span> | 1 <|||> 19 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603342536" data-market-id="23" data-event-id="3627821" data-partner-id="452" data-event-name="Rennes v Villarreal" data-market-name="Full Time Result" data-selection-name="Villarreal" data-partner-name="PariMatch" data-fraction="14/5" data-decimal="3.80"> 14/5 </span> | 1 <|||> __________






==================================================================

 0 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600058061" data-market-id="23" data-event-id="3627819" data-partner-id="41" 
 data-event-name="Union Saint-Gilloise v Liverpool"
 data-market-name="Full Time Result"
 data-selection-name="Union Saint-Gilloise"
 data-partner-name="10Bet"
 data-fraction="9/5" data-decimal="2.80"> 9/5 </span> | 1 <|||> 1 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600248139" data-market-id="23" data-event-id="3627819" data-partner-id="482" 
 data-event-name="Union Saint-Gilloise v Liverpool" 
 data-market-name="Full Time Result" 
 data-selection-name="Liverpool" 
 data-partner-name="SBK"
 data-fraction="11/5" data-decimal="3.20"> 11/5 </span> | 1 <|||> 2 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600248138" data-market-id="23" data-event-id="3627819" data-partner-id="482"
 data-event-name="Union Saint-Gilloise v Liverpool"
 data-market-name="Full Time Result"
 data-selection-name="Draw"
 data-partner-name="SBK"
 data-fraction="57/20" data-decimal="3.85"> 57/20 </span> | 1 <|||> 3 :


 <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600074675" data-market-id="23" data-event-id="3627821" data-partner-id="41" 
 data-event-name="Rennes v Villarreal" 
 data-market-name="Full Time Result" 
 data-selection-name="Rennes" 
 data-partner-name="10Bet" 
 data-fraction="11/10" data-decimal="2.10"> 11/10 </span> | 1 <|||> 4 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603342536" data-market-id="23" data-event-id="3627821" data-partner-id="452" 
 data-event-name="Rennes v Villarreal" 
 data-market-name="Full Time Result"
 data-selection-name="Villarreal" 
 data-partner-name="PariMatch" 
 data-fraction="27/10" data-decimal="3.70"> 27/10 </span> | 1 <|||> 5 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13598016986" data-market-id="23" data-event-id="3627821" data-partner-id="13" 
 data-event-name="Rennes v Villarreal" 
 data-market-name="Full Time Result" 
 data-selection-name="Draw" 
 data-partner-name="bet365" 
 data-fraction="14/5" data-decimal="3.80"> 14/5 </span> | 1 <|||> 6 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600071172" data-market-id="23" data-event-id="3627822" data-partner-id="41" 
 
 
 data-event-name="Panathinaikos v Maccabi Haifa" 
 data-market-name="Full Time Result"
 data-selection-name="Panathinaikos" 
 data-partner-name="10Bet" 
 data-fraction="4/6" data-decimal="1.67"> 4/6 </span> | 1 <|||> 7 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13598016990" data-market-id="23" data-event-id="3627822" data-partner-id="13" 
 data-event-name="Panathinaikos v Maccabi Haifa" 
 data-market-name="Full Time Result" 
 data-selection-name="Maccabi Haifa" 
 data-partner-name="bet365"
 data-fraction="5/1" data-decimal="6.00"> 5/1 </span> | 1 <|||> 8 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603263290" data-market-id="23" data-event-id="3627822" data-partner-id="117" 
 data-event-name="Panathinaikos v Maccabi Haifa" 
 data-market-name="Full Time Result" 
 data-selection-name="Draw" 
 data-partner-name="Betway"
 data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 9 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13597598141" data-market-id="23" data-event-id="3627823" data-partner-id="13" 
 
 
 data-event-name="Roma v Sheriff Tiraspol" 
 data-market-name="Full Time Result" 
 data-selection-name="Roma" 
 data-partner-name="bet365" 
 data-fraction="1/5" data-decimal="1.20"> 1/5 </span> | 1 <|||> __________
 
 
10 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243984" data-market-id="23" data-event-id="3627823" data-partner-id="482"
data-event-name="Roma v Sheriff Tiraspol"

data-market-name="Full Time Result" 
data-selection-name="Sheriff Tiraspol"
data-partner-name="SBK" 
data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 11 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243982" data-market-id="23" data-event-id="3627823" data-partner-id="482" 
data-event-name="Roma v Sheriff Tiraspol"
data-market-name="Full Time Result"
data-selection-name="Draw"
data-partner-name="SBK" 
data-fraction="39/5" data-decimal="8.80"> 39/5 </span> | 1 <|||> 12 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13597598144" data-market-id="23" data-event-id="3627824" data-partner-id="13" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Slavia Prague" data-partner-name="bet365" data-fraction="9/20" data-decimal="1.45"> 9/20 </span> | 1 <|||> 13 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244982" data-market-id="23" data-event-id="3627824" data-partner-id="482" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Servette" data-partner-name="SBK" data-fraction="42/5" data-decimal="9.40"> 42/5 </span> | 1 <|||> 14 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244981" data-market-id="23" data-event-id="3627824" data-partner-id="482" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="22/5" data-decimal="5.40"> 22/5 </span> | 1 <|||> 15 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600065882" data-market-id="23" data-event-id="3627825" data-partner-id="41" data-event-name="Leverkusen v Molde" data-market-name="Full Time Result" data-selection-name="Leverkusen" data-partner-name="10Bet" data-fraction="4/11" data-decimal="1.36"> 4/11 </span> | 1 <|||> 16 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603364881" data-market-id="23" data-event-id="3627825" data-partner-id="31" data-event-name="Leverkusen v Molde" data-market-name="Full Time Result" data-selection-name="Molde" data-partner-name="BetVictor" data-fraction="8/1" data-decimal="9.00"> 8/1 </span> | 1 <|||> 17 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600247173" data-market-id="23" data-event-id="3627825" data-partner-id="482" data-event-name="Leverkusen v Molde" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="26/5" data-decimal="6.20"> 26/5 </span> | 1 <|||> 18 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600074675" data-market-id="23" data-event-id="3627821" data-partner-id="41" data-event-name="Rennes v Villarreal" data-market-name="Full Time Result" data-selection-name="Rennes" data-partner-name="10Bet" data-fraction="11/10" data-decimal="2.10"> 11/10 </span> | 1 <|||> 19 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603342536" data-market-id="23" data-event-id="3627821" data-partner-id="452" data-event-name="Rennes v Villarreal" data-market-name="Full Time Result" data-selection-name="Villarreal" data-partner-name="PariMatch" data-fraction="27/10" data-decimal="3.70"> 27/10 </span> | 1 <|||> __________







  <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13608985343" data-market-id="23" data-event-id="3560445" data-partner-id="452" data-event-name="Birmingham v Leicester" data-market-name="Full Time Result" data-selection-name="Birmingham" data-partner-name="PariMatch" data-fraction="6/1" data-decimal="7.00"> 6/1 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13616097911" data-market-id="23" data-event-id="3560445" data-partner-id="482" data-event-name="Birmingham v Leicester" data-market-name="Full Time Result" data-selection-name="Leicester" data-partner-name="SBK" data-fraction="11/19" data-decimal="1.58"> 11/19 </span><span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13608098878" data-market-id="23" data-event-id="3560445" data-partner-id="13" data-event-name="Birmingham v Leicester" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="bet365" data-fraction="7/2" data-decimal="4.50"> 7/2 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600428814" data-market-id="23" data-event-id="3582691" data-partner-id="482" data-event-name="Girona v Alaves" data-market-name="Full Time Result" data-selection-name="Girona" data-partner-name="SBK" data-fraction="11/19" data-decimal="1.58"> 11/19 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13606082919" data-market-id="23" data-event-id="3582691" data-partner-id="452" data-event-name="Girona v Alaves" data-market-name="Full Time Result" data-selection-name="Alaves" data-partner-name="PariMatch" data-fraction="11/2" data-decimal="6.50"> 11/2 </span><span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13623360239" data-market-id="23" data-event-id="3582691" data-partner-id="293" data-event-name="Girona v Alaves" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="Grosvenor Sports" data-fraction="17/5" data-decimal="4.40"> 17/5 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600378971" data-market-id="23" data-event-id="3582953" data-partner-id="482" data-event-name="Atalanta v Salernitana" data-market-name="Full Time Result" data-selection-name="Atalanta" data-partner-name="SBK" data-fraction="4/13" data-decimal="1.31"> 4/13 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13597949128" data-market-id="23" data-event-id="3582953" data-partner-id="31" data-event-name="Atalanta v Salernitana" data-market-name="Full Time Result" data-selection-name="Salernitana" data-partner-name="BetVictor" data-fraction="12/1" data-decimal="13.00"> 12/1 </span><span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600378972" data-market-id="23" data-event-id="3582953" data-partner-id="482" data-event-name="Atalanta v Salernitana" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="24/5" data-decimal="5.80"> 24/5 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13613308213" data-market-id="23" data-event-id="3584141" data-partner-id="37" data-event-name="Rizespor v Besiktas" data-market-name="Full Time Result" data-selection-name="Rizespor" data-partner-name="Betfred" data-fraction="11/5" data-decimal="3.20"> 11/5 </span><span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13613308215" data-market-id="23" data-event-id="3584141" data-partner-id="37" data-event-name="Rizespor v Besiktas" data-market-name="Full Time Result" data-selection-name="Besiktas" data-partner-name="Betfred" data-fraction="21/20" data-decimal="2.05"> 21/20 </span><span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13613308214" data-market-id="23" data-event-id="3584141" data-partner-id="37" data-event-name="Rizespor v Besiktas" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="Betfred" data-fraction="23/10" data-de




12-14 13:46:31.654 28646 31460 I   System.out                                   20 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13598016986" data-market-id="23" data-event-id="3627821" data-partner-id="13" data-event-name="Rennes v Villarreal" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="bet365" data-fraction="14/5" data-decimal="3.80"> 14/5 </span> | 1 <|||> 21 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13597598144" data-market-id="23" data-event-id="3627824" data-partner-id="13" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Slavia Prague" data-partner-name="bet365" data-fraction="9/20" data-decimal="1.45"> 9/20 </span> | 1 <|||> 22 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244982" data-market-id="23" data-event-id="3627824" data-partner-id="482" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Servette" data-partner-name="SBK" data-fraction="42/5" data-decimal="9.40"> 42/5 </span> | 1 <|||> 23 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600244981" data-market-id="23" data-event-id="3627824" data-partner-id="482" data-event-name="Slavia Prague v Servette" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="22/5" data-decimal="5.40"> 22/5 </span> | 1 <|||> 24 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13597598141" data-market-id="23" data-event-id="3627823" data-partner-id="13" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Roma" data-partner-name="bet365" data-fraction="1/5" data-decimal="1.20"> 1/5 </span> | 1 <|||> 25 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243984" data-market-id="23" data-event-id="3627823" data-partner-id="482" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Sheriff Tiraspol" data-partner-name="SBK" data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 26 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243982" data-market-id="23" data-event-id="3627823" data-partner-id="482" data-event-name="Roma v Sheriff Tiraspol" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="39/5" data-decimal="8.80"> 39/5 </span> | 1 <|||> 27 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13593167913" data-market-id="23" data-event-id="3627826" data-partner-id="117" data-event-name="Qarabag v Hacken" data-market-name="Full Time Result" data-selection-name="Qarabag" data-partner-name="Betway" data-fraction="4/9" data-decimal="1.44"> 4/9 </span> | 1 <|||> 28 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243081" data-market-id="23" data-event-id="3627826" data-partner-id="482" data-event-name="Qarabag v Hacken" data-market-name="Full Time Result" data-selection-name="Hacken" data-partner-name="SBK" data-fraction="43/5" data-decimal="9.60"> 43/5 </span> | 1 <|||> 29 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600243080" data-market-id="23" data-event-id="3627826" data-partner-id="482" data-event-name="Qarabag v Hacken" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="47/10" data-decimal="5.70"> 47/10 </span> | 1 <|||> __________
12-14 13:46:31.656 28646 31460 I   System.out                                   30 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600058061" data-market-id="23" data-event-id="3627819" data-partner-id="41" data-event-name="Union Saint-Gilloise v Liverpool" data-market-name="Full Time Result" data-selection-name="Union Saint-Gilloise" data-partner-name="10Bet" data-fraction="9/5" data-decimal="2.80"> 9/5 </span> | 1 <|||> 31 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600248139" data-market-id="23" data-event-id="3627819" data-partner-id="482" data-event-name="Union Saint-Gilloise v Liverpool" data-market-name="Full Time Result" data-selection-name="Liverpool" data-partner-name="SBK" data-fraction="11/5" data-decimal="3.20"> 11/5 </span> | 1 <|||> 32 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600248138" data-market-id="23" data-event-id="3627819" data-partner-id="482" data-event-name="Union Saint-Gilloise v Liverpool" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="57/20" data-decimal="3.85"> 57/20 </span> | 1 <|||> 33 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600071172" data-market-id="23" data-event-id="3627822" data-partner-id="41" data-event-name="Panathinaikos v Maccabi Haifa" data-market-name="Full Time Result" data-selection-name="Panathinaikos" data-partner-name="10Bet" data-fraction="4/6" data-decimal="1.67"> 4/6 </span> | 1 <|||> 34 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13598016990" data-market-id="23" data-event-id="3627822" data-partner-id="13" data-event-name="Panathinaikos v Maccabi Haifa" data-market-name="Full Time Result" data-selection-name="Maccabi Haifa" data-partner-name="bet365" data-fraction="5/1" data-decimal="6.00"> 5/1 </span> | 1 <|||> 35 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603263290" data-market-id="23" data-event-id="3627822" data-partner-id="117" data-event-name="Panathinaikos v Maccabi Haifa" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="Betway" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 36 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600248972" data-market-id="23" data-event-id="3627828" data-partner-id="482" data-event-name="Ajax v AEK Athens" data-market-name="Full Time Result" data-selection-name="Ajax" data-partner-name="SBK" data-fraction="1/1" data-decimal="2.00"> 1/1 </span> | 1 <|||> 37 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604976885" data-market-id="23" data-event-id="3627828" data-partner-id="31" data-event-name="Ajax v AEK Athens" data-market-name="Full Time Result" data-selection-name="AEK Athens" data-partner-name="BetVictor" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 38 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13591609044" data-market-id="23" data-event-id="3627828" data-partner-id="37" data-event-name="Ajax v AEK Athens" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="Betfred" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 39 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603367882" data-market-id="23" data-event-id="3627829" data-partner-id="31" data-event-name="Brighton v Marseille" data-market-name="Full Time Result" data-selection-name="Brighton" data-partner-name="BetVictor" data-fraction="7/10" data-decimal="1.70"> 7/10 </span> | 1 <|||> __________
12-14 13:46:31.658 28646 31460 I   System.out                                   40 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600254829" data-market-id="23" data-event-id="3627829" data-partner-id="482" data-event-name="Brighton v Marseille" data-market-name="Full Time Result" data-selection-name="Marseille" data-partner-name="SBK" data-fraction="39/10" data-decimal="4.90"> 39/10 </span> | 1 <|||> 41 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600084682" data-market-id="23" data-event-id="3627829" data-partner-id="41" data-event-name="Brighton v Marseille" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="10Bet" data-fraction="10/3" data-decimal="4.33"> 10/3 </span> | 1 <|||> 42 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603368693" data-market-id="23" data-event-id="3627830" data-partner-id="31" data-event-name="Betis v Rangers" data-market-name="Full Time Result" data-selection-name="Betis" data-partner-name="BetVictor" data-fraction="20/21" data-decimal="1.95"> 20/21 </span> | 1 <|||> 43 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600253144" data-market-id="23" data-event-id="3627830" data-partner-id="482" data-event-name="Betis v Rangers" data-market-name="Full Time Result" data-selection-name="Rangers" data-partner-name="SBK" data-fraction="37/10" data-decimal="4.70"> 37/10 </span> | 1 <|||> 44 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13600094461" data-market-id="23" data-event-id="3627830" data-partner-id="41" data-event-name="Betis v Rangers" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="10Bet" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 45 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604124894" data-market-id="23" data-event-id="3628302" data-partner-id="41" data-event-name="Legia Warszawa v Alkmaar" data-market-name="Full Time Result" data-selection-name="Legia Warszawa" data-partner-name="10Bet" data-fraction="21/10" data-decimal="3.10"> 21/10 </span> | 1 <|||> 46 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602553890" data-market-id="23" data-event-id="3628302" data-partner-id="37" data-event-name="Legia Warszawa v Alkmaar" data-market-name="Full Time Result" data-selection-name="Alkmaar" data-partner-name="Betfred" data-fraction="7/5" data-decimal="2.40"> 7/5 </span> | 1 <|||> 47 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604124896" data-market-id="23" data-event-id="3628302" data-partner-id="41" data-event-name="Legia Warszawa v Alkmaar" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="10Bet" data-fraction="27/10" data-decimal="3.70"> 27/10 </span> | 1 <|||> 48 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604133887" data-market-id="23" data-event-id="3628309" data-partner-id="41" data-event-name="Fenerbahce v Trnava" data-market-name="Full Time Result" data-selection-name="Fenerbahce" data-partner-name="10Bet" data-fraction="1/9" data-decimal="1.11"> 1/9 </span> | 1 <|||> 49 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603966610" data-market-id="23" data-event-id="3628309" data-partner-id="43" data-event-name="Fenerbahce v Trnava" data-market-name="Full Time Result" data-selection-name="Trnava" data-partner-name="William Hill" data-fraction="28/1" data-decimal="29.00"> 28/1 </span> | 1 <|||> __________
12-14 13:46:31.660 28646 31460 I   System.out                                   50 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13612900136" data-market-id="23" data-event-id="3628309" data-partner-id="482" data-event-name="Fenerbahce v Trnava" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="9/1" data-decimal="10.00"> 9/1 </span> | 1 <|||> 51 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13612901149" data-market-id="23" data-event-id="3628308" data-partner-id="482" data-event-name="Ludogorets Razgrad v Nordsjaelland" data-market-name="Full Time Result" data-selection-name="Ludogorets Razgrad" data-partner-name="SBK" data-fraction="13/9" data-decimal="2.44"> 13/9 </span> | 1 <|||> 52 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13612901154" data-market-id="23" data-event-id="3628308" data-partner-id="482" data-event-name="Ludogorets Razgrad v Nordsjaelland" data-market-name="Full Time Result" data-selection-name="Nordsjaelland" data-partner-name="SBK" data-fraction="16/9" data-decimal="2.78"> 16/9 </span> | 1 <|||> 53 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604132016" data-market-id="23" data-event-id="3628308" data-partner-id="41" data-event-name="Ludogorets Razgrad v Nordsjaelland" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="10Bet" data-fraction="14/5" data-decimal="3.80"> 14/5 </span> | 1 <|||> 54 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604130332" data-market-id="23" data-event-id="3628306" data-partner-id="41" data-event-name="PAOK v HJK Helsinki" data-market-name="Full Time Result" data-selection-name="PAOK" data-partner-name="10Bet" data-fraction="2/5" data-decimal="1.40"> 2/5 </span> | 1 <|||> 55 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602555570" data-market-id="23" data-event-id="3628306" data-partner-id="37" data-event-name="PAOK v HJK Helsinki" data-market-name="Full Time Result" data-selection-name="HJK Helsinki" data-partner-name="Betfred" data-fraction="10/1" data-decimal="11.00"> 10/1 </span> | 1 <|||> 56 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603966578" data-market-id="23" data-event-id="3628306" data-partner-id="43" data-event-name="PAOK v HJK Helsinki" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="William Hill" data-fraction="9/2" data-decimal="5.50"> 9/2 </span> | 1 <|||> 57 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604127394" data-market-id="23" data-event-id="3628305" data-partner-id="41" data-event-name="Ferencvaros v Fiorentina" data-market-name="Full Time Result" data-selection-name="Ferencvaros" data-partner-name="10Bet" data-fraction="51/20" data-decimal="3.55"> 51/20 </span> | 1 <|||> 58 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13614836752" data-market-id="23" data-event-id="3628305" data-partner-id="488" data-event-name="Ferencvaros v Fiorentina" data-market-name="Full Time Result" data-selection-name="Fiorentina" data-partner-name="HollywoodBets" data-fraction="27/19" data-decimal="2.42"> 27/19 </span> | 1 <|||> 59 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604127396" data-market-id="23" data-event-id="3628305" data-partner-id="41" data-event-name="Ferencvaros v Fiorentina" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="10Bet" data-fraction="21/10" data-decimal="3.10"> 21/10 </span> | 1 <|||> __________
12-14 13:46:31.662 28646 31460 I   System.out                                   60 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604910387" data-market-id="23" data-event-id="3628304" data-partner-id="117" data-event-name="Genk v Cukaricki" data-market-name="Full Time Result" data-selection-name="Genk" data-partner-name="Betway" data-fraction="2/13" data-decimal="1.15"> 2/13 </span> | 1 <|||> 61 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604125905" data-market-id="23" data-event-id="3628304" data-partner-id="41" data-event-name="Genk v Cukaricki" data-market-name="Full Time Result" data-selection-name="Cukaricki" data-partner-name="10Bet" data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 62 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13612895592" data-market-id="23" data-event-id="3628304" data-partner-id="482" data-event-name="Genk v Cukaricki" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="SBK" data-fraction="38/5" data-decimal="8.60"> 38/5 </span> | 1 <|||> 63 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13603966639" data-market-id="23" data-event-id="3628303" data-partner-id="43" data-event-name="Zrinjski Mostar v Aston Villa" data-market-name="Full Time Result" data-selection-name="Zrinjski Mostar" data-partner-name="William Hill" data-fraction="10/1" data-decimal="11.00"> 10/1 </span> | 1 <|||> 64 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13612892741" data-market-id="23" data-event-id="3628303" data-partner-id="482" data-event-name="Zrinjski Mostar v Aston Villa" data-market-name="Full Time Result" data-selection-name="Aston Villa" data-partner-name="SBK" data-fraction="8/17" data-decimal="1.47"> 8/17 </span> | 1 <|||> 65 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602553130" data-market-id="23" data-event-id="3628303" data-partner-id="37" data-event-name="Zrinjski Mostar v Aston Villa" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="Betfred" data-fraction="5/1" data-decimal="6.00"> 5/1 </span> | 1 <|||> 66 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604140197" data-market-id="23" data-event-id="3628317" data-partner-id="41" data-event-name="Lugano v Besiktas" data-market-name="Full Time Result" data-selection-name="Lugano" data-partner-name="10Bet" data-fraction="1/1" data-decimal="2.00"> 1/1 </span> | 1 <|||> 67 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602495113" data-market-id="23" data-event-id="3628317" data-partner-id="13" data-event-name="Lugano v Besiktas" data-market-name="Full Time Result" data-selection-name="Besiktas" data-partner-name="bet365" data-fraction="10/3" data-decimal="4.33"> 10/3 </span> | 1 <|||> 68 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602495112" data-market-id="23" data-event-id="3628317" data-partner-id="13" data-event-name="Lugano v Besiktas" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="bet365" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 69 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604141902" data-market-id="23" data-event-id="3628316" data-partner-id="41" data-event-name="Club Brugge v Bodo/Glimt" data-market-name="Full Time Result" data-selection-name="Club Brugge" data-partner-name="10Bet" data-fraction="4/5" data-decimal="1.80"> 4/5 </span> | 1 <|||> __________
12-14 13:46:31.663 28646 31460 I   System.out                                   70 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602495110" data-market-id="23" data-event-id="3628316" data-partner-id="13" data-event-name="Club Brugge v Bodo/Glimt" data-market-name="Full Time Result" data-selection-name="Bodo/Glimt" data-partner-name="bet365" data-fraction="7/2" data-decimal="4.50"> 7/2 </span> | 1 <|||> 71 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13602495109" data-market-id="23" data-event-id="3628316" data-partner-id="13" data-event-name="Club Brugge v Bodo/Glimt" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="bet365" data-fraction="10/3" data-decimal="4.33"> 10/3 </span> | 1 <|||> 72 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13609047375" data-market-id="23" data-event-id="3628315" data-partner-id="62" data-event-name="Dinamo Zagreb v Ballkani" data-market-name="Full Time Result" data-selection-name="Dinamo Zagreb" data-partner-name="Boylesports" data-fraction="4/11" data-decimal="1.36"> 4/11 </span> | 1 <|||> 73 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604780479" data-market-id="23" data-event-id="3628315" data-partner-id="43" data-event-name="Dinamo Zagreb v Ballkani" data-market-name="Full Time Result" data-selection-name="Ballkani" data-partner-name="William Hill" data-fraction="15/2" data-decimal="8.50"> 15/2 </span> | 1 <|||> 74 : <span class="draw-odds eo-oddsButton" data-sport-id="6" data-selection-id="13604780478" data-market-id="23" data-event-id="3628315" data-partner-id="43" data-event-name="Dinamo Zagreb v Ballkani" data-market-name="Full Time Result" data-selection-name="Draw" data-partner-name="William Hill" data-fraction="15/4" data-decimal="4.75"> 15/4 </span> | 1 <|||> 75 : <span class="odds-odds eo-oddsButton mod-pale sz-larger"><b>631/100</b></span>
12-14 13:46:31.664 28646 31460 I   System.out                                   <b>631/100</b> | 2 <|||> 76 : <b>631/100</b> | 1 <|||> 77 : <span class="odds-odds eo-oddsButton mod-pale sz-larger"><b>307/100</b></span>
12-14 13:46:31.664 28646 31460 I   System.out                                   <b>307/100</b> | 2 <|||> 78 : <b>307/100</b> | 1 <|||> 79 : <span class="odds-odds eo-oddsButton mod-pale sz-larger"><b>6424/25</b></span>
12-14 13:46:31.664 28646 31460 I   System.out                                   <b>6424/25</b> | 2 <|||> __________
12-14 13:46:31.664 28646 31460 I   System.out                                   80 : <b>6424/25</b> | 1 <|||> 81 : <span class="odds-odds eo-oddsButton mod-pale sz-larger"><b>183/4</b></span>
12-14 13:46:31.666 28646 31460 I   System.out                                   <b>183/4</b> | 2 <|||> 82 : <b>183/4</b> | 1 <|||> 83 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13125907009" data-market-id="666676" data-event-id="113672" data-partner-id="452" data-event-name="Manager Specials" data-market-name="Next Permanent Nottingham Forest Manager" data-selection-name="Glasner, O" data-partner-name="PariMatch" data-fraction="1/1" data-decimal="2.00"> 1/1 </span> | 1 <|||> 84 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13173142922" data-market-id="552098" data-event-id="113672" data-partner-id="488" data-event-name="Manager Specials" data-market-name="Next Permanent England Manager" data-selection-name="Potter, G" data-partner-name="HollywoodBets" data-fraction="6/1" data-decimal="7.00"> 6/1 </span> | 1 <|||> 85 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13528999474" data-market-id="197292" data-event-id="113672" data-partner-id="31" data-event-name="Manager Specials" data-market-name="Next Permanent Man Utd Manager" data-selection-name="Potter, G" data-partner-name="BetVictor" data-fraction="7/2" data-decimal="4.50"> 7/2 </span> | 1 <|||> 86 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13407263088" data-market-id="1998828" data-event-id="1206759" data-partner-id="31" data-event-name="Transfer Specials" data-market-name="Jadon Sancho to sign for before February 3rd 2024" data-selection-name="Any Italian Club" data-partner-name="BetVictor" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 87 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13483299616" data-market-id="1998825" data-event-id="1206759" data-partner-id="452" data-event-name="Transfer Specials" data-market-name="Lionel Messi to sign for before February 3rd 2024" data-selection-name="Barcelona" data-partner-name="PariMatch" data-fraction="3/1" data-decimal="4.00"> 3/1 </span> | 1 <|||> 88 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13483433006" data-market-id="1998824" data-event-id="1206759" data-partner-id="31" data-event-name="Transfer Specials" data-market-name="Mohamed Salah to sign for before February 3rd 2024" data-selection-name="Any Italian Club" data-partner-name="BetVictor" data-fraction="20/1" data-decimal="21.00"> 20/1 </span> | 1 <|||> 89 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13483433022" data-market-id="1998829" data-event-id="1206759" data-partner-id="31" data-event-name="Transfer Specials" data-market-name="Kalvin Phillips to sign for before February 3rd 2024" data-selection-name="Any Italian Club" data-partner-name="BetVictor" data-fraction="11/8" data-decimal="2.38"> 11/8 </span> | 1 <|||> __________
12-14 13:46:31.666 28646 31460 I   System.out                                   90 : <span class="side-odds eo-oddsButton" data-sport-id="6" data-selection-id="13483433043" data-market-id="1998827" data-event-id="1206759" data-partner-id="31" data-event-name="Transfer Specials" data-market-name="Harry Maguire to sign for before February 3rd 2024" data-selection-name="West Ham" data-partner-name="BetVictor" data-fraction="8/1" data-decimal="9.00"> 8/1 </span> | 1 <|||> 91 < count : elementsAllChildren.size() :95
12-14 13:46:31.666 28646 31460 I   System.out                                 

*/







