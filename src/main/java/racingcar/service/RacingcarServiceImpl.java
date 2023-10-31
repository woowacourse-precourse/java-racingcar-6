package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import racingcar.domain.Racingcar;
import racingcar.repository.RacingcarRepository;

public class RacingcarServiceImpl implements RacingcarService {

    private final RacingcarRepository carRepository;
    private final int MOVING_DISTANCE = 1;

    public RacingcarServiceImpl(RacingcarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void joinRacingcar(String nameList) {
        for (String name : nameList.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
            }

            carRepository.possibleNameCheck(name);
            if (name.startsWith(" ")) throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백으로 시작해서는 안 됩니다.");
            if (name.contains("\n")) throw new IllegalArgumentException("[ERROR] 자동차 이름 입력 시 줄바꿈 사용을 금지합니다.");

            carRepository.save(name);
        }
    }

    public ArrayList<Racingcar> changeMoving() {
        ArrayList<Racingcar> racingcarList = carRepository.findAll();

        for (Racingcar racingcar : racingcarList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                racingcar.setMovingforward(MOVING_DISTANCE);
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

    public void initStore() {
        carRepository.clear();
    }

}
