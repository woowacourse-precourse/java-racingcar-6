package racingcar;

public class Application {
  public static void main(String[] args) {
    try {
      Game game = new Game();
      game.start();
    } catch (IllegalArgumentException e) {
      System.err.println("입력이 잘못되었습니다: " + e.getMessage());
    }
  }
}
