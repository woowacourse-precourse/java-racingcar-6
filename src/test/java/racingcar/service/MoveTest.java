package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MoveTest {

    private Car TC;
    private CarGenerator TCG;
    private RandomNumber TRN;
    private RandomNumberGenerator TRNG;
    private Move TM;
    private final Integer[] MOVING_FORWARD = {5, 5, 5};

    private final Integer[] STOP = {3, 3, 3};

    @BeforeEach
    void setUp() {
        TC = new Car();
        TCG = new CarGenerator();
        TRN = new RandomNumber();
        TRNG = new RandomNumberGenerator();
        TM = new Move();
    }

    @Test
    void moveTheCar_랜덤값_4이상_앞으로_전진_테스트() {
        //given
        final String cars = "povi1,povi2,povi3";
        final LinkedHashMap<String, String> carList = TCG.createCarList(cars);
        TC.setCarList(carList);
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < MOVING_FORWARD.length; i++) {
            randomNumberList.add(MOVING_FORWARD[i]);
        }
        //when
        TM.moveTheCar(TC.getCarList(), randomNumberList);

        //then
        Assertions.assertThat(TC.getCarList().get("povi1")).isEqualTo("-");
        Assertions.assertThat(TC.getCarList().get("povi2")).isEqualTo("-");
        Assertions.assertThat(TC.getCarList().get("povi3")).isEqualTo("-");
    }

    @Test
    void stopTheCar_랜덤값_4미만_정지_테스트() {
        //given
        final String cars = "povi1,povi2,povi3";
        final LinkedHashMap<String, String> carList = TCG.createCarList(cars);
        TC.setCarList(carList);
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < STOP.length; i++) {
            randomNumberList.add(STOP[i]);
        }

        //when
        TM.moveTheCar(TC.getCarList(), randomNumberList);

        //then
        Assertions.assertThat(TC.getCarList().get("povi1")).isEqualTo("");
        Assertions.assertThat(TC.getCarList().get("povi2")).isEqualTo("");
        Assertions.assertThat(TC.getCarList().get("povi3")).isEqualTo("");
    }
}
