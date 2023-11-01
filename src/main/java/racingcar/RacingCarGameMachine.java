package racingcar;

import racingcar.constant.ErrorMessage;
import racingcar.constant.OutputMessage;
import racingcar.validator.RacingCarGameMachineValidator;
import racingcar.validator.RacingCarValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameMachine {
    private final RacingCarGameMachineValidator racingCarGameMachineValidator;
    private final RacingCarValidator racingCarValidator;
    private final RandomNumberGenerator randomNumberGenerator;

    private List<RacingCar> racingCarList = new ArrayList<>();
    private int currentRound = 1;
    private int maxRoundCount;
    private boolean initialized = false;

    public RacingCarGameMachine(
            RacingCarGameMachineValidator racingCarGameMachineValidator,
            RacingCarValidator racingCarValidator,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.racingCarGameMachineValidator = racingCarGameMachineValidator;
        this.racingCarValidator = racingCarValidator;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void init(String nameInput, int roundCount) {
        initRacingCar(nameInput);
        initRoundCount(roundCount);
        initialized = true;
    }

    private void initRacingCar(String nameInput) {
        racingCarList = new ArrayList<>();
        List<String> nameList = parseNameInput(nameInput);

        racingCarGameMachineValidator.validateNameList(nameList);

        nameList.forEach(
                name -> racingCarList.add(new RacingCar(racingCarValidator, randomNumberGenerator, name))
        );
    }

    private List<String> parseNameInput(String nameInput) {
        String[] names = nameInput.split(",");

        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void initRoundCount(int roundCount) {
        racingCarGameMachineValidator.validateRoundCount(roundCount);
        maxRoundCount = roundCount;
        currentRound = 1;
    }

    public String getRoundResult() {
        playRound();

        StringBuilder resultBuilder = new StringBuilder();
        for (RacingCar racingCar : racingCarList) {
            resultBuilder.append(racingCar.getCurrentStatus());
            resultBuilder.append("\n");
        }
        return resultBuilder.toString();
    }

    private void playRound() {
        if (!canPlayRound()) {
            throw new IllegalStateException(ErrorMessage.CAN_NOT_PLAY_ROUND.getMessage());
        }
        currentRound++;
        moveAllRacingCar();
    }

    public boolean canPlayRound() {
        return initialized && currentRound <= maxRoundCount;
    }

    private void moveAllRacingCar() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move();
        }
    }

    public String getGameResult() {
        if (!canGetResult()) {
            throw new IllegalStateException(ErrorMessage.CAN_NOT_GET_RESULT.getMessage());
        }
        finishGame();
        return getGameResultMessage();
    }

    private boolean canGetResult() {
        return initialized && currentRound == maxRoundCount + 1;
    }

    private void finishGame() {
        initialized = false;
    }

    private String getGameResultMessage() {
        List<String> winRacingCarNames = findWinRacingCars()
                .stream()
                .map(RacingCar::getName)
                .toList();
        String joinedWinRacingCarName = String.join(", ", winRacingCarNames);
        return String.format(OutputMessage.GAME_RESULT.getMessage(), joinedWinRacingCarName);
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
