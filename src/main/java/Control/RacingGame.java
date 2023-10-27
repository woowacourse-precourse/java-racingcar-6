package Control;


import Model.Player;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Player> players;
    int n_players;
    int count;
    int maxDistance;

    public RacingGame() {
        this.players = new ArrayList<>();
        this.n_players = 0;
        this.count = 0;
        this.maxDistance = 0;
    }

    public void play() {
        String playersRawData = InputView.getPlayerNames();
        String[] playerNames = splitPlayerNames(playersRawData);
        String countRawData = InputView.getPlayCount();
        count = parseCountData(countRawData);

        for (int i = 0; i < playerNames.length; i++) {
            players.add(new Player(playerNames[i]));
        }

        OutputView.printExcuteResult();
        for (int i = 0; i < count; i++) {
            startRacing();
            OutputView.printLn();
        }

        OutputView.printWinner(getWinner());
    }

    public String getWinner() {
        String res = "";
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getDistance() == maxDistance) {
                res += players.get(i).getName() + ", ";
            }
        }
        return res.substring(0, res.length() - 2);
    }

    public void startRacing() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).goForwardOrNot();
            OutputView.printPlayerState(players.get(i).toString());
            renewMaxDistance(players.get(i));
        }
    }


    // 매 경주마다 플레이어의 최장 이동 거리를 maxDistance 변수에 갱신
    public void renewMaxDistance(Player p) {
        if (p.getDistance() > maxDistance) {
            maxDistance = p.getDistance();
        }
    }

    public String[] splitPlayerNames(String data) {
        String[] playerNames = data.split(",");
        for (int i = 0; i < playerNames.length; i++) {
            if (playerNames[i].length() > 5) {
                throw new IllegalArgumentException("Error: Player name must be shorter than 5 characters!");
            }
        }
        return playerNames;
    }

    public int parseCountData(String cnt) {
        try {
            return Integer.parseInt(cnt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: Enter the right digit");
        }
    }
}
