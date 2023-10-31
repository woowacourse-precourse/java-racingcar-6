package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

import static racingcar.config.GameConfig.*;

public class GameBoard {
    private final List<Player> players;

    public GameBoard(List<Player> players) {
        validateDuplication(players);
        this.players = players;
    }

    private static void validateDuplication(List<Player> players) {
        long numberOfDistinctPlayer = players.stream().distinct().count();
        if (players.size() != numberOfDistinctPlayer) {
            throw new IllegalArgumentException();
        }
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
                .filter(car -> car.getPosition().equals(maxDistance))
                .toList();
    }

    public List<Player> getCopyOfPlayerList() {
        return List.copyOf(players);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(
                RANDOM_NUMBER_MINIMUM_RANGE,
                RANDOM_NUMBER_MAXIMUM_RANGE
        ) >= RANDOM_NUMBER_THRESHOLD;
    }
}
