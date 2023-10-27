package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] inputCarList(){
        String input = Console.readLine();
        String[] result = input.split(",");
        return result;
    }

}
