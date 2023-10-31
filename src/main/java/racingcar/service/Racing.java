package racingcar.service;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Iterator;

public class Racing {

    public Racing() {
    }

    public void play(Car carList, int attempt) {
        Iterator<String> carName = carList.getCarName().iterator();
        while (carName.hasNext()){
            raceOneCar(carName.next());
        }
    }

    private void raceOneCar(String carName) {
        
    }
}
