package ReadfromFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.devtools.v85.io.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Readfromjson {
    public String  readFile(String attribute) throws IOException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+"/testData/readData.json");
        Object obj=jsonParser.parse(reader);//C:\Users\Yaswanth Asapu\Evaluation270223\src\test\java\testData\readData.json

        JsonObject jsonObject = (JsonObject) obj;
        String  value = jsonObject.get(attribute).getAsString();
        return value;
    }

}
