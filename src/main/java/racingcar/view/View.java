package racingcar.view;

import racingcar.model.Vehicle;

import java.util.List;

public interface View {
    String getPlayerInfo();

    String getRoundInfo();

    void printRoundProgress(List<Vehicle> playerList);

    void printWinner(List<String> list);
}
