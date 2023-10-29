package racingcar.domain;

public class CarManager {
    private static CarManager carManager = null;
    private static int carQuantity;
    private static int attemptNumber;

    private CarManager() {};

    public static CarManager create() {
        if(carManager == null){
            carManager = new CarManager();
        }
        return carManager;
    }


    public int getCarQuantity() {
        return carQuantity;
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }
}
