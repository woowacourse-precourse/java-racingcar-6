package racingcar;

public class Application {
  public static void main(String[] args) {

    GameManager gameManager = new GameManager();
    gameManager.init();
    gameManager.start();
    gameManager.checkWinner();
  }
}
