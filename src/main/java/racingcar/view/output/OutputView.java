package racingcar.view.output;

import racingcar.contant.GameNotice;
import racingcar.model.RacingCar;
import utils.Console;

import java.util.List;

import static racingcar.contant.GameNotice.NOTICE_WINNER_RESULT;

public class OutputView {
    public OutputView() {}
    public static void printGameNotice(GameNotice notice) {
        Console.print(notice.getMessage());
    }

    public void printMovedCar(RacingCar racingCar) {
        String moved = "";
        for(int i = 0; i < racingCar.getCarMoveCount(); i++) {
            moved = moved.concat("-");
        }

        Console.println(racingCar.name + " : " + moved);
    }

    public void printWinner(List<String> winnerList) {
        printGameNotice(NOTICE_WINNER_RESULT);
        Console.print(String.join(", ", winnerList));
    }
}
