package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.policy.Policy;

public class CarRacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 자동차_경주_전진없음_정상처리() {
        class testPolicy extends Policy {
            @Override
            public int getRandomDecimalNumber() {
                return STOP;
            }
        }
        testPolicy testPolicy = new testPolicy();

        List<Car> carList = List.of(
                new Car("a"),
                new Car("b")
        );

        CarRacing carRacing = new CarRacing(carList, 3, testPolicy);

        CarRacingResult carRacingResult = carRacing.start();

        assertThat(carRacingResult.toString()).isEqualTo("최종 우승자 : a, b");
    }

    @Test
    void 자동차_경주_전부전진_정상처리() {
        class testPolicy extends Policy {
            @Override
            public int getRandomDecimalNumber() {
                return MOVING_FORWARD;
            }
        }
        testPolicy testPolicy = new testPolicy();

        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue"),
                new Car("hoon")
        );
        CarRacing carRacing = new CarRacing(carList, 3, testPolicy);

        CarRacingResult carRacingResult = carRacing.start();

        assertThat(carRacingResult.toString()).isEqualTo("최종 우승자 : bae, sue, hoon");
    }

    @Test
    void 자동차_경주_한_자동차만_전진_정상처리() {
        class testPolicy extends Policy {
            private int count = -1;

            @Override
            public int getRandomDecimalNumber() {
                count++;
                if (count % STOP == 0) {
                    return MOVING_FORWARD;
                }
                return STOP;
            }
        }
        testPolicy testPolicy = new testPolicy();

        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue"),
                new Car("hoon")
        );
        CarRacing carRacing = new CarRacing(carList, 3, testPolicy);
        CarRacingResult carRacingResult = carRacing.start();

        assertThat(carRacingResult.toString()).isEqualTo("최종 우승자 : bae");
    }
}
