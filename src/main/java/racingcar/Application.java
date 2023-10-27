package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.View.InputView;

public class Application {
    public static void main(String[] args) {

        String[] nameInput = InputView.readCarNames();

        List<Car> carList = Arrays.stream(nameInput)
                .map(Car::new)
                .toList();

        Cars cars = new Cars(carList);

        int count = InputView.readTrialCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.calculateMoveCount();
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", cars.getWinner()));
    }
}


