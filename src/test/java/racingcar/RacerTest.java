package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.mocking.RandomsMocking;


public class RacerTest {
    Racer racer;
    @BeforeEach
    void setUp(){
        racer = new Racer("test");
    }
    @Test
    void 자동차_공장에서_경주할_차를_받을수_있다(){
        Car raceCar = racer.getRaceCar();
        Assertions.assertEquals(Car.class,raceCar.getClass());
    }
    @Test
    void 자동차_전진여부에_따라_현재_위치에서_일정_칸_전진할_수_있다() {

        RandomsMocking.fixPickNumberInRangeOverThreshold(
            () -> {
                int pastPos = racer.getCurrentPos();
                racer.runRaceEachStep();
                int currentPos = racer.getCurrentPos();

                Assertions.assertEquals
                    (pastPos + Config.FORWARD_DISTANCE, currentPos);
            });
    }
}
