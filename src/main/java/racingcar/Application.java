package racingcar;

import racingcar.view.ViewInput;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ViewInput viewInput = new ViewInput();

        List<String> cars = viewInput.getCarNames();
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i) + " ");
        }
        System.out.println();
    }
}
