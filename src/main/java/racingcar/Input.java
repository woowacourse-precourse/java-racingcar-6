package racingcar;

public class Input {
    void inputName(String name) {
        String[] names = name.split(",");
        Car cars = new Car(names);
    }
    int inputNumber(String number) {
        return Integer.parseInt(number);
    }

}
