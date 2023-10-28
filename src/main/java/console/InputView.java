package console;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NON_NUMERIC_INPUT = "숫자만 입력할 수 있다.";

    private InputView() { // util class
        throw new IllegalArgumentException();
    }
    public static String getInput(){
        return Console.readLine();
    }

    public static int getNumericInput(){
        String userInput = Console.readLine().trim(); // trim 해서 공백 제거
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT);
        }
    }
}
