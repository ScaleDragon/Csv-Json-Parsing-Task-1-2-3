import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //TODO Task 1
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = ParseCSV.parseCSV(columnMapping, fileName);

        String json = ListToJson.listToJson(list);
        WriteString.writeString(json, "data");

        //TODO Task 2
        String xmlFile = "data.xml";
        List<Employee> list2 = ParseXML.parseXML(xmlFile);

        String json2 = ListToJson.listToJson(list2);
        WriteString.writeString(json2, "data2");

        //TODO Task 3
        String json3 = ReadString.readString("data.json");
        List<Employee> list3 = JsonToList.jsonToList(json3);
        System.out.println(list3);

    }
}