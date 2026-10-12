package XmlReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

public class XmlDataLoader {

    public static <T> Map<String, T> loadData(String filePath, Class<T> clazz) {

        Map<String, T> dataMap = new HashMap<>();

        try {
            // Încărcăm fișierul XML
            File file = new File(filePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            // Citim seturile de date din XML
            NodeList nodeList = document
                    .getElementsByTagName("dataSets")
                    .item(0)
                    .getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    String key = element.getNodeName();

                    // Creăm un obiect din clasa primită
                    T obj = clazz.getDeclaredConstructor().newInstance();

                    // Completăm câmpurile obiectului cu valorile din XML
                    for (Field field : clazz.getDeclaredFields()) {

                        field.setAccessible(true);
                        String fieldName = field.getName();

                        if (element.getElementsByTagName(fieldName).getLength() > 0) {

                            String value = element
                                    .getElementsByTagName(fieldName)
                                    .item(0)
                                    .getTextContent();

                            // Verificăm dacă acel câmp este o listă
                            if (field.getType().equals(List.class)
                                    && value != null
                                    && !value.isEmpty()) {

                                List<String> values =
                                        Arrays.asList(value.split(",\\s*"));

                                field.set(obj, values);

                            } else {

                                // Completăm câmpurile de tip String sau int
                                if (field.getType().equals(int.class)) {
                                    field.set(obj, Integer.parseInt(value));
                                } else {
                                    field.set(obj, value);
                                }
                            }
                        }
                    }

                    // Salvăm obiectul în Map
                    dataMap.put(key, obj);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }
}
