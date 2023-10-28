package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<String> cars;
    private final int num;
    private Car[] car;

    public Game(List<String> cars, int num) {
        this.cars = cars;
        this.num = num;
    }

    // 차량 객체 이름 지정 및 이동 거리 0으로 초기화
    void initCar() {
        car = new Car[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            car[i] = new Car(cars.get(i), 0);
        }
    }

    void startGame() {
        initCar();
    }
}
