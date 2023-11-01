package racingcar.object;

public class Car {
    private String name;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Car createCar(String name, String status){
        Car car = new Car();
        car.setName(name);
        car.setStatus(status);
        return car;
    }
}
