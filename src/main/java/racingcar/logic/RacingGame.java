package racingcar.logic;

import racingcar.controller.PlayerController;
import racingcar.model.Vehicle;
import racingcar.util.GameUtil;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame implements Game {
    private final PlayerController controller;
    private final View view;
    private List<Vehicle> playerList;
    private int maxRound;
    private final int movePoint = 4;

    public RacingGame(PlayerController controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public void init() {
        this.playerList = initPlayerInfo();
        this.maxRound = initRoundInfo();
    }

    @Override
    public void start() {
        while (true) {
            run();
        }
    }

    @Override
    public void run() {
        init();
        for (int round = 0; round < maxRound; round++) {
            movePlayers();
            view.printRoundProgress(playerList);
        }
        view.printWinner(getWinners());
        controller.clearPlayer();
    }

    private List getWinners() {
        ArrayList winnerList = new ArrayList();
        int maxScore = 0;
        for (int i = 0; i < playerList.size(); i++) {
            Vehicle player = playerList.get(i);
            if (maxScore == player.getScore()) {
                winnerList.add(player.getName());
            } else if (maxScore < player.getScore()) {
                maxScore = player.getScore();
                winnerList.clear();
                winnerList.add(player.getName());
            }
        }
        return winnerList;
    }

    private List initPlayerInfo() {
        String playerInfo = view.getPlayerInfo();
        String[] players = playerInfo.split(",");

        GameUtil.isIllegalPlayerInfo(players);
        return controller.addAllPlayer(Arrays.asList(players));
    }

    private int initRoundInfo() {
        String roundCount = view.getRoundInfo();

        GameUtil.isIllegalRoundInfo(roundCount);
        return Integer.parseInt(roundCount);
    }

    private void movePlayers() {
        for (Vehicle player : playerList) {
            player.tryMove(movePoint);
        }
    }
}


