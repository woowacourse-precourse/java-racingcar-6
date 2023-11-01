package racingcar.developtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.NumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
public class DomainTest {
    private static final int MOVING_FORWARD_BOUND = 4;
    private static final int STOP_BOUND = 3;
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong"})
    void stringToListByComma_콤마를_기준으로_문자열을_리스트로_변환(String string) {
        CarFactory carFactory = new CarFactory();
        List<String> result = carFactory.stringToListByComma(string);
        assertThat(result.toString()).isEqualTo(Arrays.asList("pobi", "crong").toString());
    }


    @Test
    void proceedOwnRound_4일때_전진_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : -");
        },MOVING_FORWARD_BOUND);
    }
    @Test
    void proceedOwnRound_9일때_전진_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : -");
        },9);
    }

    @Test
    void proceedOwnRound_3일때_정지_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        },STOP_BOUND);
    }
    @Test
    void proceedOwnRound_0일때_정지_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        },0);
    }
    @Test
    void proceedOwnRound_앞으로_두번_전진_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : --");
        },MOVING_FORWARD_BOUND);
    }
    @Test
    void proceedOwnRound_두번_정지_합니다(){
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(()->{
            car.proceedOwnRound();
            car.proceedOwnRound();
            assertThat(car.getFormattedPosition()).isEqualTo("pobi : ");
        },STOP_BOUND);
    }


}
