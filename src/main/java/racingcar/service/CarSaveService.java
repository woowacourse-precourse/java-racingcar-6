package racingcar.service;

import java.util.ArrayList;
import racingcar.config.InputConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;

public class CarSaveService {

    public static Participants save(String[] names) {
        validateLength(names);
        int length = names.length;

        Participants participants = new Participants(new ArrayList<>(length));
        for (int i = 0; i < length; i++) {
            participants.save(Car.of(i, names[i]));
        }
        return participants;
    }

    private static void validateLength(String[] names) {
        if (names.length < InputConfig.PARTICIPANT_MIN) {
            throw new IllegalArgumentException("참가자는 2명 이상 입력해주세요.");
        }
    }
}
