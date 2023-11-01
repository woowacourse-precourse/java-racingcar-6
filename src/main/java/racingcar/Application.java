package racingcar;

import view.InputView;

public class Application {
    public static void main(String[] args) {

        String[] names = InputView.inputCarNames();
        for (int i = 0; i < names.length; i++) {
            Car car = new Car(names[i]);
            System.out.println(car.getName());
        }

        int testNumber = InputView.inputTestNumber();
    }
}
