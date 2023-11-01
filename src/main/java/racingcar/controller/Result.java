package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.FindWinner;
import racingcar.view.OutPutString;

public class Result {

    public Result(ArrayList<Car> classList, int count) {
        OutPutString.printResult(); // 실행결과

        printRound(classList, count); // 라운드출력

        FindWinner findWinner = new FindWinner(classList);
        OutPutString.printWinner(findWinner.getWinner());
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
            OutPutString.printStatus(car.getName(), car.getPosition());
        }
    }

}
