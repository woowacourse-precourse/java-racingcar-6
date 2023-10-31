package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 생성
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        // 시도할 회수 입력 받기
        System.out.println("시도할 회수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        // 자동차 경주 게임 시작
        RacingGame racingGame = new RacingGame(carNames);
        racingGame.start(tryCount);
    }
}

class RacingGame {
    private final List<Car> cars;

    public RacingGame(String[] carNames) {
        validateCarNames(carNames);
        cars = createCars(carNames);
    }
    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            move();
        }
    }
    private void move() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.plus();
            }
        }
    }
    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }



}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
    public void plus(){
        this.position ++;
    }
}
