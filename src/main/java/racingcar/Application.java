package racingcar;
public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        String carNames = input.inputCarName();
        Exception.checkCarNames(carNames);

        String tryCount = input.inputTryCount();
        Exception.checkTryCount(tryCount);

        RacingCar game = new RacingCar(carNames, tryCount);
        game.startGame();
    }
}
