package racingcar;

import java.util.List;

public class GameClient {
    private final RacingCarList racingCars;
    private final GameClientInput gameClientInput;
    private final GameClientOutput gameClientOutput;
    private int totalMoves;

    public GameClient() {
        racingCars = new RacingCarList();
        gameClientInput = new GameClientInput();
        gameClientOutput = new GameClientOutput();
    }

    public void prepareRacing() {
        prepareNames();
        prepareMoves();
    }

    public void playRacing() {
        prepareRacing();

        gameClientOutput.printResultMessage();
        for (int i = 0; i < totalMoves; i++) {
            moveRacingCars();
            printCurrentRacingStatus();
        }

        printWinners();
    }


    private void prepareNames() {
        gameClientOutput.printForAskingNames();
        List<String> names = gameClientInput.getNames();
        racingCars.addRacingCarsByNames(names);
    }

    private void prepareMoves() {
        gameClientOutput.printForAskingMoves();
        totalMoves = gameClientInput.getTotalMoves();
    }

    private void moveRacingCars() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(racingCars.getRacingCarCount());
        racingCars.moveRacingCarsBasedOnGivenNumbers(randomNumbers);
    }

    private void printCurrentRacingStatus() {
        List<RacingCarStatus> statuses = racingCars.collectStatus();
        gameClientOutput.printRacingStatus(statuses);
    }

    private void printWinners() {
        List<String> winners = racingCars.getWinners();
        gameClientOutput.printWinners(winners);
    }
}
