package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Car {
    private int position = 0;
    private String name = "";


    private Car(String name) {
        this.name = name;
    }

    public static List<Car> generate(List<String> cars) {
        List<Car> player = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            player.add(new Car(cars.get(i)));
        }
        return player;
    }

    public void moveForward() {
        if (4 <= rollDice()) {
            position++;
        }
    }

    private int rollDice() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void showProgress(Car car) {
        OutputView outputView = new OutputView();
        outputView.printProgress(car.name, car.position);
    }

}
