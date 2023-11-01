package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.validator.InputValidator;

public class InputView {
    private final static String REQUEST_RACING_CAR_NICKNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String STRING_DELIMITER = ",";

    public static void inputCars(CarGroup carGroup) {
        System.out.println(REQUEST_RACING_CAR_NICKNAME_MESSAGE);
        String cars = readLine();
        for (String carName : cars.split(STRING_DELIMITER)) {
            Car car = new Car(carName);
            carGroup.addCar(car);
        }
    }

    public static int inputTryCount() {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);
        String input = readLine();
        new InputValidator().validateTryCount(input);
        return Integer.parseInt(input);
    }
}
