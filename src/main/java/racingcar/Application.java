package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame game = new RacingGame();

        game.inputCarsName();
        game.inputTryNum();
        System.out.println("실행 결과");
        for (int i = 0; i < game.getTryNum(); i++) {
            game.tryToMove();
            game.printStatus();
        }
        if (game.numOfWinner() == 1) {
            game.printWinner();
        } else if (game.numOfWinner() > 1) {
            game.printWinners();
        }
    }
}