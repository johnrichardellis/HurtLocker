import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public String readRawDataToString(){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");



        try(Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
