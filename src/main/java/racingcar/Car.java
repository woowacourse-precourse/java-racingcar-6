package racingcar;

public class Car {
    private String name;
    private Integer position;

    public Car(String name, Integer position) {
        checkCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    public void checkCarNameLength(String carName){
        if(carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
