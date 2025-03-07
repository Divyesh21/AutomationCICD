package dgSeleniumFramework.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public void getJsonDataToMap() throws IOException {
		
		FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "/src/test/java/dgSeleniumFramework/data/PurchaseOrder.json"));
		
		
		ObjectMapper mapper=new ObjectMapper();
	}

}
