package racingcar;

public class Input {
    void inputName(String name) {
        String[] names = name.split(",");
        Car cars = new Car(names);
    }

}
