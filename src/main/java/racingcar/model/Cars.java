package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void initCars(List<String> carNames) {
        carNames.stream()
                .map(name -> new Car(new Name(name), new Position()))
                .forEach(carList::add);
    }

    public void doRound(List<String> carNames, int round) {
        initCars(carNames);
        for (int i = 0; i<round; i++) {
            go();
            roundResult();
            System.out.println();
        }
    }

    public void go() {
        carList.forEach(Car::go);
    }

    public void roundResult() {
        OutputView.printCarResult(carList.stream()
                .map(Car::positionToString)
                .collect(Collectors.toList()));
    }

}
