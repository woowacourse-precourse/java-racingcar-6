package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private MessageMaker messageMaker;
    private List messageParams;
    private String returnMessage;

    public Referee() {
        this.messageMaker = new MessageMaker();
        this.messageParams = new ArrayList<>();
        this.returnMessage = new String();
    }

    public String announceWinner(Game game) {
        messageParams.clear();
        returnMessage = "";
        int maxRace = 0;
        for (int i = 0; i < game.players.length; i++) {
            if (maxRace < game.players[i].location) {
                maxRace = game.players[i].location;
            }
        }
        for (int i = 0; i < game.players.length; i++) {
            if (maxRace == game.players[i].location) {
                messageParams.add(game.players[i].name);
            }
        }

        returnMessage = messageMaker.winnerMessage(messageParams);
        return returnMessage;
    }

    public String reportNow(Game game) {
        returnMessage = "";
        for (int i = 0; i < game.players.length; i++) {
            returnMessage += messageMaker.playerLocationMessage(game.players[i].name, game.players[i].location);
        }
        return returnMessage;
    }
}
