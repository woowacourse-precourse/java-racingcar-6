package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] inputCarNames() {
        String cars = Console.readLine();
        return cars.split(",");
    }

    public static int inputGameCount() {
        return Integer.parseInt(Console.readLine());
    }
}
