package racingcar;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        String carNames = input.inputCarName();
        String tryCount = input.inputTryCount();

        RacingCar game = new RacingCar(carNames, Integer.parseInt(tryCount));
        game.startGame();
    }
}
