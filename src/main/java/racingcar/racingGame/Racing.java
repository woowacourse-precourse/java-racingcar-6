package racingcar.racingGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Execute.carRace;
import static racingcar.Execute.raceTime;
import static racingcar.console.OutPut.printCarMap;
import static racingcar.util.Checker.isStraight;
import static racingcar.util.Utils.getStringFormat;

public class Racing {

    public static void playGame(){
        for(int i = 0; i < raceTime; i++){
            moveCar();
            printCarMap();
        }
    }
    public static String getPosition(Long position){
        StringBuilder carPosition = new StringBuilder();
        for(int i = 0; i < position; i++){
            carPosition.append("-");
        }
        return carPosition.toString();
    }

    public static void moveCar(){
        for (String carName : carRace.keySet()) {
            Long carPosition = carRace.get(carName);

            if(isStraight()){
                carRace.replace(carName, ++carPosition);
            }
        }
    }

    public static String getWinner(){
        List<String> winners = new ArrayList<>();
        Long maxPosition = Collections.max(carRace.values());

        for( String carName : carRace.keySet()){
            Long carPosition = carRace.get(carName);

            if(carPosition.equals(maxPosition)){
                winners.add(carName);
            }
        }

        return getStringFormat(winners);
    }

}
