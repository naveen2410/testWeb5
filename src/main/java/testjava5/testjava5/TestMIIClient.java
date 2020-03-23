package testjava5.testjava5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestMIIClient {

	public static void main(String[] args) {

		TestMIIClient ncg = new TestMIIClient();			
		ncg.executeGETService();
	}

	public String executeGETService(){
		String output = "Reached MII Server !! 1";
		String outputCode = "0";
		try {

			URL url = new URL("http://gbssapsandapps2:50200/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("GET");
			//conn.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			outputCode = "Code : "+conn.getResponseCode();

			while ((output = br.readLine()) != null) {

				System.out.print(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return outputCode;
	}
}