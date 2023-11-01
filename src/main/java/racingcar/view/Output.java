package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.constants.StringStore.*;

public class Output {
    public void printResultByIteration(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getLocationSymbol());
        }
        System.out.println();
    }
    public void printWinner(List<Car> winnerList) {
        System.out.print(FINAL_WINNER);
        int numOfWinner = winnerList.size();
        for (int index = 0; index < numOfWinner; index++) {
            Car car = winnerList.get(index);
            System.out.print(" " + car.getName());
            if (index + 1 != numOfWinner)
                System.out.print(",");
        }
        System.out.println();
    }
    public void printStart() {
        System.out.println();
        System.out.println(RESULT);
    }

}
