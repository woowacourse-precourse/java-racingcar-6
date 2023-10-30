package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager GM = new GameManager();

        Game game = new Game(GM.inputCarsName(), GM.inputTrial());

        game.playGame();

        GM.findWinner(game.getCars());
    }
}
