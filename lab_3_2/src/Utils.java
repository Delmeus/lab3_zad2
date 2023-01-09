import java.util.ArrayList;

public class Utils {

    private ArrayList<Letter> alphabet;

    public Utils(String title1, String title2, String title3){
        alphabet = new ArrayList<>(26);
        for(int i = 0; i < 26; i++){
            alphabet.add(new Letter(title1, title2, title3, (char) (i + 65)));
        }
    }

    public ArrayList<Letter> getAlphabet() {
        return alphabet;
    }
}
