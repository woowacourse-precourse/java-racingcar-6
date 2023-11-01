package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

import static racingcar.message.InformationMessage.*;

public class OutputView {
    public static void ResultGame(ArrayList<Car> cars, int number) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        for (int j=0; j<number; j++) {
            for(Car car : cars){
                car.PlusScore();
                car.PrintPosition();
            }
            System.out.println();
        }
        int maxScore = 0;
        for(Car car : cars) {
            maxScore = Math.max(maxScore, car.getPosition());
        }
        boolean oneWinner = true;
        System.out.print(WINNER_MESSAGE);
        for(Car car : cars){
            if(car.getPosition() == maxScore){
                if (!oneWinner) {
                    System.out.print(", " + car.getName());
                }
                if (oneWinner) {
                    System.out.print(car.getName());
                }
                oneWinner = false;
            }
        }

    }
}
