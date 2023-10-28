package racingcar.view;

import racingcar.model.Player;

import java.util.List;

public interface View {
    String getPlayerInfo();
    String getGameRound();
    void printRoundProgress(List<Player> playerList);
    void printWinner(List<String> list);
}
