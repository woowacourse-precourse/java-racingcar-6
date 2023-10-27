package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    public static List<Car> inputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = extractCarNames(Console.readLine());

        List<Car> carList = carNames.stream()
                .map(element -> new Car(element))
                .collect(Collectors.toList());

        return carList;
    }

    private static List<String> extractCarNames(String userInput) {
        List<String> nameList = Arrays.asList(userInput.split(","));

        nameList.stream().forEach(element -> {
            if (element.length() > 5 || element.length() <= 0) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
            }
        });

        return nameList;
    }
}
