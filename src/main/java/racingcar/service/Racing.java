package racingcar.service;

import racingcar.domain.Car;
import racingcar.utility.ProviderRandomValue;

import java.util.HashMap;
import java.util.Iterator;

public class Racing {

    private ProviderRandomValue providerRandomValue;
    private Judgement judgement;

    private Car cars;

    public Racing() {
    }

    public void play(Car carList, int attempt) {
        cars = carList;

        Iterator<String> carName = carList.getCarName().iterator();
        while (carName.hasNext()) {
            raceCar(carName.next());
        }
    }

    private void raceCar(String carName) {
        int random = providerRandomValue.returnRandomNumeric();

        if (judgement.isMovableRange(random)) {
            moving(carName);
        }
    }

    private void moving(String carName) {
        cars.setMovingCount(carName);
    }

}
