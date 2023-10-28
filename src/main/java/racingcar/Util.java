package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static racingcar.Constants.*;

public class Util {

    public static ArrayList<String> carNamesToArrayList(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(Constants.DELIMETER)));
    }

    public static int getRandomNum(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public static String carNamesInput(){
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String tryCntInput() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static int getMax(ArrayList<Integer> positions){
        return Collections.max(positions);

    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.print(Constants.WINNER_MESSAGE);
        System.out.println(String.join(DELIMETER, winners));
    }

}
