package com.mycompany.myapp8;



//Add Internet permission to the Android Manifest file for internet access.
//<uses-permission android:name="android.permission.INTERNET" />
//
//Add button and text view in your app to get data from website on button click
//and display the result on text view.
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

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.util.*;
import android.content.Context;


public class MainActivity extends Activity
{
	private Map<String, String> matchesResultsMap = new HashMap<String, String>();
	
	private Map<String, ArrayList<String>> matchesResultsMap2 = new HashMap<String, ArrayList<String>>();
	
	private Map<String, String> resultsBookiesMap = new HashMap<String, String>();
	private Map<String, String> bookiesOddsMap = new HashMap<String, String>();
	

	private ArrayList<String> matchesList = new ArrayList<String>();
	private ArrayList<String> resultsList = new ArrayList<String>();
	private ArrayList<String> bookiesList = new ArrayList<String>();
	private ArrayList<String> oddsList = new ArrayList<String>();
	
	
	private Context context = this;
	
	
	private static final String TAG_INFO = "info:..";
	private Elements elementsAll;
	
    private TextView result;
    private Button fetch;

	private StringBuilder builder = new StringBuilder();
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        result = (TextView) findViewById(R.id.result);
		result.setMovementMethod(new ScrollingMovementMethod());
		result.setTextIsSelectable(true);
	
	
	    fetch = (Button) findViewById(R.id.fetch);
		
		
	
		
		
		
        fetch.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					
					
					System.out.println("click");
					Log.i(TAG_INFO, "Click");
					
					
					
