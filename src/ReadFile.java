import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        List<String> finallist = new ArrayList<>();
        final File folder = new File("logs");
        final List<File> fileList = Arrays.asList(folder.listFiles());
        for(int i=0; i < fileList.size(); i++){
            System.out.println(fileList.get(i));
            try {
                File myObj = new File(String.valueOf(fileList.get(i)));
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    //System.out.println("Date: " + fileList.get(i).toString().substring(5, 15) + " Log: " + data);
                    if(data.contains("has made the advancement")){
                        String[] splited = data.split("\\s+", 9);
                        finallist.add(fileList.get(i).toString().substring(5, 15));
                        finallist.add(splited[0]);
                        finallist.add(splited[3]);
                        finallist.add(splited[8]);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        WriteAFile write = new WriteAFile();
        write.WriteAFile(finallist);
    }
}



