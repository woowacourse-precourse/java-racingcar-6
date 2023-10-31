package racingcar;

public class GameService {


    private ResultView view = new ResultView();

    GameService() {
        setUpGame();
        addRacingCar();
        startGame();
    }


    private void addRacingCar() {
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i)));
        }
    }

    private void startGame() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.tryMoveForward();
            }
        }
    }

    void showGameProgress() {
        for (int i = 1; i <= tryCount; i++) {
            for (Car car : cars) {
                view.printPosition(i, car.getSuccessCount());
            }
            System.out.println("");
        }
    }
}
