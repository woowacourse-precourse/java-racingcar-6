package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarName() {
        return Console.readLine();
    }

    public static int inputAttemptsCount(){
        return Integer.parseInt(Console.readLine());
    }
}
