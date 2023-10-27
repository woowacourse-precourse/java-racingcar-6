package racingcar.controlller;

import static racingcar.constant.RacingGameConstants.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.RacingGameConstants.MIN_CAR_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private static void validateCarNames(String carNames) {
        validateCarNameLength(carNames);
        validateDuplicateName(carNames);
    }

    private static void validateCarNameLength(String carNames) {
        parseWithComma(carNames).forEach(carName ->
        {
            if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(
                        "이름은 " + MIN_CAR_NAME_LENGTH + "자 이상 " + MAX_CAR_NAME_LENGTH + "자 이하여야 합니다.");
            }
        });
    }

    private static void validateDuplicateName(String carNames) {
        List<String> carNameList = parseWithComma(carNames);
        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static CarList createCarList(String userInput) {
        List<Car> carList = new ArrayList<>();
        parseWithComma(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new CarList(carList);
    }

    private static List<String> parseWithComma(String userInput) {
        return Arrays.stream(userInput.split(","))
                .toList();
    }

    // 시도할 회수 입력 및 검증
    public static Integer scanNumberOfRounds() {
        InputView.printEnterNumberOfRounds();
        String userInput = Console.readLine();
        validateNumberOfRounds(userInput);

        return createNumberOfRounds(userInput);
    }

    private static void validateNumberOfRounds(String userInput) {
        validatePositiveInteger(userInput);
    }

    private static void validatePositiveInteger(String userInput) {
        if (!userInput.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException("양수를 입력하지 않았습니다.");
        }
    }

    private static Integer createNumberOfRounds(String userInput) {
        return Integer.parseInt(userInput);
    }
}
