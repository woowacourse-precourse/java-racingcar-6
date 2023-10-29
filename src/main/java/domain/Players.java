package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomGenerator;

public class Players {

    private final List<RacingCar> players;

    private static final String COLON_WITH_WHITESPACE = " : ";

    public Players(List<RacingCar> players) {
        this.players = players;
    }

    public String processRacing() {
        StringBuilder builder = new StringBuilder();
        for (RacingCar racingCar : players) {
            if (racingCar.isMoveForward(RandomGenerator.generateNumber())) {
                racingCar.moveForward();
            }
            builder.append(racingCar.getName()).append(COLON_WITH_WHITESPACE).append(racingCar.getLocation())
                    .append("\n");
        }
        builder.append("\n");

        return builder.toString();
    }

    public List<String> findWinners() {
        int maxDistance = Integer.MIN_VALUE;
        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : players) {
            int distance = racingCar.getLocation().length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(racingCar.getName());
            } else if (distance == maxDistance) {
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }

    public int size() {
        return this.players.size();
    }

}