					getBodyText();
				}
			});
			
			
		
    }
	
	
    private void getBodyText() {
        new Thread(new Runnable() {
				@Override
				public void run() {
		
					
					try {
						
						String url;
						url="https://www.oddschecker.com/";// NB: oddschecker seems to have anti-scraping shit: Workaround pain in arse
						

						url = "https://easyodds.com/";
						url = "https://easyodds.com/football";			
						url = "https://easyodds.com/football/championship";		
				//		url = 	"https://easyodds.com/football/la-liga";
				//		url = "https://easyodds.com/football/premier-league";
						url = "https://easyodds.com/football/serie-a";
						url = "https://easyodds.com/football/serie-b";
						url = "https://easyodds.com/football/serie-c";
						url = "https://easyodds.com/football/serie-d";
						
						url = "xxxxxxxx";
						
						url = "https://easyodds.com/football/uefa-champions-league";
						
						
						
						Connection con = Jsoup.connect(url);
						System.out.println("CCOnn");
						Log.i(TAG_INFO, "Connection");

						builder.append("Connecting to " + url + "\n");
						
						
						con.ignoreHttpErrors(true);
						System.out.println("ignor");
						Log.i(TAG_INFO, "Ignor http errors");
						

						Document doc = con.get();
						System.out.println("get");
						Log.i(TAG_INFO, "Get Document");
					
						builder.append("Got page..."  + "\n");
						
						
						// Select all elements with nnn/nnn... eg. 1/2, 99/1, 27/4 etc.
						elementsAll = doc.body().select("*:matches(^[0-9]*/[0-9]*$)");


						String allAsText = listChildren(elementsAll);
						
				
						
						elementsAll = doc.body().select("*:matches(^[0-9]*/[0-9]*$)");
						writeToFile(allAsText, context);
						
		
						String readString = readFromFile(context);
				


						buildMap(readString);

						buildText();
					} catch (IOException e) {


				

						Log.e(TAG_INFO, e.getMessage());
						Log.i(TAG_INFO, "Attempt to read Document from File");
						builder.append("Failed to fetch page" + "\n");
						builder.append("Attempt to read Document from File" + "\n");
						
						String readString = readFromFile(context);
						System.out.println("readString===" + readString);
						
	
						buildMap(readString);
						
						buildText();
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
	
	private void buildText(){
//		System.out.println("matchesList.size() = " + matchesList.size());
//		System.out.println("resultsList.size() = " + resultsList.size());
//		System.out.println("bookiesList.size() = " + bookiesList.size());
//		System.out.println("oddsList.size() = " + oddsList.size());
//		
//		System.out.println("matchesResultsMap.size() = " + matchesResultsMap.size());
//		System.out.println("matchesResultsMap2.size() = " + matchesResultsMap2.size());
//		System.out.println("resultsBookiesMap.size() = " + resultsBookiesMap.size());
//		System.out.println("bookiesOddsMap.size() = " + bookiesOddsMap.size());
//		
//		System.out.println("matchesList: " + matchesList);
//		System.out.println("resultsList: " + resultsList);
//		System.out.println("bookiesList: " + bookiesList);
//		System.out.println("oddsList: " + oddsList);
		
		for (int i = 0; i < matchesList.size(); i+=3){
			String match = matchesList.get(i);
	
			ArrayList<String> results = matchesResultsMap2.get(match);
			
			System.out.println(match + ": " + results);
			
			String[] oddsx3 = new String[3];
			oddsx3[0] = results.get(2);
			oddsx3[1] = results.get(5);
			oddsx3[2] = results.get(8);
			
			System.out.println(oddsx3[0] + ", " + oddsx3[1] + ", " + oddsx3[2]);
			
			builder.append(match + ": \n\n");
			builder.append(results.get(0) + " win: " + results.get(2) + " (" + results.get(1) + ")\n");
			builder.append(results.get(3) + " win: " + results.get(5) + " (" + results.get(4) + ")\n");
			builder.append(results.get(6) + " win: " + results.get(8) + " (" + results.get(7) + ")\n\n\n");
			
			testOdds(oddsx3);
			builder.append("____________________________________________\n");
		}
	}
	
	private void buildMap(String allText){
		

		String matchRegEx = "data-event-name=\"";
		String resultRegEx = "data-selection-name=\"";
		String bookieRegEx = "data-partner-name=\"";
		String oddsRegEx = "data-fraction=\"";
		
		
		
		
		System.out.println("buildList call...");
		Log.i(TAG_INFO, "buildMatchesList call...");
		matchesList = buildMatchesList(allText, matchRegEx);
	
		Log.i(TAG_INFO, "buildList(data-selection-name) call...");
		resultsList = buildList(allText, resultRegEx);
		//
		Log.i(TAG_INFO, "buildList(bookieRegEx) call...");
		bookiesList = buildList(allText, bookieRegEx);
		//
		Log.i(TAG_INFO, "buildList(data-oddsRegEx) call...");
		oddsList = buildList(allText, oddsRegEx);
		//
		
		
		
		
		String[] oddsx3 = new String[3];
		String[] bookiesx3 = new String[3];
		
		
		Iterator matchesIt = matchesList.iterator();
		Iterator resultsIt = resultsList.iterator();
		Iterator bookiesIt = bookiesList.iterator();
		Iterator oddsIt = oddsList.iterator();
		int ix = 0;
		
		while (matchesIt.hasNext()){
			ArrayList<String> results = new ArrayList<String>();
			
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
			int vix = tmp1.indexOf(" v ");
			String teamA = (String) tmp1.subSequence(0, vix);
			String teamB = (String) tmp1.subSequence((vix + 3), tmp1.length());
		
		//	System.out.println("teamA = " + teamA + ", teamB = " + teamB);
		
			
			
			if (tmp1.equals(tmp2) && tmp2.equals(tmp3)){
				
				boolean isMatch = false;
				
				String nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp1, nextResult);
				results.add(nextResult);	
				
				isMatch = teamA.equals(nextResult);
					
				String nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				String nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);
				
				results.add(nextBookie);
				results.add(nextodds);
//				
				nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp2, nextResult);
				results.add(nextResult);
				
				if (isMatch){
					isMatch = (teamB.equals(nextResult));
				}
					
				nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);
			
				results.add(nextBookie);
				results.add(nextodds);
			
				nextResult = (String) resultsIt.next();
				matchesResultsMap.put(tmp3, nextResult);
				results.add(nextResult);
				
				if (isMatch){
					isMatch = (nextResult.equals("Draw"));
				}			
				
				nextBookie = (String)  bookiesIt.next();
				resultsBookiesMap.put(nextResult, nextBookie);
				nextodds = (String)  oddsIt.next();
				bookiesOddsMap.put(nextBookie, nextodds);
				
				results.add(nextBookie);
				results.add(nextodds);
				
				if (isMatch){
					matchesResultsMap2.put(tmp1, results);
				}
				
				System.out.println(isMatch + ":" + tmp1 + " > " +results);
			}
						
		}
		
	}
	
	private ArrayList<String> buildList(String allText, String regExp) {

		ArrayList<String> list = new ArrayList<String>();

		int nx = 0;
		String[] splitText = allText.split(regExp);
		splitText = Arrays.copyOfRange(splitText, 1, splitText.length);
	
		String[] splitList = new String[splitText.length + 1];

		for (String text : splitText){
			
			int end = text.indexOf("\"");
			splitList[nx] = text.substring(0, end);
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
	
			String[] marketText = new String[2];
			if (regExp == "data-event-name=\""){
				String market = "data-market-name=\"";
				marketText = text.split(market);
			}

			if (!marketText[marketText.length - 1].startsWith("Full Time Result")){
		System.out.println("s[1]=" + marketText[marketText.length - 1]);
				continue;
			}
			
			int end = text.indexOf("\"");
			splitList[nx] = text.substring(0, end);
	
			list.add(splitList[nx]);
			
			nx++;
		}
		
		System.out.println("List: " + list);
		
		return list;

	}

	private double parse(String ratio) {
	
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
		
		Pattern oddsPattern = Pattern.compile("([0-9]{1,4}/[0-9]{1,4})");  // Find odds ie. 2/11 or 99/1 etc
		Pattern endPattern = Pattern.compile("Draw");  // Find the word "Draw". Name pairs (matches) end with this
	
		Matcher oddsMatch = oddsPattern.matcher(DOMString);
		
		if (oddsMatch.find()) {
			oddsPos = oddsMatch.start();
		}
		String tmpNew = DOMString.substring(oddsPos);

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
		
		
		String nextAll = tmpNew.substring(namesEndPos);
		
		
		System.out.println("________");
		System.err.println("nxNew = " + nextNew + "____=____");
		System.out.println("________");
		System.err.println("nxAll = " + nextAll + "____=____");
		System.out.println("________");


		matchsList.add(nextNew);

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
			matchsList.add(nextNew);

		}

		for (int i = 0; i < matchsList.size(); i++){
			System.out.println(i + " : " + matchsList.get(i));
		}

		return matchsList;
	}
	
	//
	private StringBuilder allText = new StringBuilder();
	
	private String currentBitofText; 
	
	private String listChildren(Elements origPage){
		
		Iterator elementsIter = origPage.iterator();
		while (elementsIter.hasNext()){
			Element currentElem = (Element) elementsIter.next();
		
			Elements tmp = currentElem.getAllElements();
			currentBitofText = tmp.outerHtml();
			allText.append(currentBitofText);
			
			}

		return allText.toString();
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
	
	
	private boolean testOdds(String[] oddsString){

		String[] temps = oddsString;
		Double[] tempd = new Double[3];
		List<Double[]> trips = new ArrayList<Double[]>();
		List<String[]> oddsList = new ArrayList<String[]>();
	
		int n = 0;
		
		for (String s : temps){
	
			double r = 0;
	
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
					oddsList.add(temps);
				}
				n++;	
			}
		}
		double win1 = 0.0d;
		double win2 = 0.0d;

		for (int i = 0; i < trips.size();i++) 
		{ 		      
			
			Double[] t = trips.get(i);
			String[] s = oddsList.get(i);
			double min = t[0];
			double oddsl = t[1];
			double oddsh = t[2];
			double winMin = 100 * min;
			double totStake = 100 + winMin;
			

			double stake1 = totStake / (1 + oddsl);
			double stake2 = totStake - 100 - stake1;

			win1 = (1 + oddsl) * stake1;
			win2 = (1 + oddsh) * stake2;


			int stake1tmp = (int) (100 * stake1);
			int stake2tmp =  (int)(100 * stake2);
			double stake1rnd = (double) stake1tmp / 100;
			double stake2rnd = (double) stake2tmp / 100;
			
			int win1tmp = (int) (100 * win1);
			int win2tmp = (int) (100 * win2);
			double win1rnd = (double) win1tmp / 100;
			double win2rnd = (double) win2tmp / 100;
			
			winMin += 100;
			
			int winMintmp = (int) (100 * winMin);
			double winMinrnd = (double) winMintmp / 100;
			
			int totStaketmp = (int) (100 * (stake1rnd + stake2rnd + 100));
			double totStakernd = (double) totStaketmp / 100;
			
			
			if (win2 > win1){
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$").append("\n\n");
				
			}
			builder.append("At " + s[0] + " bet 100.00 and win " + (winMinrnd)).append("\n");
			builder.append("At " + s[1] + " bet " + stake1rnd + " and win " + (win1rnd)).append("\n");
			builder.append("At " + s[2] + " bet " + stake2rnd + " and win " + (win2rnd)).append("\n");
			builder.append("Total staked: " + (totStakernd));
			if (win2 > win1){
				builder.append(" with a possable return of " + win2rnd).append("\n");
			}else{
				builder.append("\n These are not great odds").append("\n");
			}
			
			if (win2 > win1){
				builder.append("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$").append("\n");
			}

		}   
		
		return (win2 > win1);

	}
	
}



