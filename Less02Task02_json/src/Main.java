import InnerTypes.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception{

        String json = "";
        //InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("JsonSample.txt"));
        try (RandomAccessFile file = new RandomAccessFile("JsonSample.txt", "r")) {
            byte[] buffer = new byte[(int)file.length()];
            file.read(buffer);
            json = new String(buffer);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        if(json.isEmpty()) {
            System.out.println("Empty file.");
            return;
        }
        Gson gson = new GsonBuilder().create();
        Customer customer = (Customer) gson.fromJson(json.toString(), Customer.class);

        System.out.println(customer);

    }

}
