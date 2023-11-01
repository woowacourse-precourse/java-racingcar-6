package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface RacingCarService {

    List<Car> createCarList(); // 자동차 이름 입력 받아 생성하고 반환하는 함수 (예외처리 필요)

    int getAttemptCount(); // 시도할 회수 입력받아 반환하는 함수 (예외처리 필요)

    void moveCars(List<Car> carList); // 무작위 값 생성해서 자동차 이동시키는 함수

    void printMovementCounts(List<Car> carList); // 자동차 이동 회수 출력 함수

    void announceWinner(List<Car> carList); // 우승자 알림 함수
}