/*

	 StringBuilder calcOdds(Document doc){

	 StringBuilder builder = new StringBuilder();


	 String[] temps = new String[3];
	 Double[] tempd = new Double[3];
	 List<Double[]> trips = new ArrayList<Double[]>();
	 List<String[]> odds = new ArrayList<String[]>();



	 elementsAll = doc.body().select("*");
	 elementsAll = doc.body().select("*:matches(^[0-9]* /[0-9]*$)"); // Nb no space after *


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



	String readString = readFromFile(context);
	System.out.println("readString===" + readString);


	Element names = doc.select("className.side-name").first();
	// div with class=masthead



	//			Elements elems2 = doc.body().select("*:contains(d)");
	//		Elements elems2 = doc.body().select("*:matches(/)");
	//		Elements elems2 = doc.body().select("*:matches([0-9]/|(Draw))");
	//	Elements elems2 = doc.body().select("*:matches(^[0-9]* /[0-9]*$|(Draw))");	// Nb no space after *
	Elements elems2 = doc.body().select("*:matches(^[0-9]* /[0-9]*$)");				// Nb no space after *


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

//				System.out.print(ix + "ix ===" + n);
//
//				System.err.print(element.ownText() + "=element.ownText() String ==" + s);
//				System.err.print(element.ownText() + "=element.ownText() parsed ==" + r);

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
			builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$").append("\n");


		}
		builder.append((s[0] + "|||" + s[1] + "|||" + s[2])).append("\n");
		builder.append(("100.00"  + "|||" + stake1 + "|||" + stake2)).append("\n");
		builder.append((winMin  + "|||" + win1 + "|||" + win2)).append("\n");
		builder.append(("____________________")).append("\n");

		if (win2 > win1){
			builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			builder.append("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$").append("\n");

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

*/


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

