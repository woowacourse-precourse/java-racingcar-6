package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Car> inputCarsInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getCarNames();
    }

    public static List<Car> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            Validator.validateCarName(carName);
        }
        Validator.validateDuplicate(carNames);

        return TypeConverter.convertStringArrayToCarList(carNames);
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getRound();
    }

    public static int getRound() {
        String input = Console.readLine();
        return Validator.validateRound(input);
    }
}
