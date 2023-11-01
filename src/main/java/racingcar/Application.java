package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int numAttempts = getNumAttempts();
    }

    private static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
    private static int getNumAttempts() {
        while (true) {
            System.out.println("시도 할 횟수를 입력하세요.");
            String input = Console.readLine();
            int numAttempts = parseNumAttempts(input);
            if (numAttempts > 0) {
                return numAttempts;
            }
        }
    }
    private static int parseNumAttempts(String input) {
        try {
            int numAttempts = Integer.parseInt(input);
            if (numAttempts <= 0) {
                System.out.println("시도 횟수는 1 이상이어야 합니다.");
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return numAttempts;
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
        }
        return 0;
    }
}

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
}
