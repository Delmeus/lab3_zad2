import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Name {
    private String name;
    private int[] occurrenceNumber;

    public Name(String name){
        this.name = name;
    }

    public Name(String title1, String title2, String title3, String name){
        this.name = name;
        occurrenceNumber = calculateOccurrences(title1, title2, title3, name);
    }

    public int[] getOccurrenceNumber() {
        return occurrenceNumber;
    }

    private int[] calculateOccurrences(String title1, String title2, String title3, String name){
        int[] x = new int[3];
        try {
            File file1 = new File(title1);
            File file2 = new File(title2);
            File file3 = new File(title3);
            Scanner scanner = new Scanner(file1);

            while (scanner.hasNextLine()) {
                if (scanner.nextLine().matches(name)) {
                    x[0]++;
                }
            }

            scanner = new Scanner(file2);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().matches(name)) {
                    x[1]++;
                }
            }

            scanner = new Scanner(file3);
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().matches(name)) {
                    x[2]++;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("At least one of the files wasn't found");
            System.out.println(e.getMessage());
        }
        return x;
    }

    public String getName() {
        return name;
    }


    public void change(Name name){
        this.name = name.getName();
        this.occurrenceNumber = name.getOccurrenceNumber();
    }
}
