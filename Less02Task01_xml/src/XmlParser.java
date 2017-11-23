import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XmlParser {
    public void getTrains(Date dateFro, Date dateT) throws IOException{

        try {
            File xmlFile = new File(Main.XMLFILE);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(xmlFile);

            Element root = document.getDocumentElement();

            NodeList nodeList = root.getChildNodes();

            for (int i=0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);

                HashMap<String, String > trainsMap = new HashMap<>();

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;

                    trainsMap.put(element.getTagName(), element.getNodeValue());
//                    System.out.println(element.getTagName());
                    String stationFrom = getElementValue(element,"from");
                    String stationTo = getElementValue(element,"to");
                    String date = getElementValue(element,"date");
                    String time = getElementValue(element,"departure");

                    if (getDate(date, time).getTime() - dateFro.getTime() > 0 && dateT.getTime() - getDate(date, time).getTime() > 0 )
                    {
                        System.out.println("Train: "+stationFrom+" - "+stationTo + ": "+getDate(date, time));
                    }else
                    {
                        System.out.println("No trains in selected date!");
                    }
                }

            }

        }catch (Exception pce)
        {
            pce.printStackTrace();

        }

    }

    private Date getDate(String dateStr, String timeStr) throws Exception
    {
        try {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(dateStr);
            stringBuilder.append(" ");
            stringBuilder.append(timeStr);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy HH:MM");
            Date date = simpleDateFormat.parse(stringBuilder.toString());

            return date;

        }catch (Exception e)
        {
            e.printStackTrace();
            return new Date();
        }

    }

    private String getElementValue(Element element, String nameTag){
        return element.getElementsByTagName(nameTag).item(0).getChildNodes().item(0).getNodeValue();
    }
}
