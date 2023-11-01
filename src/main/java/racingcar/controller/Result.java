package racingcar.controller;


import static racingcar.view.OutputString.printStatus;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.FindWinner;
import racingcar.view.OutputString;

public class Result {

    public Result(ArrayList<Car> classList, int count) {
        OutputString.printResult(); // 실행결과

        printRound(classList, count); // 라운드출력

        FindWinner findWinner = new FindWinner(classList);
        OutputString.printWinner(findWinner.getWinner());
    }

    private void printRound(ArrayList<Car> classList, int count) {
        for (int i = 0; i < count; i++) {
            round(classList);
            System.out.println();
        }
    }

    private void round(ArrayList<Car> classList) {
        for (Car car : classList) {
            car.moveOrStop();
            printStatus(car.getName(), car.getPosition());
        }
    }

}
