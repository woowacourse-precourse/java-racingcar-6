package racingcar;

import racingcar.InputView;
import racingcar.OutputView;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.getCarName();
        int rounds = inputView.getTryNumber();
        PlayingGame game = new PlayingGame(names);
        System.out.println("\n실행 결과");

        for (int i = 0; i < rounds; i++) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }
        OutputView.printWinner(game.getCars());
    }
}