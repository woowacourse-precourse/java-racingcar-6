package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = InputHandler.getCarNames();
            int raceRounds = InputHandler.getRaceRounds();

            RacingGame racingGame = new RacingGame(carNames);
            for (int i = 0; i < raceRounds; i++) {
                racingGame.race(1);
                OutputDisplay.showRaceResult(racingGame.getCars());
            }
            OutputDisplay.showWinners(racingGame.getCars());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
