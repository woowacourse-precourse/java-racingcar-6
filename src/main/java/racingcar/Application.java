package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.generateCars();
        game.generateRoundCount();

        game.showProcessingBoard();
        game.showResultBoard();
    }



}
