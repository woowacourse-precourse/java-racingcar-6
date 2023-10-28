package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static racingcar.Constants.MAX_RANDOM_NUM;
import static racingcar.Constants.MIN_RANDOM_NUM;

public class Util {

    public static ArrayList<String> carNamesToArrayList(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(Constants.DELIMETER)));
    }

    public static int getRandomNum(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public static int getMax(ArrayList<Integer> positions){
        return Collections.max(positions);
    }

    public static void printResult() {
        System.out.println(Constants.WINNER_MESSAGE);

    }

}
