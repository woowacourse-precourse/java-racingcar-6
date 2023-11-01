package racingcar.view;

import racingcar.validator.CarNameInputValidator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int carsNum;
    public static String[] cars;

    public static String[] inputCarNames() {
        String carsInput = Console.readLine();
        CarNameInputValidator validator = new CarNameInputValidator();
        validator.validate(carsInput);

        cars = carsInput.split(",");

        carsNum = cars.length;

        return cars;
    }

    public static int inputGameCount() {
        return Integer.parseInt(Console.readLine());
    }
}