/*
17/20|||3/1|||31/10
100.00|||46.25|||38.75
85.0|||185.0|||158.875
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$23/14|||19/10|||27/10
100.00|||91.13300492610837|||73.15270935960591
164.28571428571428|||264.2857142857143|||270.6650246305419
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/11|||3/1|||17/4
100.00|||43.18181818181819|||29.54545454545456
72.72727272727273|||172.72727272727275|||155.11363636363643
____________________
7/10|||10/3|||41/10
100.00|||39.230769230769226|||30.769230769230774
70.0|||170.0|||156.92307692307693
____________________
8/5|||11/6|||13/5
100.00|||91.76470588235296|||68.23529411764704
160.0|||260.0|||245.64705882352936
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$23/14|||19/10|||27/10
100.00|||91.13300492610837|||73.15270935960591
164.28571428571428|||264.2857142857143|||270.6650246305419
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$7/10|||10/3|||41/10
100.00|||39.230769230769226|||30.769230769230774
70.0|||170.0|||156.92307692307693
____________________
8/11|||3/1|||17/4
100.00|||43.18181818181819|||29.54545454545456
72.72727272727273|||172.72727272727275|||155.11363636363643
____________________
9/10|||16/5|||16/5
100.00|||45.238095238095234|||44.761904761904766
90.0|||190.0|||188.00000000000003
____________________
8/5|||11/6|||13/5
100.00|||91.76470588235296|||68.23529411764704
160.0|||260.0|||245.64705882352936
____________________
3/2|||2/1|||53/20
100.00|||83.33333333333333|||66.66666666666667
150.0|||250.0|||243.33333333333334
____________________
17/20|||3/1|||31/10
100.00|||46.25|||38.75
85.0|||185.0|||158.875
____________________
5/4|||23/10|||53/20
100.00|||68.18181818181819|||56.81818181818181
125.0|||225.0|||207.38636363636363
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$13/12|||11/4|||3/1
100.00|||55.55555555555555|||52.777777777777764
108.33333333333333|||208.33333333333331|||211.11111111111106
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$11/10|||13/5|||53/20
100.00|||58.33333333333333|||51.66666666666667
110.00000000000001|||210.0|||188.58333333333334
____________________
19/16|||23/10|||13/5
100.00|||66.2878787878788|||52.462121212121204
118.75|||218.75000000000003|||188.86363636363635
____________________
5/6|||14/5|||41/10
100.00|||48.245614035087726|||35.08771929824562
83.33333333333334|||183.33333333333334|||178.94736842105263
____________________
8/5|||2/1|||5/2
100.00|||86.66666666666667|||73.33333333333333
160.0|||260.0|||256.66666666666663
____________________
1/6|||38/5|||20/1
100.00|||13.565891472868216|||3.100775193798441
16.666666666666664|||116.66666666666666|||65.11627906976726
____________________
6/4|||21/10|||23/10
100.00|||80.64516129032258|||69.35483870967742
150.0|||250.0|||228.8709677419355
____________________
3/5|||33/10|||5/1
100.00|||37.2093023255814|||22.790697674418603
60.0|||160.0|||136.74418604651163
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/13|||7/2|||11/2
100.00|||35.8974358974359|||25.64102564102565
61.53846153846154|||161.53846153846155|||166.6666666666667
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/7|||5/2|||3/1
100.00|||61.224489795918366|||53.06122448979591
114.28571428571428|||214.28571428571428|||212.24489795918365
____________________
23/18|||9/4|||12/5
100.00|||70.08547008547008|||57.69230769230769
127.77777777777777|||227.77777777777774|||196.15384615384616
____________________
6/5|||23/10|||13/5
100.00|||66.66666666666667|||53.33333333333333
120.0|||220.0|||192.0
____________________
4/7|||7/2|||6/1
100.00|||34.92063492063492|||22.22222222222222
57.14285714285714|||157.14285714285714|||155.55555555555554
____________________
23/18|||11/5|||13/5
100.00|||71.18055555555554|||56.59722222222223
127.77777777777777|||227.77777777777774|||203.75000000000003
____________________
10/13|||3/1|||10/3
100.00|||44.23076923076923|||32.6923076923077
76.92307692307693|||176.92307692307693|||141.6666666666667
____________________
11/19|||10/3|||5/1
100.00|||36.43724696356275|||21.45748987854251
57.89473684210527|||157.89473684210526|||128.74493927125508
____________________
7/19|||21/5|||8/1
100.00|||26.31578947368421|||10.526315789473681
36.84210526315789|||136.8421052631579|||94.73684210526314
____________________
13/10|||43/20|||12/5
100.00|||73.01587301587301|||56.98412698412699
130.0|||229.99999999999997|||193.74603174603175
____________________
8/13|||16/5|||47/10
100.00|||38.46153846153846|||23.076923076923087
61.53846153846154|||161.53846153846155|||131.5384615384616
____________________
17/20|||11/4|||17/5
100.00|||49.333333333333336|||35.666666666666664
85.0|||185.0|||156.93333333333334
____________________
1/2|||39/10|||6/1
100.00|||30.612244897959183|||19.387755102040817
50.0|||150.0|||135.71428571428572
____________________
4/3|||2/1|||5/2
100.00|||77.77777777777777|||55.55555555555554
133.33333333333331|||233.33333333333331|||194.4444444444444
____________________
7/5|||41/20|||27/10
100.00|||78.68852459016394|||61.31147540983606
140.0|||240.0|||226.85245901639345
____________________
8/13|||7/2|||9/2
100.00|||35.8974358974359|||25.64102564102565
61.53846153846154|||161.53846153846155|||141.02564102564108
____________________
11/8|||19/10|||13/5
100.00|||81.89655172413794|||55.603448275862064
137.5|||237.5|||200.17241379310343
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$3/4|||57/20|||5/1
100.00|||45.45454545454545|||29.545454545454547
75.0|||175.0|||177.27272727272728
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$10/13|||13/5|||19/4
100.00|||49.14529914529915|||27.777777777777786
76.92307692307693|||176.92307692307693|||159.72222222222226
____________________
9/5|||11/6|||21/10
100.00|||98.82352941176471|||81.17647058823529
180.0|||280.0|||251.64705882352942
____________________
7/5|||9/4|||23/10
100.00|||73.84615384615384|||66.15384615384616
140.0|||239.99999999999997|||218.30769230769232
____________________
1/4|||11/2|||13/1
100.00|||19.23076923076923|||5.76923076923077
25.0|||125.0|||80.76923076923077
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$2/1|||2/1|||21/10
100.00|||100.0|||100.0
200.0|||300.0|||310.0
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$7/4|||19/10|||9/4
100.00|||94.82758620689656|||80.17241379310344
175.0|||275.0|||260.5603448275862
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/11|||3/1|||5/1
100.00|||43.18181818181819|||29.54545454545456
72.72727272727273|||172.72727272727275|||177.27272727272737
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$1/1|||12/5|||7/2
100.00|||58.82352941176471|||41.17647058823529
100.0|||200.0|||185.2941176470588
____________________
1/11|||10/1|||39/1
100.00|||9.917355371900827|||-0.8264462809917337
9.090909090909092|||109.0909090909091|||-33.05785123966935
____________________
7/4|||9/5|||23/10
100.00|||98.21428571428572|||76.78571428571428
175.0|||275.0|||253.3928571428571
____________________
13/20|||3/1|||43/10
100.00|||41.25|||23.75
65.0|||165.0|||125.875
____________________
13/10|||11/5|||13/5
100.00|||71.875|||58.125
130.0|||230.0|||209.25
____________________
10/13|||57/20|||10/3
100.00|||45.95404595404596|||30.969030969030975
76.92307692307693|||176.92307692307693|||134.19913419913425
____________________
19/20|||57/20|||3/1
100.00|||50.64935064935065|||44.35064935064935
95.0|||195.0|||177.4025974025974
____________________
6/5|||9/4|||13/5
100.00|||67.6923076923077|||52.30769230769231
120.0|||220.0|||188.30769230769232
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$307/100|||631/100|||6424/25
100.00|||55.67715458276334|||251.32284541723666
307.0|||407.0|||64831.24120383037
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$2/1|||6/1|||183/4
100.00|||42.857142857142854|||157.14285714285714
200.0|||300.0|||7346.428571428572
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$5/2|||3/1|||20/1
100.00|||87.5|||162.5
250.0|||350.0|||3412.5
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
*/



