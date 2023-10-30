package racingcar;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        Validator validator = new Validator();
        RacingCarMapper racingCarMapper = new RacingCarMapper();
        RacingCarGame game = new RacingCarGame(prompt, validator, racingCarMapper);

        game.start();
    }
}
