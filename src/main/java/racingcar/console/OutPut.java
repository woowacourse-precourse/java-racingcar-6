package racingcar.console;

import static racingcar.Execute.carRace;
import static racingcar.racingGame.Racing.getPosition;
import static racingcar.racingGame.Racing.getWinner;

public class OutPut {
    public static void printWinner(){
        System.out.println("최종 우승자 : " + getWinner());
    }
    public static void printCarMap(){
        for (String carName : carRace.keySet()) {
            Long position = carRace.get(carName);
            String carPosition = getPosition(position);
            System.out.printf(carName + " : " + carPosition + "\n");
        }
    }
}
