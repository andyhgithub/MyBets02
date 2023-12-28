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
import org.jsoup.parser.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
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
						Log.i(TAG_INFO, "Connection");

						builder.append("Connecting to " + url + "\n");
						
						
						con.ignoreHttpErrors(true);
						Log.i(TAG_INFO, "Ignor http errors");
						

						Document doc = con.get();
						Log.i(TAG_INFO, "Get Document");
					
						builder.append("Got page..."  + "\n");
						builder.append("Page title: " + doc.title() + "\n");
						
						System.out.println("doc.title()===" + doc.title());
						
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
		
		
		Iterator matchesIt = matchesList.iterator();
		Iterator resultsIt = resultsList.iterator();
		Iterator bookiesIt = bookiesList.iterator();
		Iterator oddsIt = oddsList.iterator();
		
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
		String[] splitList = new String[splitText.length + 1];
		
		for (String text : splitText){
	
			String[] marketText = new String[2];
			if (regExp == "data-event-name=\""){
				String market = "data-market-name=\"";
				marketText = text.split(market);
			}

			if (!marketText[marketText.length - 1].startsWith("Full Time Result")){
				continue;
			}
			
			int end = text.indexOf("\"");
			splitList[nx] = text.substring(0, end);
			list.add(splitList[nx]);
			
			nx++;
		}
	
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
		
		matchsList.add(nextNew);

			for (int i = 0; i < 5; i++){

			oddsMatch = oddsPattern.matcher(nextAll);
			if (oddsMatch.find()) {
				oddsPos = oddsMatch.start();
			}
			tmpNew = nextAll.substring(oddsPos);

			endMatch = endPattern.matcher(tmpNew);
			if (endMatch.find()) {
				namesEndPos = endMatch.start();
			}else{
				return matchsList;
			}

			nextNew = tmpNew.substring(0, namesEndPos);
			nextAll = tmpNew.substring(namesEndPos);
			matchsList.add(nextNew);
		}
		return matchsList;
	}
	
	
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
	
	private StringBuilder calcOdds(Document doc){

		StringBuilder builder = new StringBuilder();

		String[] temps = new String[3];
		Double[] tempd = new Double[3];
		List<Double[]> trips = new ArrayList<Double[]>();
		List<String[]> odds = new ArrayList<String[]>();

		elementsAll = doc.body().select("*");
		elementsAll = doc.body().select("*:matches(^[0-9]* /[0-9]*$)"); // Nb no space after *
			// Nb no space after *

		String allAsText = listChildren(elementsAll);
		writeToFile(allAsText, context);

		String elementsAllText = elementsAll.text();
		
		listMatches(elementsAllText);
		
		Elements elems2 = doc.body().select("*:matches(^[0-9]* /[0-9]*$)");				// Nb no space after *

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
				n++;	
			}


		}

		for (int i = 0; i < trips.size();i++) 
		{ 		      
			Double[] t = trips.get(i);
			String[] s = odds.get(i);
			double min = t[0];
			double oddsl = t[1];
			double oddsh = t[2];
			double winMin = 100 * min;
			double totStake = 100 + winMin;
			
			double stake1 = totStake / (1 + oddsl);
			double stake2 = totStake - 100 - stake1;

			double win1 = (1 + oddsl) * stake1;
			double win2 = (1 + oddsh) * stake2;

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
		return builder;

	}
	

	private void showMap(Map map){

		for (Map.Entry<String,String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " > " + value);
		}

	}
	
	
}



