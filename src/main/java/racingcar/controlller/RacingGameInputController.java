package racingcar.controlller;

import static racingcar.constant.RacingGameConstants.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.RacingGameConstants.MIN_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;

// 프론트 엔드 역할을 할 컨트롤러
public class RacingGameInputController {
    // 자동차 이름 입력 및 검증
    public static CarList scanCarList() {
        InputView.printEnterCarNames();
        String userInput = Console.readLine();
        validateCarList(userInput);

        return createCarList(userInput);
    }

    private static void validateCarList(String userInput) {
        validateCarNames(userInput);
    }

    private static void validateCarNames(String userInput) {
        List<String> carNames = Arrays.stream(userInput.split(","))
                .toList();
        carNames.forEach(RacingGameInputController::validateCarNameLength);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 " + MIN_CAR_NAME_LENGTH + "자 이상 " + MAX_CAR_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    private static CarList createCarList(String userInput) {
        List<Car> carList = new ArrayList<>();
        parseStringToCarNameList(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new CarList(carList);
    }

    private static List<String> parseStringToCarNameList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .collect(Collectors.toList());
    }

    // 시도할 회수 입력 및 검증
    public static Integer scanNumberOfRounds() {
        InputView.printEnterNumberOfRounds();
        String userInput = Console.readLine();
        validateNumberOfRounds(userInput);

        return createNumberOfRounds(userInput);
    }

    private static void validateNumberOfRounds(String userInput) {
        validateNoneNegativeInteger(userInput);
    }

    private static void validateNoneNegativeInteger(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("음이 아닌 수를 입력하지 않았습니다.");
        }
    }

    private static Integer createNumberOfRounds(String userInput) {
        return Integer.parseInt(userInput);
    }
}
