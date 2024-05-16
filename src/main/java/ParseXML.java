import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXML {
    public static List<Employee> parseXML(String nameXML) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> staff = new ArrayList<>();
        Employee employee = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(nameXML));
        Node root = document.getDocumentElement();

        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                NamedNodeMap map = element.getAttributes();

                for (int j = 0; j < map.getLength(); j++) {
                    employee = new Employee(
                            Long.parseLong(map.getNamedItem("id").getNodeValue()),
                            map.getNamedItem("firstName").getNodeValue(),
                            map.getNamedItem("lastName").getNodeValue(),
                            map.getNamedItem("country").getNodeValue(),
                            Integer.parseInt(map.getNamedItem("age").getNodeValue())
                    );
                }
                staff.add(employee);
            }
        }
        return staff;
    }
}
