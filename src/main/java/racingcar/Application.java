package racingcar;

public class Application {
  public static void main(String[] args) {
    CarGame carGame = new CarGame();
    carGame.prompt();
    carGame.play();
  }
}
