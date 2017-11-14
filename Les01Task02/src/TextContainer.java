import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path="d:\\file.txt")
public class TextContainer {

    @Saver
    public void save(String path, String text) {

        try(FileWriter fw = new FileWriter(path)) {
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
