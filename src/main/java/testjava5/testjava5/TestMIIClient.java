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
		System.out.println("hiuhiuij"+ ncg.executeGETService());
	}

	public String executeGETService(){
		String output1 = "Reached MII Server !! 4";
		String outputCode = "0";
		try {

			URL url = new URL("http://gbssapsandapps2:50200/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("GET");
			//conn.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			outputCode = "Code : "+conn.getResponseCode();
			String output;
			while ((output = br.readLine()) != null) {

				//System.out.print(output);
				output1 = output;
				//return output;
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
			output1 = e.getMessage()+e.getLocalizedMessage()+e.toString();

		} catch (IOException e) {

			e.printStackTrace();
			output1 = e.getMessage()+e.getLocalizedMessage()+e.toString();
		}
		return outputCode + " ==== " +output1;
	}
}