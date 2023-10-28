package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

class raceDecisionMaker {
    boolean raceDecision() {
        int randomNumber = pickNumber();
        return randomNumber >= 4;
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

class Car {
    String name;
    int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }
}

class Game {
    List<Car> cars;
    List<String> carNames;
    int carCount;

    Game(String input) {
        String[] tokens = input.split(",");
        carNames = Arrays.asList(tokens);
        carCount = this.carNames.length;
        initCar();
    }

    void initCar() {
        cars = new ArrayList<Car>();
        for (int i = 0; i < carCount; ++i) {
            // 입력받은 이름을 기반으로 차례대로 차량 생성
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
