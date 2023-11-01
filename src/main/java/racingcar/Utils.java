package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.Constants.*;

public class Utils {

    public static ArrayList<String> carNamesToArrayList(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(DELIMITER)));
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

    // 최종 우승자 가리기
    public static int getMax(ArrayList<Integer> positions){
        return Collections.max(positions);
    }

    // 라운드별 결과값 출력
    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    // 최종 우승자 문구 출력
    public static void printWinner(ArrayList<String> winners) {
        System.out.print(WINNER_MESSAGE + ROUND_RESULT_DELIMETER);
        String result = winners.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }

    // 점수 출력
    public static String printScore(int score) {
        StringBuilder scores = new StringBuilder();
        IntStream.range(0, score).forEach(i -> scores.append(SCORE));
        return scores.toString();
    }

}
