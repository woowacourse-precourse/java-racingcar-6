package racingcar.domain;

public class Car {

    private String carName;
    private int level;
    private String log;


    private Car(String carName, int level, String log) {
        this.carName = carName;
        this.level = level;
        this.log = log;
    }

    public static void setCar(String carName) {
        CarList carList = CarList.getInstance();
        Car car = new Car(carName, 0, "");
        carList.getCars().add(car);
    }


}
