package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Input;
import racingcar.domain.Race;

public class Application {
    public static Race ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Input.readCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = Input.readMoveCount();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return new Race(cars, moveCount);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = ready();
        race.start();
        race.evaluate();
    }
}