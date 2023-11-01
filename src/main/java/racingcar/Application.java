package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();

        GameView.gameStart();
        cars.createCar(Input.inputCarName());
        GameView.gameCount();
        cars.moveCount = Input.inputGameCount();

        cars.moveCarFor();

        GameView.gameResult(cars.referee());
    }
}
