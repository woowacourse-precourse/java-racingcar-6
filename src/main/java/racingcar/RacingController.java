package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputManager inputManager;
    private List<Car> cars = new ArrayList<>();
    private String[] carNameArray;
    private int tryCount;

    public RacingController(InputManager inputManager){
        this.inputManager = inputManager;
        setCarNameArray(inputManager.inputCarNames());
        setTryCount(inputManager.inputTryCount());
        setCars(carNameArray);
    }
    public void run() {
        while(tryCount-- > 0) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
            }
            printResult();
        }
        new Winner(cars);
    }


    private void printResult() {
        Message.printResultMessage();
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(carNameArray[i] + " : " );
            cars.get(i).printCarMoving();
        }
    }
    private void setCars(String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
    }
    private void setCarNameArray(String[] carNameArray) {
        this.carNameArray = carNameArray;
    }
    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
