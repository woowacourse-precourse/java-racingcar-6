package racingcar.operator;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Player;

public class PlayerGenerator {
    public static List<Player> generatePlayerList(List<String> playerList) {
        List<Player> participantList = new ArrayList<>();
        for (String player : playerList) {
            participantList.add(new Player(player));
        }
        return participantList;
    }
}
