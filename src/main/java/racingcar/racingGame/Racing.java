package racingcar.racingGame;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static racingcar.Execute.*;
import static racingcar.console.OutPut.printCarMap;
import static racingcar.resource.Constant.HYPHEN;
import static racingcar.util.Checker.isStraight;
import static racingcar.util.Utils.getStringFormat;
public class Racing {
    public static void playGame(){
        for(int i = 0; i < raceTime; i++){
            moveCar();
            printCarMap();
        }
    }
    public static void moveCar(){
        for (Car car : carRace) {
            if(!isStraight())
                continue;

            car.incDistance();
            maxDistance = max(maxDistance, car.getDistance());
        }
    }
    public static String getWinner(){
        List<String> winners = new ArrayList<>();

        for(Car car : carRace){
            if(car.isSame(maxDistance)){
                String carName = car.getName();
                winners.add(carName);
            }
        }

        return getStringFormat(winners);
    }
    public static String getPosition(Long position){
        StringBuilder carPosition = new StringBuilder();
        for(int i = 0; i < position; i++){
            carPosition.append(HYPHEN);
        }
        return carPosition.toString();
    }
}
