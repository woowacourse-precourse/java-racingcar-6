package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    List<Car> cars = new ArrayList<>();

    String[] names = inputView.getNames();
    int rounds = inputView.getRounds();

    public void start(){

        for(int i = 0; i < names.length; i++){
            String name = names[i];
            cars.add(new Car(name, 0));
        }

        roundPosition();
    }

    public void roundPosition() {
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    cars.get(j).setPosition(cars.get(j).getPosition() + 1);
                }
            }
        }
        for (Car carResult : cars) {
            outputView.round(carResult);
        }
    }
}
