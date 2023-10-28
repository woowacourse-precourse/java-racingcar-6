package racingcar.model;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int generateRandomNumber() {
        return 0;
    }

    //test 만을 위한 코드입니다.
    public String getNameForTest() {
        return name;
    }
}
