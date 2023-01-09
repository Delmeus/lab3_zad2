import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class Letter {

    private final char letter;
    private final LinkedList<Name> namesList;

    public Letter(String title1, String title2, String title3, char letter){

        this.letter = letter;
        namesList = new LinkedList<>();

        try{
            try{
                File file1 = new File(title1);
                File file2 = new File(title2);
                File file3 = new File(title3);
                Scanner scanner = new Scanner(file1);
                scanner = new Scanner(file2);
                scanner = new Scanner(file3);
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }

            File file1 = new File(title1);
            File file2 = new File(title2);
            File file3 = new File(title3);
            String currentName;

            Scanner scanner = new Scanner(file1);
            while(scanner.hasNextLine()){
                currentName = scanner.nextLine();
                if(currentName.charAt(0) == letter){
                    namesList.add(new Name(title1, title2, title3, currentName));
                }
            }

            scanner = new Scanner(file2);
            while(scanner.hasNextLine()){
                currentName = scanner.nextLine();
                if(currentName.charAt(0) == letter){
                    namesList.add(new Name(title1, title2, title3, currentName));
                }
            }

            scanner = new Scanner(file3);
            while(scanner.hasNextLine()){
                currentName = scanner.nextLine();
                if(currentName.charAt(0) == letter){
                    namesList.add(new Name(title1, title2, title3, currentName));
                }
            }
            scanner.close();
            sortList();
        }catch (Exception ignored){

        }
    }

    public int searchForName(String name){
        for(int i = 0 ; i < namesList.size(); i++){
            if(namesList.get(i).getName().matches(name)){
                return i;
            }
        }
        return -1;
    }
    public LinkedList<Name> getNamesList() {
        return namesList;
    }

    private void sortList(){
        Name name = new Name(" ");
        for(int i = 0; i < namesList.size(); i++){
            for(int k = 0; k < namesList.size() - 1; k++){
                if(namesList.get(k).getName().compareTo(namesList.get(k+1).getName()) > 0){
                    name.change(namesList.get(k));
                    namesList.get(k).change(namesList.get(k+1));
                    namesList.get(k+1).change(name);
                }
            }
        }
    }
}
