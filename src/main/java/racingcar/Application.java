package racingcar;

public class Application {
  public static void main(String[] args) {
    CarView carView = new CarView();
    RacingGameController controller = new RacingGameController(carView);
    controller.runGame();
  }
}
