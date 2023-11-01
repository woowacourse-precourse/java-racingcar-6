package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars;

    public Game() {
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void StringListChangeCarList(List<String> carNames) {
        cars = new ArrayList<>();

        for(String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void showCarAdvancedResult(int tryCount) {
        for(int i = 0; i < tryCount; i++) {
            for(Car car : cars) {
                int randomNumber = makeRandomNumber();

                car.advance(randomNumber);

                OutputView.outputCarRunResult(car.getName(), car.getAdvanceCount());
            }
            System.out.println("");
        }
    }


}
