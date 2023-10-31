package racingcar;

public class Application {
    public static void main(String[] args) {

        CheckForm checkForm = new CheckForm();
        Sorting sort = new Sorting();
        IO io = new IO(checkForm);
        Game game = new Game(io, sort, checkForm);

        game.setting();
    }
}
