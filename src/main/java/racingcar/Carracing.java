package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

import static racingcar.NumberConst.*;
import static racingcar.InputValue.*;
import static racingcar.PrintUtil.*;

public class Carracing {

    public static Map<String, String> raceScore;
    public static void startRacing() {

        InputSettingValue();

        //inputNumberOfCars
        //movingCount
        //carNameList
    }

    public static void goStop(Map<String, String> raceScore) {

        for(int i=0; i<carNameList.length; i++){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, FINAL_INCLUSIVE_NUMBER);

            if (randomNumber >= STANDARD_MOVING_NUMBER) {
                raceScore.put(carNameList[i], raceScore.get(carNameList[i]) + "-");
            }
        }
        printGameResultMsg(raceScore);
    }

    public static Map<String, String> setInitStartPoint(String[] carNameList) {

        raceScore = new LinkedHashMap<>();

        for(int i=0; i<carNameList.length; i++) {
            raceScore.put(carNameList[i], "");
        }

        return raceScore;
    }
}
