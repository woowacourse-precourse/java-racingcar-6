package racingcar.service;

import java.util.ArrayList;
import racingcar.config.InputConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public class CarSaveService {

    public static Participants save(String[] names) {
        int size = names.length;

        Participants participants = new Participants(new ArrayList<>(size));
        for (int i = 0; i < size; i++) {
            participants.save(Car.of(i, names[i]));
        }
        return participants;
    }
}
