package View;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class InputView {
    private static final String inputCarName = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분";

    public static String printUserInputCarName(){
        System.out.println(inputCarName);
        String input = readLine();
        return input;
    }
}
