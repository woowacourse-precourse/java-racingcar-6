package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        CarManager carManager = new CarManager(inputManager);

        int times = inputManager.getTimes();
        for (int i = 0; i < times; i++) {
            carManager.runCars();
            carManager.printResult();
        }

        carManager.printWinner();
    }
}
