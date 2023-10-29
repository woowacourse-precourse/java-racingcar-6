package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Game {

    private List<Car> cars;
    private int round;

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(Console.readLine().split(","));
    }

    private int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void input() {
        createCars(inputCarNames());
        this.round = inputRound();
    }

    public void run() {
        input();
    }
}
