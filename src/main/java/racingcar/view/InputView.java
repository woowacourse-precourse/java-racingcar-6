package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int carsNum;
    public static String[] cars;

    public static String[] inputCarNames() {
        cars = (Console.readLine()).split(",");
        carsNum = cars.length;
        return cars;
    }

    public static int inputGameCount() {
        return Integer.parseInt(Console.readLine());
    }
}
