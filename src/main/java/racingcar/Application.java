package racingcar;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = RacingConsole.getCarNamesInput();
        String moveCountInput = RacingConsole.getMoveCountInput();

        RacingManager manager = new RacingManager(carNamesInput, moveCountInput);
        manager.startRace();

        RacingConsole.printMoveResult(manager.getRacingResult());
        RacingConsole.printRacingWinnerNames(manager.getRacingWinnerNames());
    }
}
