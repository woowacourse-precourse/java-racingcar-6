package racingcar.view;

import java.util.ArrayList;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.utils.RuleConstant;

public class OutputView {
    public static void printPlay() {
        System.out.println(RuleConstant.ROUND_RESULT);
    }

    public static void printRoundResult(ArrayList<Car> roundResults) {
        roundResults.forEach(car ->
                System.out.println(car.getName() + RuleConstant.ROUND_RESULT_DELIMITER + printDash(car.getPosition())));
        System.out.println();
    }

    public static String printDash(int num) {
        StringBuilder dashes = new StringBuilder();
        IntStream.range(0, num).forEach(i -> dashes.append("-"));
        return dashes.toString();
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.println(RuleConstant.WINNER_RESULT + String.join(RuleConstant.DELIMITER_WINNER, winners));
    }
}
