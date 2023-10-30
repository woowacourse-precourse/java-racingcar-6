package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Print {

    void Score(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.name + " : " + "-".repeat(car.score));
        }
        System.out.println();
    }

    void Winner(List<Car> carList) {
        GameFunction gameFunction = new GameFunction();
        List<String> winnerName = gameFunction.getWinner(carList);
        String result = String.join(", ", winnerName);

        System.out.print("최종 우승자 : ");
        System.out.println(result);
    }




}
