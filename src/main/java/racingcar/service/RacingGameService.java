package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.repository.Car;
import racingcar.repository.CarInfo;
import racingcar.repository.RacingGameRepository;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private RacingGameRepository racingGameRepository;

    public RacingGameService() {
        this.racingGameRepository = new RacingGameRepository();
    }

    public boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public void move() {
        List<CarInfo> carInfos = racingGameRepository.getCar();
        List<CarInfo> newCarInfos = new ArrayList<>();
        for (CarInfo carInfo : carInfos) {
            if (isMove()) {
                newCarInfos.add(new CarInfo(carInfo.getName(), carInfo.getDistance() + 1));
            } else {
                newCarInfos.add(carInfo);
            }
        }
        racingGameRepository.saveCar(newCarInfos);
    }
}
