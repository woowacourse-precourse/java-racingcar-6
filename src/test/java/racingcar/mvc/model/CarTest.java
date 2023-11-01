package racingcar.mvc.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarSetting;

public class CarTest {
    private Car car;
    private CarSetting carSetting;
    private static String INPUT_VALUE = "songHee, minGu, zinHee";
    private static final int TRIAL_NUM = 10;
    private static final int MAX_SCORE_INITIAL_NUM = 0;

    @Test
    public void 전진으로_인한_점수가_추가되었는지_확인() {
        //given
        car = new Car();
        carSetting = car.setCarSetting(new CarSetting(INPUT_VALUE));

        //when
        carSetting.setTrialNumber(TRIAL_NUM);
        car.goFront();
        AtomicInteger sumScore = new AtomicInteger();
        Collection<Integer> values = carSetting.getCarsSituation().values();
        values.forEach(sumScore::addAndGet);

        //then
        assertThat(carSetting.getMaxScore()).isGreaterThan(MAX_SCORE_INITIAL_NUM);
        assertThat(sumScore).hasPositiveValue();

    }
}
