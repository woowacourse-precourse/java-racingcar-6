package view;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_NUMBEROFTRY_MESSAGE = "시도할 회수는 몇회인가요?";
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
