package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import racingcar.domain.Racingcar;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryRacingcarRepository;

public class RacingcarServiceImpl implements RacingcarService {

    private final static CarRepository carRepository = new MemoryRacingcarRepository();
    private final int movingDistance = 1;

    public void joinRacingcar(String nameList) {
        for (String name : nameList.split(",")) {
            carRepository.save(name);
        }
    }

    public ArrayList<Racingcar> changeMoving() {
        ArrayList<Racingcar> racingcarList = carRepository.findAll();

        for (Racingcar racingcar : racingcarList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                racingcar.setMovingforward(movingDistance);
            }
        }

        return racingcarList;
    }

    public ArrayList<String> selectWinner() {
        ArrayList<Racingcar> racingcarList = carRepository.findAll();
        ArrayList<String> winners = new ArrayList<>();

        int max = 0;

        for (Racingcar racingCar : racingcarList) {
            if (racingCar.getMovingforward() == max) {
                winners.add(racingCar.getName());
            }

            if (racingCar.getMovingforward() > max) {
                max = racingCar.getMovingforward();
                winners.clear();
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }

}
