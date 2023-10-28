package racingcar.view;

import java.util.List;

public interface View {
    String getPlayerInfo();
    String getGameRound();
    void printRoundProgress(String name, int win_count);
    void printWinner(List<String> list);
}
