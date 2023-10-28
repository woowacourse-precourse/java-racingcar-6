package racingcar;

import java.util.ArrayList;
import java.util.List;

class Car {
    String name;
    int position;
    Car(String name) {
        this.name = name;
        position = 0;
    }
}

class Game {
    String[] carNames;
    int carCount;
    Game(String carName) {
        carsNames = carName.split(",");
        carCount = carsNames.length;
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
