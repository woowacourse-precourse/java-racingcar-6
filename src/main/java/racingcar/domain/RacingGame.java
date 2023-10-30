package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        validateInputName(inputName);

        String[] inputArray = inputName.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : inputArray) {
            carList.add(generateCar(name));
        }
    }

    private static void validateInputName(String input) {
        input = input.trim();
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        String[] nameArray = input.split(",");
        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하로 만들어야 합니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
            }
        }
        List<String> nameList = Arrays.asList(nameArray);
        if (nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차의 이름은 중복된 값이 있을 수 없습니다.");
        }
    }

    private static Car generateCar(String name) {
        return new Car(name);
    }
}
