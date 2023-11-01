package racingcar.view;

import racingcar.model.Game;

public interface GameView {
    void showInputRequiredMessage();

    void showProgressOf(Game game);

    void showResultOf(Game game);
}
