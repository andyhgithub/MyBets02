package com.mycompany.myapp8;



//
// XXX TODO Pass "allText" to localTest(); and rename
//
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
// import core.util.StringUtils;

public class MainActivity extends Activity
{

	
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
					
					
					
					getBodyText();
				}
			});
			
			
		
    }
	
	
    private void getBodyText() {
        new Thread(new Runnable() {
				@Override
				public void run() {
					final StringBuilder builder = new StringBuilder();



					String[] temps = new String[3];
					Double[] tempd = new Double[3];
					List<Double[]> trips = new ArrayList<Double[]>();
					List<String[]> odds = new ArrayList<String[]>();

					Double a[] = {2d,2d,2d};




					try {
						//			String url="https://www.oddschecker.com/football/english/premier-league/brighton-v-liverpool/winner";//your website url

						//		String url="https://www.poetryfoundation.org/poems/48860/the-raven";//your website url

						String url="https://www.oddschecker.com/";//your website url
						url = "https://www.oddschecker.com/cheltenham-festival";

						url = "https://easyodds.com/";
						url = "https://easyodds.com/football";

						Connection con = Jsoup.connect(url);
						System.out.println("CCOnn");

						con.ignoreHttpErrors(true);
						System.out.println("ignor");


						Document doc = con.get();
						System.out.println("get");


						Elements elementsAll = doc.body().select("*");
						
						String elementsAllText = elementsAll.text();
						
						
						
						System.out.println("elms sz = "+ elementsAll.size());
						System.err.println("elms sz = "+ elementsAll.size());
						
						
						String allText = doc.toString();
						System.err.println("*********************");
						System.out.println("*********************");
						
						allText = allText.replaceAll("\\s", "");
						System.out.println(elementsAllText);
					
						System.out.println("*********************");
						System.err.println("*********************");
						
						System.out.println("call: listMatches(elementsAllText)--nb: with white space");
						listMatches(elementsAllText);
						System.out.println("return: listMatches(elementsAllText)");
						
						
						for (Element element : elementsAll) {
				
							
		
				//			System.out.print("!" + element.ownText() + "-");
			
							
						}

						
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
						for (Element elementS : elemsAll) {
							
							
//							System.err.print("... element.id())..." + elementS.id());
//							System.out.print("... element.tagName())..." + elementS.tagName());
//							System.err.print("... element.tag())..." + elementS.tag());
//							System.err.print("... element.className())..." + elementS.className());
//							System.err.print("... element.data())..." + elementS.data());
//							System.err.print("... element.cssSelector())..." + elementS.cssSelector());
//							System.err.print("... element.attributes())..." + elementS.attributes());
//							System.err.print("... element.classNames())..." + elementS.classNames());
//							System.err.print("... element.text())..." + elementS.text());
//							System.err.print("... element.ownText())..." + elementS.ownText());
//							System.err.print("... element.nodeName())..." + elementS.nodeName());
//							System.err.print("... element.outerHtml())..." + elementS.outerHtml());
//							System.err.print("... element.hasText())..." + elementS.hasText());
//							System.err.print("... element.hasText())..." + elementS.hasText());
//							System.err.print("... element.text().length(.." + elementS.text().length());
//							System.err.print("... element.text().length(.." + elementS.text().length());
//							System.err.print(elementS.ownText() + "===elementS.ownText" );
//							System.out.println(": Xnames ix = " + nix++);
						
//							System.err.println("... element.id())..." + elementS.id());
//							System.out.println("... element.tagName())..." + elementS.tagName());
//							System.err.println("... element.tag())..." + elementS.tag());
//							System.err.println("... element.className())..." + elementS.className());
//							System.err.println("... element.data())..." + elementS.data());
//							System.err.println("... element.cssSelector())..." + elementS.cssSelector());
//							System.err.println("... element.attributes())..." + elementS.attributes());
//							System.err.println("... element.classNames())..." + elementS.classNames());
//							System.err.println("... element.text())..." + elementS.text());
//							System.err.println("... element.ownText())..." + elementS.ownText());
//							System.err.println("... element.nodeName())..." + elementS.nodeName());
//							System.err.println("... element.outerHtml())..." + elementS.outerHtml());
//							System.err.println("... element.hasText())..." + elementS.hasText());
//							System.err.println("... element.hasText())..." + elementS.hasText());
//							System.err.println("... element.text().length(.." + elementS.text().length());
//							System.err.println("... element.text().length(.." + elementS.text().length());
//							System.err.println(elementS.ownText() + "===elementS.ownText" );
//							System.out.println("names ix = " + nix++);
							
							if (nix == 18){
								namesAndOddEtc = elementS.text();
							}
				//			System.out.println("ix=" + (nix++) + "... element.text())..." + elementS.text());
//							
							
						}
						
						System.err.println("namesAndOddEtc === " + namesAndOddEtc);
						
						
						System.out.println("allDOM === " + allDOM);
						System.err.println("allDOM === " + allDOM);
						
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
						for (Element element : elems2) {

							double r = 0;
							String s = element.ownText();
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


//							System.out.println(element.ownText() + "===" + r);
//
//							System.out.println(element.ownText() + "===" + r);
//							System.out.println("... element.id())..." + element.id());
//							System.out.println("... element.tagName())..." + element.tagName());
//							System.out.println("... element.tag())..." + element.tag());
//							System.out.println("... element.className())..." + element.className());
//							System.out.println("... element.data())..." + element.data());
//							System.out.println("... element.cssSelector())..." + element.cssSelector());
//							System.out.println("... element.attributes())..." + element.attributes());
//							System.out.println("... element.classNames())..." + element.classNames());
//							System.out.println("... element.text())..." + element.text());
//							System.out.println("... element.ownText())..." + element.ownText());
//							System.out.println("... element.nodeName())..." + element.nodeName());
//
//							System.out.println("... element.outerHtml())..." + element.outerHtml());
//							System.out.println("... element.hasText())..." + element.hasText());
//							System.out.println("... element.hasText())..." + element.hasText());
//
//							System.out.println("... element.text().length(.." + element.text().length());
//							System.out.println("... element.text().length(.." + element.text().length());
//
//							System.out.println(element.ownText() + "===" + r);
							
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


						Element body = doc.body();

						//		builder.append("b.xxx");
						//		builder.append(body.text());

						//		System.out.println(body.text());

					} catch (IOException e) {


						builder.append("IOException: " + e.getMessage());

						//		builder.append("Error : ").append(e.getLocalizedMessage()).append("\n");

						//		builder.append("Error : ").append(e.getMessage()).append(e.getLocalizedMessage()).append("\n");
						System.err.println("Error = " + e.getMessage());
						System.out.println("error = " + e.getMessage());
						System.out.println("============");
						System.err.println("============");
						System.out.println("getMessage = " + e.getMessage());
						System.out.println("getLocalizedMessage = " + e.getLocalizedMessage());
						System.out.println("e.printStackTrace() = " );e.printStackTrace();
						
						System.err.println("============");
						System.out.println("============");
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

	double parse(String ratio) {
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
	
	
	
	
	ArrayList<String> matchsList = new ArrayList<String>();

	private void listMatches(String DOMString){




		int namesEndPos = -1;
		int oddsPos = -1;
		int nextNamesEndPos = -1;
		int nextOddsPos = -1;
		Pattern oddsPattern = Pattern.compile("([0-9]{1,4}/[0-9]{1,4})");  // Find odds ie. 2/11 or 99/1 etc
		Pattern endPattern = Pattern.compile("Draw");  // Find the word "Draw". Name pairs (matches) end with this



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
		String nextNew = tmpNew.substring(0, namesEndPos);
		
		
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

		//	while (namesEndPos < DOMString.length()){
			for (int i = 0; i < 85; i++){


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
				return;
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

	}

}


/*                   
Edit
*/








