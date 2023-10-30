package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class RacingCarGameMachine {
    private final String GAME_RESULT = "최종 우승자 : %s";

    private final RandomNumberGenerator randomNumberGenerator;
    private final RacingCarGameMachineValidator racingCarGameMachineValidator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int currentRound = 1;
    private int maxRoundCount;

    public RacingCarGameMachine(
            RacingCarGameMachineValidator racingCarGameMachineValidator,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.racingCarGameMachineValidator = racingCarGameMachineValidator;
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
        if (!isGameInProgress()) {
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

    public String getGameResult() {
        if (isGameInProgress()) {
            throw new IllegalStateException();
        }
        return getGameResultMessage();
    }

    private String getGameResultMessage() {
        List<String> winRacingCarNames = findWinRacingCars()
                .stream()
                .map(RacingCar::getName)
                .toList();
        String joinedWinRacingCarName = String.join(", ", winRacingCarNames);
        return String.format(GAME_RESULT, joinedWinRacingCarName);
    }

    private List<RacingCar> findWinRacingCars() {
        int maxDistance = findMaxDistance();
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCarList) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }
}
