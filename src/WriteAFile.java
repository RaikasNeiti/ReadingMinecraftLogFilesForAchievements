import java.io.*;
import java.util.List;

public class WriteAFile {
    public void WriteAFile(List<String> list) throws IOException {
        try {
            File logachievements = new File("logfiles.txt");
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(logachievements, true));
            for (int i= 0; i < list.size() - 3;i+=4){
                myWriter.write(list.get(i) + " " + list.get(i+1) + " " + list.get(i+2) + " " + list.get(i+3));
                myWriter.newLine();
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
