package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinCarsTest {

    private Car carMoveOneTime;
    private Car carMoveTwoTimes;
    private Car carMoveThreeTimes;

    @BeforeEach
    //테스트 수행을 위한 Car 초기화
    void init() {
        carMoveOneTime = new Car("One");
        carMoveOneTime.move(true);

        carMoveTwoTimes = new Car("Two");
        carMoveTwoTimes.move(true);
        carMoveTwoTimes.move(true);

        carMoveThreeTimes = new Car("Three");
        carMoveThreeTimes.move(true);
        carMoveThreeTimes.move(true);
        carMoveThreeTimes.move(true);

    }

    @Test
    @DisplayName("여러개의 차를 WinCars 에 비교하면 가장 position 이 높은 차 이름으로 우승 메시지를 만들어준다.")
    void winCarsTest() {
        WinCars winCars = new WinCars();
        winCars.checkCarWinGame(carMoveOneTime);
        winCars.checkCarWinGame(carMoveTwoTimes);
        winCars.checkCarWinGame(carMoveThreeTimes);
        String winners = winCars.getWinCars();
        Assertions.assertThat(winners).isEqualTo("최종 우승자 : Three");
    }

    @Test
    @DisplayName("여러개의 차 비교시 가장 높은 position 이 2개 이상인 경우 그 차들로 우승 메세지를 만들어준다.")
    void winCarsTest_SamePosition() {
        WinCars winCars = new WinCars();
        winCars.checkCarWinGame(carMoveOneTime);
        winCars.checkCarWinGame(carMoveThreeTimes);
        winCars.checkCarWinGame(carMoveTwoTimes);
        winCars.checkCarWinGame(carMoveThreeTimes);
        winCars.checkCarWinGame(carMoveOneTime);
        String winners = winCars.getWinCars();
        Assertions.assertThat(winners).isEqualTo("최종 우승자 : Three, Three");
    }
}