/*
17/20|||3/1|||16/5
100.00|||46.25|||38.75
85.0|||185.0|||162.75
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$23/14|||21/10|||27/10
100.00|||85.25345622119815|||79.03225806451613
164.28571428571428|||264.2857142857143|||292.4193548387097
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$3/4|||3/1|||17/4
100.00|||43.75|||31.25
75.0|||175.0|||164.0625
____________________
7/10|||10/3|||41/10
100.00|||39.230769230769226|||30.769230769230774
70.0|||170.0|||156.92307692307693
____________________
8/5|||15/8|||13/5
100.00|||90.43478260869566|||69.56521739130434
160.0|||260.0|||250.43478260869566
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$23/14|||21/10|||27/10
100.00|||85.25345622119815|||79.03225806451613
164.28571428571428|||264.2857142857143|||292.4193548387097
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$3/4|||3/1|||17/4
100.00|||43.75|||31.25
75.0|||175.0|||164.0625
____________________
8/5|||15/8|||13/5
100.00|||90.43478260869566|||69.56521739130434
160.0|||260.0|||250.43478260869566
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$9/10|||10/3|||15/4
100.00|||43.84615384615384|||46.15384615384616
90.0|||190.0|||219.23076923076925
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$7/10|||10/3|||41/10
100.00|||39.230769230769226|||30.769230769230774
70.0|||170.0|||156.92307692307693
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$13/8|||2/1|||53/20
100.00|||87.5|||75.0
162.5|||262.5|||273.75
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$17/20|||3/1|||16/5
100.00|||46.25|||38.75
85.0|||185.0|||162.75
____________________
19/16|||23/10|||13/5
100.00|||66.2878787878788|||52.462121212121204
118.75|||218.75000000000003|||188.86363636363635
____________________
3/5|||33/10|||5/1
100.00|||37.2093023255814|||22.790697674418603
60.0|||160.0|||136.74418604651163
____________________
8/5|||2/1|||5/2
100.00|||86.66666666666667|||73.33333333333333
160.0|||260.0|||256.66666666666663
____________________
1/6|||38/5|||20/1
100.00|||13.565891472868216|||3.100775193798441
16.666666666666664|||116.66666666666666|||65.11627906976726
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$13/12|||11/4|||16/5
100.00|||55.55555555555555|||52.777777777777764
108.33333333333333|||208.33333333333331|||221.66666666666663
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$11/10|||13/5|||53/20
100.00|||58.33333333333333|||51.66666666666667
110.00000000000001|||210.0|||188.58333333333334
____________________
6/4|||21/10|||23/10
100.00|||80.64516129032258|||69.35483870967742
150.0|||250.0|||228.8709677419355
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$5/6|||14/5|||17/4
100.00|||48.245614035087726|||35.08771929824562
83.33333333333334|||183.33333333333334|||184.21052631578948
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$5/4|||23/10|||53/20
100.00|||68.18181818181819|||56.81818181818181
125.0|||225.0|||207.38636363636363
____________________
3/5|||7/2|||11/2
100.00|||35.55555555555556|||24.444444444444443
60.0|||160.0|||158.88888888888889
____________________
7/19|||21/5|||8/1
100.00|||26.31578947368421|||10.526315789473681
36.84210526315789|||136.8421052631579|||94.73684210526314
____________________
13/10|||43/20|||12/5
100.00|||73.01587301587301|||56.98412698412699
130.0|||229.99999999999997|||193.74603174603175
____________________
11/19|||10/3|||5/1
100.00|||36.43724696356275|||21.45748987854251
57.89473684210527|||157.89473684210526|||128.74493927125508
____________________
8/13|||16/5|||47/10
100.00|||38.46153846153846|||23.076923076923087
61.53846153846154|||161.53846153846155|||131.5384615384616
____________________
10/13|||3/1|||7/2
100.00|||44.23076923076923|||32.6923076923077
76.92307692307693|||176.92307692307693|||147.11538461538464
____________________
6/5|||23/10|||13/5
100.00|||66.66666666666667|||53.33333333333333
120.0|||220.0|||192.0
____________________
4/7|||7/2|||6/1
100.00|||34.92063492063492|||22.22222222222222
57.14285714285714|||157.14285714285714|||155.55555555555554
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/7|||13/5|||3/1
100.00|||59.52380952380952|||54.76190476190476
114.28571428571428|||214.28571428571428|||219.04761904761904
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$23/18|||9/4|||12/5
100.00|||70.08547008547008|||57.69230769230769
127.77777777777777|||227.77777777777774|||196.15384615384616
____________________
23/18|||11/5|||13/5
100.00|||71.18055555555554|||56.59722222222223
127.77777777777777|||227.77777777777774|||203.75000000000003
____________________
7/5|||41/20|||27/10
100.00|||78.68852459016394|||61.31147540983606
140.0|||240.0|||226.85245901639345
____________________
1/2|||39/10|||6/1
100.00|||30.612244897959183|||19.387755102040817
50.0|||150.0|||135.71428571428572
____________________
11/8|||19/10|||13/5
100.00|||81.89655172413794|||55.603448275862064
137.5|||237.5|||200.17241379310343
____________________
4/3|||21/10|||5/2
100.00|||75.26881720430107|||58.06451612903224
133.33333333333331|||233.33333333333334|||203.22580645161284
____________________
8/13|||7/2|||19/4
100.00|||35.8974358974359|||25.64102564102565
61.53846153846154|||161.53846153846155|||147.4358974358975
____________________
17/20|||11/4|||17/5
100.00|||49.333333333333336|||35.666666666666664
85.0|||185.0|||156.93333333333334
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$3/4|||57/20|||5/1
100.00|||45.45454545454545|||29.545454545454547
75.0|||175.0|||177.27272727272728
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$9/5|||11/6|||21/10
100.00|||98.82352941176471|||81.17647058823529
180.0|||280.0|||251.64705882352942
____________________
10/13|||13/5|||5/1
100.00|||49.14529914529915|||27.777777777777786
76.92307692307693|||176.92307692307693|||166.6666666666667
____________________
7/5|||9/4|||23/10
100.00|||73.84615384615384|||66.15384615384616
140.0|||239.99999999999997|||218.30769230769232
____________________
1/4|||27/5|||13/1
100.00|||19.53125|||5.46875
25.0|||125.0|||76.5625
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$2/1|||2/1|||21/10
100.00|||100.0|||100.0
200.0|||300.0|||310.0
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$8/11|||3/1|||5/1
100.00|||43.18181818181819|||29.54545454545456
72.72727272727273|||172.72727272727275|||177.27272727272737
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$7/4|||9/5|||23/10
100.00|||98.21428571428572|||76.78571428571428
175.0|||275.0|||253.3928571428571
____________________
1/11|||10/1|||39/1
100.00|||9.917355371900827|||-0.8264462809917337
9.090909090909092|||109.0909090909091|||-33.05785123966935
____________________
1/1|||5/2|||7/2
100.00|||57.142857142857146|||42.857142857142854
100.0|||200.0|||192.85714285714283
____________________
7/4|||19/10|||9/4
100.00|||94.82758620689656|||80.17241379310344
175.0|||275.0|||260.5603448275862
____________________
8/11|||12/5|||7/2
100.00|||50.802139037433165|||21.925133689839583
72.72727272727273|||172.72727272727275|||98.66310160427813
____________________
13/20|||3/1|||43/10
100.00|||41.25|||23.75
65.0|||165.0|||125.875
____________________
4/5|||57/20|||16/5
100.00|||46.75324675324675|||33.24675324675325
80.0|||180.0|||139.63636363636365
____________________
13/10|||11/5|||13/5
100.00|||71.875|||58.125
130.0|||230.0|||209.25
____________________
19/20|||57/20|||3/1
100.00|||50.64935064935065|||44.35064935064935
95.0|||195.0|||177.4025974025974
____________________
1/3|||9/2|||8/1
100.00|||24.24242424242424|||9.090909090909076
33.33333333333333|||133.33333333333331|||81.81818181818169
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$307/100|||631/100|||6424/25
100.00|||55.67715458276334|||251.32284541723666
307.0|||407.0|||64831.24120383037
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$2/1|||6/1|||183/4
100.00|||42.857142857142854|||157.14285714285714
200.0|||300.0|||7346.428571428572
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$5/2|||3/1|||20/1
100.00|||87.5|||162.5
250.0|||350.0|||3412.5
____________________
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
*/









