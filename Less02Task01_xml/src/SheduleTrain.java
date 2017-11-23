import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trains")
public class SheduleTrain {

    @XmlElement(name = "train")
    private List<Train> trainList = new ArrayList<>();

    public void add(Train train){
        trainList.add(train);
    }



}
