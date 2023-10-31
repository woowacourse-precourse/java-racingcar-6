package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

import static racingcar.service.constants.ServiceType.*;

public class GameService {

    private final List<Car> carList;

    public GameService(List<Car> carList) {
        this.carList = carList;
    }

    public void race() {
        for (Car participant : carList) {
            int ranNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getNumber(), MAX_RANDOM_NUMBER.getNumber());
            if (ranNum >= ADVANCE_FOR_MIN_NUMBER.getNumber()) {
                participant.advance();
            }
        }
    }

    public List<Car> selectWinner() {
        List<Car> winnerList = new ArrayList<>();
        Car maxDistanceCar = Collections.max(carList, Comparator.comparingInt(Car::getDistance));
        for (Car car : carList) {
            if (car.getDistance() == maxDistanceCar.getDistance()) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }
}
