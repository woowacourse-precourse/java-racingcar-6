package racingcar.view;

import racingcar.Car;

import java.util.ArrayList;

public class OutputView {
    public static void ResultGame(ArrayList<Car> cars, int number) {
        System.out.println();
        System.out.println("실행 결과");

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
        System.out.print("최종 우승자 : ");
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
