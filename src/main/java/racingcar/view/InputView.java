package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.validation.InputValidation;

public class InputView {

    public static void inputCars(List<Car> carList) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String str = Console.readLine();

        String[] split = str.split(",", -1);
        InputValidation.validateCarsName(split);

        for (String name : split) {
            carList.add(new Car(name));
        }
    }

    public static int inputTimes() {

        System.out.println("시도할 회수는 몇회인가요?");

        String timesStr = Console.readLine();
        InputValidation.validateTimes(timesStr);

        return Integer.parseInt(timesStr);
    }
}
