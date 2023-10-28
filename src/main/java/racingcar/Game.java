package racingcar;

import player.Player;
import user.User;
import utils.Create;

import java.util.*;

public class Game {
    List<String> players;

    public Game() {
        Output.printGameStartMessage();
        this.players = User.playerNameInput();
    }

    public void play() {
        Output.printPlayersName(this.players);

        Output.printTryCountMessage();
        String tryNumber = User.tryNumberInput();
        Output.printTryCount(tryNumber);

        List<Player> playerObjectArray = Create.playerObjectArray(this.players);

        playRounds(playerObjectArray, Integer.parseInt(tryNumber));

        Map<String, Integer> playerDistanceMap = Create.playerDistanceMapping(playerObjectArray);
        int maxDistance = getMaxDistance(playerDistanceMap);

        List<String> winners = findFindWinner(playerDistanceMap, maxDistance);

        Output.printFinalWinner(winners);
    }

    private void playRounds(List<Player> playerObjects, int tryNumber) {
        for (int round = 1; round <= tryNumber; round++) {
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

    private int getMaxDistance(Map<String, Integer> playerDistanceMap) {
        return Collections.max(playerDistanceMap.values());
    }

    private List<String> findFindWinner(Map<String, Integer> playerDistanceMap, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : playerDistanceMap.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }
}
