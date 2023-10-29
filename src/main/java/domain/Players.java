package domain;

import java.util.List;
import java.util.stream.Collectors;
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
            checkRacingCarMoveForward(racingCar);
            buildRacingStatusMessage(builder, racingCar);
        }
        builder.append("\n");

        return builder.toString();
    }

    private static void checkRacingCarMoveForward(RacingCar racingCar) {
        if (racingCar.isMoveForward(RandomGenerator.generateNumber())) {
            racingCar.moveForward();
        }
    }

    private static void buildRacingStatusMessage(StringBuilder builder, RacingCar racingCar) {
        builder.append(racingCar.getName()).append(COLON_WITH_WHITESPACE).append(racingCar.getLocation())
                .append("\n");
    }

    public List<String> findWinners() {
        int maxDistance = players.stream()
                                    .map(RacingCar::getLocation)
                                    .map(String::length)
                                    .max(Integer::compare)
                                    .orElse(0);

        return players.stream()
                        .filter(racingCar -> racingCar.getLocation().length() == maxDistance)
                        .map(RacingCar::getName)
                        .collect(Collectors.toList());
    }

    public int size() {
        return this.players.size();
    }

}
