package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarList;

// 프론트 엔드 역할을 할 컨트롤러
public class RacingGameInputController {
    // 자동차 이름 입력 및 검증
    public static CarList scanCarList() {
        String userInput = Console.readLine();
        validateCarList(userInput);

        return createCarList(userInput);
    }

    private static void validateCarList(String userInput) {
        validateNames(userInput);
    }

    private static void validateNames(String userInput) {
        List<String> carNames = Arrays.stream(userInput.split(","))
                .collect(Collectors.toList());
        if (carNames.stream().filter(car -> car.length() > 5).count() != carNames.size()) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
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
        String userInput = Console.readLine();
        validateNumberOfRounds(userInput);

        return createNumberOfRounds(userInput);
    }

    private static void validateNumberOfRounds(String userInput) {
        validateInteger(userInput);
        validatePositiveInteger(userInput);
    }

    private static void validateInteger(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }
    }

    private static void validatePositiveInteger(String userInput) {
        if (Integer.parseInt(userInput) < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다.");
        }
    }

    private static Integer createNumberOfRounds(String userInput) {
        return Integer.parseInt(userInput);
    }
}
