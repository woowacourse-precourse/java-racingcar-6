package view;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String[] splitNames(String namesWithComma){
        checingNullOrBlankException(namesWithComma);

        String[] names = namesWithComma.split(",");
        checkingException(names);

        return names;
    }

    private static void checingNullOrBlankException(String namesWithComma) {
        if(namesWithComma == null || namesWithComma == " ")
            throw new IllegalArgumentException();
    }

    private static void checkingException(String[] names) {
        Map<String,Integer> checkingNames = new HashMap<>();

        for(String s : names){
            if(checkingNames.containsKey(s))
                throw new IllegalArgumentException();
            if(s.length() > 5)
                throw new IllegalArgumentException();
            if(s.matches(".*[1-9].*"))
                throw new IllegalArgumentException();

            checkingNames.put(s,0);
        }
    }

    public static String getInput(){
        return readLine();
    }
}
