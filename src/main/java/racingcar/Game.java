package racingcar;

import player.Player;
import user.User;
import utils.JoinComma;
import utils.Create;

import java.util.*;

public class Game {
    List<String> players;

    public Game() {
        this.players = User.playerInput();
    }

    public void play() {
        System.out.println(GameMessage.GAME_START.message);
        System.out.println(JoinComma.playerInput(this.players));
        System.out.println(GameMessage.TRY_COUNT.message);
        String moveNumber = User.moveNumberInput();
        System.out.println(moveNumber + "\n");

        List<Player> playerObjectArray = Create.playerObjectArray(this.players);

        playRounds(playerObjectArray, Integer.parseInt(moveNumber));

        Map<String, Integer> playerDistanceMap = Create.playerDistanceMapping(playerObjectArray);

        int maxDist = Collections.max(playerDistanceMap.values());
        System.out.print(GameMessage.FINAL_WINNER.message);
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : playerDistanceMap.entrySet()) {
            if (entry.getValue() == maxDist) {
                winners.add(entry.getKey());
            }
        }
        System.out.print(JoinComma.winnerOutput(winners));
    }

    private void playRounds(List<Player> playerObjects, int moveNumber) {
        for (int move = 0; move < moveNumber; move++) {
            raceCars(playerObjects);
        }
    }

    private void raceCars(List<Player> playerObjects) {
        for (Player car : playerObjects) {
            car.move(Create.randomNumber());
            System.out.println(car.getPlayerName() + " : " + "-".repeat(car.getDist()));
        }
        System.out.println();
    }
}