//	final static String  allDOM = " Sports Casino EasyOdds sports Home Betting Tips All Sports Free Bets Search " +
//	"Football HomeTournamentsTeamsFootball TipsLive StreamingShow All Home Betting Tips All Sports " +
//	"Free Bets Search EasyOdds sports EasyOddsCasino Home Betting Tips Free Bets Promo Codes Bookmaker " +
//									"Reviews Betting Guides Live Streaming Browse by Sports FootballHorse RacingTennisBoxing & " +
//	"UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce " +
//	"HockeyAussie Rules FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor " +
//	"SportBasketballBaseballCyclingHandballIce HockeyAussie Rules Odds format Fractional Decimal American Location United KingdomChange" +
//	"English, GMT, GBP Apply Cancel Changes Location (see Odds and Offers for) Australia Austria Brazil Finland Germany Greece India " +
//	"Ireland Italy Kenya New Zealand Nigeria Norway Poland Russia South Africa Spain Sweden Switzerland United Kingdom World Time " +
//	"Zone Select a timezone { GMT-12:00 International Date Line West { GMT-11:00 Midway Island, Samoa { GMT-10:00 Hawaii { GMT-9:00 Alaska" +
//	"{ GMT-8:00 Pacific Time (US & Canada), Tijuana { GMT-7:00 Arizona, Mountain Time (US & Canada), Chihuahua, M... { GMT-6:00 Central Time" +
//	"(US & Canada), Central America, Guada... { GMT-5:00 Eastern Time (US & Canada), Indiana (East), Bogota... { GMT-4:00 Atlantic Time (Canada), " +
//	"Caracas, La Paz, Santiago { GMT-3:30 Newfoundland { GMT-3:00 Brasilia, Buenos Aires, Georgetown, Greenland { GMT-2:00 Mid-Atlantic " +
//	"{ GMT-1:00 Azores, Cape Verde Is. { GMT Dublin, Edinburgh, London, Lisbon, Monrovia { GMT+1:00 Amsterdam, Berlin, Brussels, Madrid, " +
//	"Paris, Rome,... { GMT+2:00 Athens, Bucharest, Cairo, Helsinki, Istanbul, Mins... { GMT+3:00 Baghdad, Kuwait, Moscow, Nairobi, St. Petersburg " +
//	"{ GMT+3:30 Tehran { GMT+4:00 Abu Dhabi, Baku, Muscat, Tbilisi, Yerevan { GMT+4:30 Kabul { GMT+5:00 Ekaterinburg, Islamabad, Karachi, Tashkent " +
//	"{ GMT+5:30 Chennai, Kolkata, Mumbai, New Delhi { GMT+5:45 Kathmandu { GMT+6:00 Almaty, Astana, Dhaka, Novosibirsk, Sri Jayawarden... { GMT+6:30 Rangoon" +
//	"{ GMT+7:00 Bangkok, Hanoi, Jakarta, Krasnoyarsk { GMT+8:00 Beijing, Chongqing, Hong Kong, Kuala Lumpur, Perth... { GMT+9:00 Osaka, Sapporo, Seoul, " +
//	"Tokyo, Yakutsk { GMT+9:30 Adelaide, Darwin { GMT+10:00 Brisbane, Canberra, Guam, Hobart, Melbourne, Port... { GMT+11:00 Magadan, New Caledonia, Solomon Is. " +
//	"{ GMT+12:00 Auckland, Fiji, Kamchatka, Marshall Is., Wellingto... { GMT+13:00 Nuku'alofa Currency { AUD Australian Dollar { BRL Brazilian Real { CHF Swiss Franc " +
//	"{ EUR Euro { GBP Pound Sterling { INR Indian Rupee { KES Kenyan Shilling { NGN Nigerian Naira { NOK Norwegian Krone { PLN Polish Zloty { RUB Russian Ruble " +
//	"{ SEK Swedish Krona { USD US Dollar { ZAR South African Rand Apply Cancel Changes Football Betting Odds Premier LeagueChampionshipEuro 2024UEFA Champions " +
//	"LeagueLa LigaBundesligaSee All Tournaments Featured Matches Today / 19:45 Euro 2024 5/1 Greece 8/13 France 3/1 Draw Today / 19:45 Euro 2024 90/1 Gibraltar " +
//	"1/100 Netherlands 40/1 Draw Today / 19:45 Euro 2024 1/6 Croatia 18/1 Armenia 7/1 Draw Today / 19:45 Euro 2024 6/4 Wales 2/1 Turkey 5/2 Draw Today / 19:45 Euro " +
//	"2024 11/4 Romania 21/20 Switzerland 5/2 Draw Today's Offers 10% Cashback on ALL Losses Sign up and place a bet to earn 10% cashback on any lost bets. Cashback " +
//	"is cash without restrictions. No Max cashout. New18+ customers only. T&Cs apply. Gambling can be addictive, please play responsibly. BeGambleAware.org. #ad " +
//	"Claim Offer Bet £10. Get £30 in FREE Bets 18+ New customers only. Opt in, bet £10 at odds 2.00+ within 7 days, no cashout. Get 6x £5 Free Bets, set events at " +
//	"odds 2.00+. 7 day bonus expiry. Debit Card / Apple Pay payments only. T&Cs apply. Gamble Responsibly. BeGambleAware.org. #ad Claim Offer Football - Bet £10 " +
//	"Get £30 18+ New customers only. Opt in, and bet £10 on football markets (odds 2.00+). No cash out. Get 6x£5 football free bets at specified odds for set " +
//									"markets, which expire after 7 days. Offer valid from 12:00 UK";
	// allTextElems ==== Sports Casino EasyOdds sports Home Betting Tips All Sports Free Bets Search Football HomeTournamentsTeamsFootball TipsLive StreamingShow All Home Betting Tips All Sports Free Bets Search EasyOdds sports EasyOddsCasino Home Betting Tips Free Bets Promo Codes Bookmaker Reviews Betting Guides Live Streaming Browse by Sports FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules Odds format Fractional Decimal American Location United KingdomChange English, GMT, GBP Apply Cancel Changes Location (see Odds and Offers for) Australia Austria Brazil Finland Germany Greece India Ireland Italy Kenya New Zealand Nigeria Norway Poland Russia South Africa Spain Sweden Switzerland United Kingdom World Time Zone Select a timezone { GMT-12:00 International Date Line West { GMT-11:00 Midway Island, Samoa { GMT-10:00 Hawaii { GMT-9:00 Alaska { GMT-8:00 Pacific Time (US & Canada), Tijuana { GMT-7:00 Arizona, Mountain Time (US & Canada), Chihuahua, M... { GMT-6:00 Central Time (US & Canada), Central America, Guada... { GMT-5:00 Eastern Time (US & Canada), Indiana (East), Bogota... { GMT-4:00 Atlantic Time (Canada), Caracas, La Paz, Santiago { GMT-3:30 Newfoundland { GMT-3:00 Brasilia, Buenos Aires, Georgetown, Greenland { GMT-2:00 Mid-Atlantic { GMT-1:00 Azores, Cape Verde Is. { GMT Dublin, Edinburgh, London, Lisbon, Monrovia { GMT+1:00 Amsterdam, Berlin, Brussels, Madrid, Paris, Rome,... { GMT+2:00 Athens, Bucharest, Cairo, Helsinki, Istanbul, Mins... { GMT+3:00 Baghdad, Kuwait, Moscow, Nairobi, St. Petersburg { GMT+3:30 Tehran { GMT+4:00 Abu Dhabi, Baku, Muscat, Tbilisi, Yerevan { GMT+4:30 Kabul { GMT+5:00 Ekaterinburg, Islamabad, Karachi, Tashkent { GMT+5:30 Chennai, Kolkata, Mumbai, New Delhi { GMT+5:45 Kathmandu { GMT+6:00 Almaty, Astana, Dhaka, Novosibirsk, Sri Jayawarden... { GMT+6:30 Rangoon { GMT+7:00 Bangkok, Hanoi, Jakarta, Krasnoyarsk { GMT+8:00 Beijing, Chongqing, Hong Kong, Kuala Lumpur, Perth... { GMT+9:00 Osaka, Sapporo, Seoul, Tokyo, Yakutsk { GMT+9:30 Adelaide, Darwin { GMT+10:00 Brisbane, Canberra, Guam, Hobart, Melbourne, Port... { GMT+11:00 Magadan, New Caledonia, Solomon Is. { GMT+12:00 Auckland, Fiji, Kamchatka, Marshall Is., Wellingto... { GMT+13:00 Nuku'alofa Currency { AUD Australian Dollar { BRL Brazilian Real { CHF Swiss Franc { EUR Euro { GBP Pound Sterling { INR Indian Rupee { KES Kenyan Shilling { NGN Nigerian Naira { NOK Norwegian Krone { PLN Polish Zloty { RUB Russian Ruble { SEK Swedish Krona { USD US Dollar { ZAR South African Rand Apply Cancel Changes Football Betting Odds Premier LeagueChampionshipEuro 2024UEFA Champions LeagueLa LigaBundesligaSee All Tournaments Featured Matches Today / 19:45 Euro 2024 5/1 Greece 8/13 France 3/1 Draw Today / 19:45 Euro 2024 90/1 Gibraltar 1/100 Netherlands 40/1 Draw Today / 19:45 Euro 2024 1/6 Croatia 18/1 Armenia 7/1 Draw Today / 19:45 Euro 2024 6/4 Wales 2/1 Turkey 5/2 Draw Today / 19:45 Euro 2024 11/4 Romania 21/20 Switzerland 5/2 Draw Today's Offers 10% Cashback on ALL Losses Sign up and place a bet to earn 10% cashback on any lost bets. Cashback is cash without restrictions. No Max cashout. New18+ customers only. T&Cs apply. Gambling can be addictive, please play responsibly. BeGambleAware.org. #ad Claim Offer Bet £10. Get £30 in FREE Bets 18+ New customers only. Opt in, bet £10 at odds 2.00+ within 7 days, no cashout. Get 6x £5 Free Bets, set events at odds 2.00+. 7 day bonus expiry. Debit Card / Apple Pay payments only. T&Cs apply. Gamble Responsibly. BeGambleAware.org. #ad Claim Offer Football - Bet £10 Get £30 18+ New customers only. Opt in, and bet £10 on football markets (odds 2.00+). No cash out. Get 6x£5 football free bets at specified odds for set markets, which expire after 7 days. Offer valid from 12:00 UK";
	
