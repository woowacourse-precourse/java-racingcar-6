package racingcar;

public class Application {
    public static void main(String[] args) {
        GameManager GM = new GameManager();

        Game game = new Game(GM.inputListCarsName(), GM.inputTrial());

        game.playGame();

        GM.findWinner(game.getCars());
    }
}
