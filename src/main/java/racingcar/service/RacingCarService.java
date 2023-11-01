package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.repository.RacingCarRepository;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final RacingCarRepository racingCarRepository = new RacingCarRepository();

    public RacingCar saveRacingCar(String carName) {
        RacingCar racingCar = new RacingCar(carName, "", 0);
        return racingCarRepository.save(racingCar);
    }

    public List<RacingCar> findAll() {
        return racingCarRepository.findAll();
    }

    public void playGame(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
                addForwardCount(racingCar);
        }
        printGameResult();
    }

    public List<String> getWinner(List<RacingCar> racingCarList) {
        int max = 0;
        List<String> winnerList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            int forwardCount = racingCar.getForwardCount();
            if (forwardCount >= max)  {
                max = forwardCount;
                winnerList.add(racingCar.getCarName());
            }
        }
        return winnerList;
    }

    private void printGameResult() {
        List<RacingCar> racingCarList = findAll();
        for (RacingCar racingCar : racingCarList) {
            System.out.println(racingCar.getCarName() + " : " + racingCar.getForwardProgress());
        }
    }


    private void addForwardCount(RacingCar racingCar) {
        if (checkForwardCondition())
            racingCar.increaseForwardProgress();
    }

    private boolean checkForwardCondition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
