package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static racingcar.NumberConst.*;
import static racingcar.InputValue.*;

public class Carracing {
    public static void startRacing() {

        InputSettingValue();

        //inputNumberOfCars
        //movingCount
        //carNameList
    }

    public static void goStop(String[] carNameList) {

        Map<String, String> raceScore = new HashMap<>();

        for(int i=0; i<carNameList.length; i++){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, FINAL_INCLUSIVE_NUMBER);

            if (randomNumber >= STANDARD_MOVING_NUMBER) {
                raceScore.put(carNameList[i], raceScore.getOrDefault(carNameList[i], "") + "-");
            }
        }
    }
}
