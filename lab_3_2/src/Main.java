import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils(args[0], args[1], args[2]);

        findOccurrences(utils, NamesToFind.JACK.name());
        findOccurrences(utils, NamesToFind.BOB.name());
        findOccurrences(utils, NamesToFind.AMBER.name());
        findOccurrences(utils, NamesToFind.KYLIE.name());

        System.out.println("On what letter do you want the names to start?\n");
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        if ((int)letter > 96 && (int)letter < 123) letter = (char) ((int)letter - 32);

        try{
            for (int i = 0; i < utils.getAlphabet().get((int)letter - 65).getNamesList().size(); i++) {
                System.out.println(utils.getAlphabet().get((int)letter - 65).getNamesList().get(i).getName());
            }
            if(utils.getAlphabet().get((int)letter - 65).getNamesList().isEmpty()) System.out.println("No names found starting on such letter");
        }catch (Exception e){
            System.out.println("Wrong parameters");
        }

    }

     private static void findOccurrences(Utils utils, String name){
        int index = (int)(name.charAt(0)) - 65;
        int[] occurrences;

        if(utils.getAlphabet().get(index).searchForName(name) != -1) {
            occurrences = utils.getAlphabet().get(index).getNamesList().get(utils.getAlphabet().get(index)
                    .searchForName(name)).getOccurrenceNumber();

            System.out.println(name + " finds:" +
                    "\nFile 1: " + occurrences[0] +
                    "\nFile 2: " + occurrences[1] +
                    "\nFile 3: " + occurrences[2]);
        }
        else System.out.println("No such name in any of the files");
    }

}