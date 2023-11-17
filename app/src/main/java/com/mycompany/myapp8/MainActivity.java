package com.mycompany.myapp8;

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
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.*;
import java.io.*;
import android.text.method.*;

public class MainActivity extends Activity
{

    private TextView result;
    private Button fetch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        result = (TextView) findViewById(R.id.result);
		result.setMovementMethod(new ScrollingMovementMethod());

        fetch = (Button) findViewById(R.id.fetch);
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


						Elements elements = doc.body().select("*");
						
						
						System.out.println("elms sz = "+ elements.size());
						System.err.println("elms sz = "+ elements.size());
						
						
						
						for (Element element : elements) {
				
							
		
							System.out.print("!" + element.ownText() + "-");
			
							
						}

						
						
						
						Elements elemSingle = doc.body().select("*:matches(Armenia)");
						for (Element elementS : elemSingle) {
							System.err.println("... element.id())..." + elementS.id());
							System.err.println("... element.tagName())..." + elementS.tagName());
							System.err.println("... element.tag())..." + elementS.tag());
							System.err.println("... element.className())..." + elementS.className());
							System.err.println("... element.data())..." + elementS.data());
							System.err.println("... element.cssSelector())..." + elementS.cssSelector());
							System.err.println("... element.attributes())..." + elementS.attributes());
							System.err.println("... element.classNames())..." + elementS.classNames());
							System.err.println("... element.text())..." + elementS.text());
							System.err.println("... element.ownText())..." + elementS.ownText());
							System.err.println("... element.nodeName())..." + elementS.nodeName());

							System.out.println("... element.outerHtml())..." + elementS.outerHtml());
							System.out.println("... element.hasText())..." + elementS.hasText());
							System.out.println("... element.hasText())..." + elementS.hasText());

							System.out.println("... element.text().length(.." + elementS.text().length());
							System.out.println("... element.text().length(.." + elementS.text().length());

							System.out.println(elementS.ownText() + "===elementS.ownText" );
							
						}
						
						
						
						//			Elements elems2 = doc.body().select("*:contains(d)");
						//		Elements elems2 = doc.body().select("*:matches(/)");
						//		Elements elems2 = doc.body().select("*:matches([0-9]/|(Draw))");
						//	Elements elems2 = doc.body().select("*:matches(^[0-9]*/[0-9]*$|(Draw))");
						Elements elems2 = doc.body().select("*:matches(^[0-9]*/[0-9]*$)");


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
							
								
								
								System.out.println(ix + "ix ===" + n);
						
								System.err.println(element.ownText() + "=element.ownText() String ==" + s);
								System.err.println(element.ownText() + "=element.ownText() parsed ==" + r);
								
								
								n++;
							}


							System.out.println(element.ownText() + "===" + r);

							System.out.println(element.ownText() + "===" + r);
							System.out.println("... element.id())..." + element.id());
							System.out.println("... element.tagName())..." + element.tagName());
							System.out.println("... element.tag())..." + element.tag());
							System.out.println("... element.className())..." + element.className());
							System.out.println("... element.data())..." + element.data());
							System.out.println("... element.cssSelector())..." + element.cssSelector());
							System.out.println("... element.attributes())..." + element.attributes());
							System.out.println("... element.classNames())..." + element.classNames());
							System.out.println("... element.text())..." + element.text());
							System.out.println("... element.ownText())..." + element.ownText());
							System.out.println("... element.nodeName())..." + element.nodeName());

							System.out.println("... element.outerHtml())..." + element.outerHtml());
							System.out.println("... element.hasText())..." + element.hasText());
							System.out.println("... element.hasText())..." + element.hasText());

							System.out.println("... element.text().length(.." + element.text().length());
							System.out.println("... element.text().length(.." + element.text().length());

							System.out.println(element.ownText() + "===" + r);
							
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


						builder.append("axxxx");;

						//		builder.append("Error : ").append(e.getLocalizedMessage()).append("\n");

						//		builder.append("Error : ").append(e.getMessage()).append(e.getLocalizedMessage()).append("\n");
						System.err.println("Error = " + e.getMessage());
						System.out.println("error = " + e.getMessage());
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

}


/*                   
Edit
*/








