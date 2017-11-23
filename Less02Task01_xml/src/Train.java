import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Train {
    private String stationFrom;
    private String stationTo;
    private String dateDeparture;
    private String departure;

    public Train(){}

    public Train(String stationFrom, String stationTo, String dateDeparture, String departure)
    {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.dateDeparture = dateDeparture;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train: "+stationFrom+" - "+stationTo + ": "+dateDeparture+" "+departure;
    }

    @XmlElement(name = "from")
    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    @XmlElement(name = "to")
    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }

    @XmlElement(name = "date")
    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public String getStationTo() {
        return stationTo;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public String getDeparture() {
        return departure;
    }

}
