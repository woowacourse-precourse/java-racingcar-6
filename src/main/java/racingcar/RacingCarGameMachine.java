package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingCarGameMachine {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int currentRound = 1;
    private int maxRoundCount;

    public RacingCarGameMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void init(String nameInput, int roundCount) {
        initRacingCar(nameInput);
        this.maxRoundCount = roundCount;
    }

    private void initRacingCar(String nameInput) {
        racingCarList = new ArrayList<>();

        List<String> nameList = parseNameInput(nameInput);
        for (String name : nameList) {
            racingCarList.add(new RacingCar(randomNumberGenerator, name));
        }
    }

    private List<String> parseNameInput(String nameInput) {
        String[] names = nameInput.split(",");
        return Arrays.stream(names).toList();
    }

    public String playRound() {
        if(!isGameInProgress()) {
            throw new IllegalStateException();
        }
        currentRound++;
        moveAllRacingCar();
        return getRoundResult();
    }

    public boolean isGameInProgress() {
        return currentRound <= maxRoundCount;
    }

    private void moveAllRacingCar() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move();
        }
    }

    private String getRoundResult() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (RacingCar racingCar : racingCarList) {
            stringJoiner.add(racingCar.getCurrentStatus());
        }
        return stringJoiner.toString();
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCarList) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }
}
