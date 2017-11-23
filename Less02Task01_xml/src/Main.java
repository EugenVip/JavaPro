import com.sun.jmx.remote.internal.Unmarshal;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Main
{
    static final String XMLFILE = "trainshedule.xml";
    static final Date dateFrom = new Date(111, 10, 20, 15,00, 00);
    static final Date dateTo = new Date(117, 10, 20, 19,00);

    public static void main(String[] args) throws Exception
    {
        XmlParser xmlParcer = new XmlParser();
        xmlParcer.getTrains(dateFrom, dateTo);

        //
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:MM");

        SheduleTrain sheduleTrain = new SheduleTrain();
        ///
        try {
            File file = new File(XMLFILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(SheduleTrain.class);
            Unmarshaller unmarshal = jaxbContext.createUnmarshaller();

            sheduleTrain = (SheduleTrain) unmarshal.unmarshal(file);

        }catch (Exception e)
        {e.printStackTrace();}

        ///
        try
        {
            File file = new File(XMLFILE);
            JAXBContext jaxbContext = JAXBContext.newInstance(SheduleTrain.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            Date date = new Date(117, 10, 21, 16, 22);
            sheduleTrain.add(new Train("Lviv", "Vroclav", simpleDateFormat.format(date), simpleDateFormatTime.format(date)) );

            date = new Date(117, 10, 23, 05, 22);
            sheduleTrain.add(new Train("Vroclav", "Lviv", simpleDateFormat.format(date), simpleDateFormatTime.format(date)) );
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(sheduleTrain, file);
            //marshaller.marshal(sheduleTrain, System.out);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
