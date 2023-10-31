package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import racingcar.domain.Racingcar;
import racingcar.repository.RacingcarRepository;

public class RacingcarServiceImpl implements RacingcarService {

    private final RacingcarRepository racingcarRepository;
    private final int MOVING_DISTANCE = 1;

    // DIP
    public RacingcarServiceImpl(RacingcarRepository racingcarRepository) {
        this.racingcarRepository = racingcarRepository;
    }

    // 이름으로 자동차를 생성하는 함수
    public void joinRacingcar(String nameList) {

        for (String name : nameList.split(",")) {
            RacingcarPossibleCheck racingcarPossibleCheck = new RacingcarPossibleCheck(racingcarRepository, name);
            racingcarPossibleCheck.allCheck();

            racingcarRepository.save(name);
        }
    }

    // 랜덤값을 이용해 전진 여부를 판단하는 함수
    public ArrayList<Racingcar> changeMoving() {
        ArrayList<Racingcar> racingcarList = racingcarRepository.findAll();

        for (Racingcar racingcar : racingcarList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                racingcar.setMovingforward(MOVING_DISTANCE);
            }
        }

        return racingcarList;
    }

    // 우승자 판별 함수
    public ArrayList<String> selectWinner() {
        ArrayList<Racingcar> racingcarList = racingcarRepository.findAll();
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

    // 초기화 함수
    public void initStore() {
        racingcarRepository.clear();
    }

}
