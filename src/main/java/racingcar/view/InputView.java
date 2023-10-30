package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Cars;
import racingcar.domain.car.carmove.CarMoveReader;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public Cars inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarName = Console.readLine();
        return Cars.makeCars(inputCarName);
    }

    public CarMoveReader inputTotalMoveNumber() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        String totalMoveNumber = Console.readLine();
        return CarMoveReader.makeCarMoveReader(totalMoveNumber);
    }
}
