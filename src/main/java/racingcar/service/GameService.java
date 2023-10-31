package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;
import java.util.List;

public class GameService {
    // 게임을 진행하는 메서드
    public void playGame(List<Car> Cars, int rounds) {
        for (int round = 0; round < rounds; round++){
            // 각 라운드를 실행하고 자동차를 전진시키는 로직 구현
        }
        // 최종 승자를 결정하는 로직
    }

    // 자동차를 전진시키는 메서드 -> 자동차의 위치 업데이트시킴
    public void moveCars(List<Car> cars) {
        // 각 자동차를 전진

    }

    // 라운드에서 승자를 판별하는 메서드로 라운드에서 가장 멀리 이동한 자동차를 판별
    public List<Car> determineRoundWinners(List<Car> cars) {
        // 라운드에서 승자를 판별하는 로직 구현
        return cars;
    }

    // 최종 승자를 판별하는 메서드
    public List<Car> determineGameWinners(List<Car> cars) {
        // 최종 승자를 결정하는 로직
        return cars;
    }


    // 필요 기능 추가

}
