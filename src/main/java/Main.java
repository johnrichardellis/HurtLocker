import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString(){

//        replaceAllSymbolsWithColons();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder(""); // empty result sb

        try(Scanner scanner = new Scanner(file)) { // instance of new scanner

            while (scanner.hasNextLine()) { // keep using scanner while there is a next line
//                String line = scanner.nextLine(); //
                result.append(scanner.nextLine()).append("\n"); // add the line and new line to result
            }
        } catch (IOException e) { // might throw exception
            e.printStackTrace(); // print stack trace if so
        }
//        System.out.println(result.toString());
        return result.toString(); // convert sb to string and return

    }



    public String replaceAllSymbolsWithColons() {  // used to change all symbols to colon instead

        try {
            String result = "";
            String groceryList = readRawDataToString();
            Pattern pat = Pattern.compile("[;#^*%]"); // replace these symbols
            Matcher mat = pat.matcher(groceryList); // in our groceryList
            result = result + mat.replaceAll(":"); // with the colon
            System.out.println(result);
            return result;
        } catch(Exception e) {
            throw new UnsupportedOperationException();
        }
//        System.out.println(result);
    }


//    public String correctNames()


    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }












}
