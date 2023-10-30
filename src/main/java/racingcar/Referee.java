package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public String announceWinner(Game game) {
        List<String> winners = new ArrayList<>();
        int maxRace = 0;
        for (int i = 0; i < game.players.length; i++) {
            if (maxRace < game.players[i].location) {
                maxRace = game.players[i].location;
            }
        }
        for (int i = 0; i < game.players.length; i++) {
            if (maxRace == game.players[i].location) {
                winners.add(game.players[i].name);
            }
        }
        String messageJoin = String.join(", ", winners);
        String message = "최종 우승자 : " + messageJoin;
        return String.valueOf(message);
    }

    public String reportNow(Game game) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < game.players.length; i++) {
            message.append(playerLocationMessage(game, game.players[i].name) + "\n");
        }
        return String.valueOf(message);
    }

    private String playerLocationMessage(Game game, String name) {
        StringBuilder message = new StringBuilder();
        String nowPlayerName = name;
        int nowPlayerLocation = 0;
        for (int i = 0; i < game.players.length; i++) {
            if (game.players[i].name == name) {
                nowPlayerLocation = game.players[i].location;
            }
        }
        message.append(nowPlayerName);
        message.append(" : ");
        for (int i = 0; i <= nowPlayerLocation; i++) {
            message.append("-");
        }
        return String.valueOf(message);
    }
}
