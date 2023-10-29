package racingcar;

import player.Player;
import utils.StringUtils;

import java.util.*;

final class Output {
    private Output() {
    }

    static void printGameStartMessage() {
        System.out.println(GameMessage.GAME_START.message);
    }

    static void printPlayersName(List<String> players) {
        System.out.println(StringUtils.joinWithoutBlank(players));
    }

    static void printTryCountMessage() {
        System.out.println(GameMessage.TRY_COUNT.message);
    }

    static void printTryCount(String moveNumber) {
        System.out.println(moveNumber + "\n");
    }

    static void printPlayerStatus(String playerName, int distance) {
        System.out.println(playerName + " : " + "-".repeat(distance));
    }

    static void printPlayersStatus(List<Player> players) {
        for (Player player : players) {
            Output.printPlayerStatus(player.getPlayerName(), player.getDistance());
        }
        System.out.println();
    }

    static void printFinalWinner(List<String> winners) {
        System.out.print(GameMessage.FINAL_WINNER.message);
        System.out.println(StringUtils.joinWithBlank(winners));
    }
}