// allTextElems ==== Sports Casino EasyOdds sports Home Betting Tips All Sports Free Bets Search Football HomeTournamentsTeamsFootball TipsLive StreamingShow All Home Betting Tips All Sports Free Bets Search EasyOdds sports EasyOddsCasino Home Betting Tips Free Bets Promo Codes Bookmaker Reviews Betting Guides Live Streaming Browse by Sports FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules FootballHorse RacingTennisBoxing & UFCCricketGolfDartsSpecialsRugby UnionRugby LeagueUS FootballSnookerMotor SportBasketballBaseballCyclingHandballIce HockeyAussie Rules Odds format Fractional Decimal American Location United KingdomChange English, GMT, GBP Apply Cancel Changes Location (see Odds and Offers for) Australia Austria Brazil Finland Germany Greece India Ireland Italy Kenya New Zealand Nigeria Norway Poland Russia South Africa Spain Sweden Switzerland United Kingdom World Time Zone Select a timezone { GMT-12:00 International Date Line West { GMT-11:00 Midway Island, Samoa { GMT-10:00 Hawaii { GMT-9:00 Alaska { GMT-8:00 Pacific Time (US & Canada), Tijuana { GMT-7:00 Arizona, Mountain Time (US & Canada), Chihuahua, M... { GMT-6:00 Central Time (US & Canada), Central America, Guada... { GMT-5:00 Eastern Time (US & Canada), Indiana (East), Bogota... { GMT-4:00 Atlantic Time (Canada), Caracas, La Paz, Santiago { GMT-3:30 Newfoundland { GMT-3:00 Brasilia, Buenos Aires, Georgetown, Greenland { GMT-2:00 Mid-Atlantic { GMT-1:00 Azores, Cape Verde Is. { GMT Dublin, Edinburgh, London, Lisbon, Monrovia { GMT+1:00 Amsterdam, Berlin, Brussels, Madrid, Paris, Rome,... { GMT+2:00 Athens, Bucharest, Cairo, Helsinki, Istanbul, Mins... { GMT+3:00 Baghdad, Kuwait, Moscow, Nairobi, St. Petersburg { GMT+3:30 Tehran { GMT+4:00 Abu Dhabi, Baku, Muscat, Tbilisi, Yerevan { GMT+4:30 Kabul { GMT+5:00 Ekaterinburg, Islamabad, Karachi, Tashkent { GMT+5:30 Chennai, Kolkata, Mumbai, New Delhi { GMT+5:45 Kathmandu { GMT+6:00 Almaty, Astana, Dhaka, Novosibirsk, Sri Jayawarden... { GMT+6:30 Rangoon { GMT+7:00 Bangkok, Hanoi, Jakarta, Krasnoyarsk { GMT+8:00 Beijing, Chongqing, Hong Kong, Kuala Lumpur, Perth... { GMT+9:00 Osaka, Sapporo, Seoul, Tokyo, Yakutsk { GMT+9:30 Adelaide, Darwin { GMT+10:00 Brisbane, Canberra, Guam, Hobart, Melbourne, Port... { GMT+11:00 Magadan, New Caledonia, Solomon Is. { GMT+12:00 Auckland, Fiji, Kamchatka, Marshall Is., Wellingto... { GMT+13:00 Nuku'alofa Currency { AUD Australian Dollar { BRL Brazilian Real { CHF Swiss Franc { EUR Euro { GBP Pound Sterling { INR Indian Rupee { KES Kenyan Shilling { NGN Nigerian Naira { NOK Norwegian Krone { PLN Polish Zloty { RUB Russian Ruble { SEK Swedish Krona { USD US Dollar { ZAR South African Rand Apply Cancel Changes Football Betting Odds Premier LeagueChampionshipEuro 2024UEFA Champions LeagueLa LigaBundesligaSee All Tournaments Featured Matches Today / 19:45 Euro 2024 5/1 Greece 8/13 France 3/1 Draw Today / 19:45 Euro 2024 90/1 Gibraltar 1/100 Netherlands 40/1 Draw Today / 19:45 Euro 2024 1/6 Croatia 18/1 Armenia 7/1 Draw Today / 19:45 Euro 2024 6/4 Wales 2/1 Turkey 5/2 Draw Today / 19:45 Euro 2024 11/4 Romania 21/20 Switzerland 5/2 Draw Today's Offers 10% Cashback on ALL Losses Sign up and place a bet to earn 10% cashback on any lost bets. Cashback is cash without restrictions. No Max cashout. New18+ customers only. T&Cs apply. Gambling can be addictive, please play responsibly. BeGambleAware.org. #ad Claim Offer Bet £10. Get £30 in FREE Bets 18+ New customers only. Opt in, bet £10 at odds 2.00+ within 7 days, no cashout. Get 6x £5 Free Bets, set events at odds 2.00+. 7 day bonus expiry. Debit Card / Apple Pay payments only. T&Cs apply. Gamble Responsibly. BeGambleAware.org. #ad Claim Offer Football - Bet £10 Get £30 18+ New customers only. Opt in, and bet £10 on football markets (odds 2.00+). No cash out. Get 6x£5 football free bets at specified odds for set markets, which expire after 7 days. Offer valid from 12:00 UK";
	


