package racingcar.controller;

import java.util.List;

public interface IOController {
    void showIntroMessage();

    List<String> getCarNames();

    void showWinner(List<String> winnerName);

    void showRequestRoundNumberMessage();

    Integer getRoundNumber();

    void showRoundResult(List<String> singleRoundResult);
}
