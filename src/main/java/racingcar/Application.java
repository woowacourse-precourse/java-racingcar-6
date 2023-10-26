package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.GameManager.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] names = getNames();
        int moveCount = getMoveCount();

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, 0));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            move(cars);
        }

    }
}
