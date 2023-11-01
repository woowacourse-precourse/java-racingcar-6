package racingcar.console;

import racingcar.model.Car;

import static racingcar.Execute.carRace;
import static racingcar.racingGame.Racing.getPosition;
import static racingcar.racingGame.Racing.getWinner;
import static racingcar.resource.Constant.FINAL_WINNER;

public class OutPut {
    public static void printWinner(){
        System.out.println(FINAL_WINNER + getWinner());
    }
    public static void printCarMap(){
        for (Car car : carRace) {
            Long distance = car.getDistance();
            String carName = car.getName();
            String carPosition = getPosition(distance);
            System.out.printf(carName + " : " + carPosition + "\n");
        }

    }
}
