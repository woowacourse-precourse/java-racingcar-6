package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputFormView;
import racingcar.view.PlayResultView;
import racingcar.view.WinnersView;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        InputFormView.viewCarInputForm();
        user.readCarInput();

        InputFormView.viewTryNumInputForm();
        user.readTryNumInput();

        RacingCarGame racingCarGame = new RacingCarGame(user.getCarNames(), user.getTryNum());
        PlayResultView playResultView = new PlayResultView(racingCarGame.play());
        WinnersView winnersView = new WinnersView(racingCarGame.finish());

        playResultView.view();
        winnersView.view();
    }
}
