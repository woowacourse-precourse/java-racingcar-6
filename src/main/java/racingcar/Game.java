package racingcar;

import player.Player;
import user.User;
import utils.Factory;
import utils.MapUtils;

import java.util.*;

final class Game {
    List<Player> players;

    public Game() {
    }

    public void start() {
        Output.printGameStartMessage();

        List<String> playersName = User.inputPlayerName();
        Output.printPlayersName(playersName);

        players = Factory.createPlayersArray(playersName);

        assignNewCarToEachPlayer();
    }

    public void play() {
        Output.printTryCountMessage();
        String tryNumber = User.inputTryNumber();
        Output.printTryCount(tryNumber);

        playRounds(Integer.parseInt(tryNumber));
    }

    public void end() {
        List<String> winners = findFinalWinner();
        Output.printFinalWinner(winners);
    }

    private void assignNewCarToEachPlayer() {
        for (Player player : players) {
            player.selectNewCar();
        }
    }

    private void playRounds(int tryNumber) {
        for (int round = 1; round <= tryNumber; round++) {
            playRound();
            Output.printPlayersStatus(players);
        }
    }

    private void playRound() {
        for (Player player : players) {
            player.play();
        }
    }

    private List<String> findFinalWinner() {
        Map<String, Integer> playerDistanceMap = Factory.createPlayerDistanceMap(players);
        int maxDistance = MapUtils.getMaxValue(playerDistanceMap);
        List<String> winnersName = MapUtils.getKeysForValue(playerDistanceMap, maxDistance);
        return winnersName;
    }
}
