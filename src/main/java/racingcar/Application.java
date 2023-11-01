package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        CarManager carManager = new CarManager();

        carManager.setCars(inputManager.getNames());
        int times = inputManager.getTimes();

        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            carManager.runCars();
            carManager.printResult();
        }

        carManager.printWinner();
    }
}
