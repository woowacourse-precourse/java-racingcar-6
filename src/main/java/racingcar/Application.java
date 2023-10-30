package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] names = GameManager.getNames();
        int moveCount = GameManager.getMoveCount();

        List<Car> cars = Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            GameManager.move(cars);
        }

        GameManager.getWinner(cars);
    }
}
