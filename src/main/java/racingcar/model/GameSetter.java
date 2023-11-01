package racingcar.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSetter {

    /**
     * 1. 사용자 입력 받기
     * 2. 이동 횟수 설정
     * 3. 실제 게임 진행
     */
    public List<Car> inputCarName() {
        String input = Console.readLine();
        List<Car> carList = splitInputToList(input);
        isValidCarNameInput(carList);

        return carList;
    }

    private List<Car> splitInputToList(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void isValidCarNameInput(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > 5)
                throw new IllegalArgumentException("Invalid Car Name.");
        }
    }

    public int inputNumberOfAccount() {
        String numberOfAccount = Console.readLine();
        isValidNumberOfAccountInput(numberOfAccount);

        return Integer.parseInt(numberOfAccount);
    }

    private void isValidNumberOfAccountInput(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException("Invalid Input");
        }
    }

}
