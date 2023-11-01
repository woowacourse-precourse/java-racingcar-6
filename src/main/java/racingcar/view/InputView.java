package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validator.InputValidate;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CAR_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<Car> registCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        List<Car> registedCar = new ArrayList<>();
        String carNames = Console.readLine();
        String[] carNameSplits = carNames.split(",");
        InputValidate.validateCarName(carNameSplits);
        for (String carName : carNameSplits) {
            registedCar.add(new Car(carName));
        }
        return registedCar;
    }

    public static int registCarMoveNum() {
        System.out.println(INPUT_CAR_ROUND_MESSAGE);
        String roundNumString = Console.readLine();
        InputValidate.validateCarMoveNum(roundNumString);
        int roundNum = Integer.parseInt(roundNumString);
        return roundNum;
    }
}
