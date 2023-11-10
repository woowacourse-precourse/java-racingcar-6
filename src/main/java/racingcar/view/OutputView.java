package racingcar.view;

import static racingcar.view.OutputMessage.*;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    public static void printPlayResult() {
        System.out.println(PLAY_RESULT.getOutputMessage());
    }

    public static void printRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList) {
        String finalResult = makeFinalWinnerOutputStatement(winnerList);
        System.out.print(finalResult);
    }

    public static String makeFinalWinnerOutputStatement(List<String> winnerList) {
        StringBuilder result = new StringBuilder();

        result.append(FINAL_RESULT.getOutputMessage());

        String winners = String.join(",", winnerList);

        result.append(winners);

        return result.toString();
    }
}
