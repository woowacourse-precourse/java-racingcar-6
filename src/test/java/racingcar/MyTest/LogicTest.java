package racingcar.MyTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import racingcar.controller.RacingController;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Round;

import java.util.ArrayList;


public class LogicTest {
    RacingController racingController = new RacingController();
    ArrayList<Car> carsList = new ArrayList<>();
    private Car car1;
    private Car car2;
    private Round round;

    @BeforeEach
    public void 자동차_저장() {
        round = new Round();
        car1 = new Car("포비",0);
        car2 = new Car("수현",1);
        carsList.add(car1); carsList.add(car2);
    }

    @Test
    public void 한칸이동테스트() {
        // when
        car1.increaseCarLocation();

        // then
        Assertions.assertThat(car1.getLocation()).isEqualTo(1);
    }

    @Test
    public void 라운드증가테스트() {
        //when
        round.increaseRoundNum();

        //then
        Assertions.assertThat(round.getRoundNum()).isEqualTo(1);
    }

    @Test
    public void 승자담기테스트() {
        // given
        int maxValue = 0;
        ArrayList<String> winnerNameList = new ArrayList<>();

        // when
        for (Car car : carsList) {
            maxValue = Math.max(maxValue,car.getLocation());
        }
        for (Car car : carsList) {
            if (car.getLocation() == maxValue) {
                winnerNameList.add(car.getName());
            }
        }

        // then
        Assertions.assertThat(winnerNameList).contains("수현");
    }
}
