package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class GameBoard {
    List<Player> players;

    public GameBoard(List<Player> players) {
        this.players = players;
    }

    public void processTurn() {
        players.stream()
                .filter(t -> canMove())
                .forEach(Player::move);
    }

    public List<Player> findWinners() {
        Integer maxDistance = players.stream()
                .max(Comparator.comparingInt(Player::getPosition))
                .get()
                .getPosition();

        return players.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }

    public List<Player> getCopyOfPlayerList() {
        return List.copyOf(players);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
