package racingcar;

public class Game {
  public void start() {
    InputManager inputManager = new InputManager();
    String[] carNames = inputManager.getCarNames();
    int numAttempts = inputManager.getNumAttempts();

    Race race = new Race(carNames);
    OutputManager outputManager = new OutputManager();

    for (int attempt = 0; attempt < numAttempts; attempt++) {
      race.race();
      outputManager.displayCarPositions(race.getCars());
    }

    outputManager.announceWinners(race.getCars());
  }
}
