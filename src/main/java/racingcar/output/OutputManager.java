package racingcar.output;

import racingcar.game.Racing;
import racingcar.game.Winner;

public class OutputManager {
    public static void printRacingStatus(Racing racing) {
        String racingResult = racing.toString();
        System.out.println(racingResult);
    }

    public static void printRacingResult(Winner winner) {
        String racingResult = "최종 우승자 : " + winner.toString();
        System.out.println(racingResult);
    }
}