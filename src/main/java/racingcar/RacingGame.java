package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        validateCarNames(carNames); // 예외 처리: 중복 확인

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static void validateCarNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + name);
            }
        }
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public void startGame() {
        List<Car> cars = createCars();
        int attempt = getAttempts();
    }

}
