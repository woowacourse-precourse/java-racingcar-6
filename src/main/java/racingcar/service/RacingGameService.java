package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.repository.Car;
import racingcar.repository.CarInfo;
import racingcar.repository.RacingGameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private RacingGameRepository racingGameRepository;
    private OutputService outputService;

    public RacingGameService(RacingGameRepository racingGameRepository, OutputService outputService) {
        this.racingGameRepository = racingGameRepository;
        this.outputService = outputService;
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

    public void runRace(int moveCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            move();
            outputService.printSingleResult();
        }
        outputService.printRacingGameResult();
    }
}
