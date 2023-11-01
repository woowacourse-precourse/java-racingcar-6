package racingcar.dto;

public class CarResult {
    private String carName;
    private int carDistances;

    private CarResult() {}

    public static CarResult createCarResult(String carName, int carDistances) {
        CarResult carResult = new CarResult();
        carResult.carName = carName;
        carResult.carDistances = carDistances;

        return carResult;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarDistances() {
        return carDistances;
    }
}
