package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameCalculator {

    public List<Car> calculateEachResult(List<Car> carList){

        for(Car car: carList) {
            int pickNumber = Randoms.pickNumberInRange(0,9);
            if(pickNumber >= 4) {
                car.setGameResult();
            }
        }
        return carList;
    }

    public String calculateFinalResult(List<Car> carList){

        List<String> winners = new ArrayList<>();
        int maxGameResult = 0;

        for(Car car: carList) {
            if(car.getGameResult() > maxGameResult) {
                maxGameResult = car.getGameResult();
            }
        }

        for(Car car: carList) {
            if(car.getGameResult() == maxGameResult) {
                winners.add(car.getCarName());
            }
        }

        String result = String.join(", ", winners);
        return result;
    }
}
