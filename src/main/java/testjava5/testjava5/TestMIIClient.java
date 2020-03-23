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
		String output = "Reached MII Server !!";
		try {

			URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setRequestMethod("GET");
			//conn.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			

			while ((output = br.readLine()) != null) {

				System.out.print(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return output;
	}
}