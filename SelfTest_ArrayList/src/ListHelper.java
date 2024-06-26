/**
 * Commonly used list operations.
 * @author ZXY
 * Goal: how to read file and print content to screen, and how to save to file.
 */

import java.util.*;
import java.io.*;

public class ListHelper {
    
    private String encoding;
    
    /**
     * Construct a ListHelper object with the default utf8 encoding
     */
    public ListHelper() {
        encoding = "UTF-8";
        // Example: ListHelper listHelper1 = new ListHelper();
    }

    /**
     * Construct a FileFunctions object with the given encoding
     * @param anEncoding the file encoding
     */
    public ListHelper(String anEncoding) {
        encoding = anEncoding;
        // Example: ListHelper listHelper2 = new ListHelper("ISO-8859-1");
    }

    
    /**
     * Get a list of Strings where each String is one line in the file.
     * @param fileName the name of the file to read
     * @return a List containing the lines in the file
     * @throws FileNotFoundException if there is a problem with the file
     */
    public List<String> readFileLineByLine(String fileName)
        throws FileNotFoundException { // TODO
        // first create an empty list to store
        List<String> lines = new ArrayList<>();
        // read the doc
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }
    
    /**
     * Print a list to the screen, with or without line numbers
     * @param theList the list to print
     * @param withLineNum print line numbers if true
     */
    public <T> void printList(List<T> theList, boolean withLineNum){
        // TODO
        if (withLineNum){
            for (int i = 0; i < theList.size(); i++) {
                int lineNum = i + 1;
                System.out.println(lineNum + ":" + theList.get(i));
            }
        } else {
            for (T item: theList){  // = int i = 0 ..., 但是不能用i做任何事了
                System.out.println(item);
            }
        }
    }

    /**
     * Save the contents of the List parameter to a file
     * @param theList the list to save
     * @param fileName the name of the file to write to
     * @throws FileNotFoundException if there is a problem with the file
     */
    public <T> void saveListToFile(List<T> theList, String fileName) 
        throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter dest = new PrintWriter(new File(fileName), encoding);
        // TODO
        for(T item: theList){
            dest.println(item);
        }
        dest.close();
    }

    /**
     * Save a String to a file
     * @param theString the String to save
     * @param fileName the name of the file
     * @throws FileNotFoundException if file problems occur
     * @throws UnsupportedEncodingException if the file encoding is not supported
     */
    public void saveStringToFile(String theString, String fileName)
        throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter dest = new PrintWriter(new File(fileName), encoding);
        // TODO
        dest.println(theString);
        dest.close();

    }
}