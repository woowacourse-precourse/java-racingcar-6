package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constants.Message.START_RACE;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MoveTest {

    @Test
    void Car_객체_생성_시_이동_리스트_초기화() {

        // given
        Car car;

        // when - initializeDistances()
        car = new Car(Arrays.asList("pobi", "woni", "jun"));

        // then
        assertThat(car.movedDistances).isEqualTo(Arrays.asList("", "", ""));
    }

    @Test
    void 랜덤_값_4이상_9이하_시_전진() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        // when - moveRandomly()
        for (int i = 0; i < car.movedDistances.size(); i++) {

            if (Randoms.pickNumberInRange(4, 9) >= 4) {
                car.movedDistances.set(i, car.movedDistances.get(i) + "-");
            }

        }

        // then
        assertThat(car.movedDistances).isEqualTo(Arrays.asList("-", "-", "-"));
    }

    @Test
    void 랜덤_값_0이상_3이하_시_스톱() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        // when - moveRandomly()
        for (int i = 0; i < car.movedDistances.size(); i++) {

            if (Randoms.pickNumberInRange(0, 3) >= 4) {
                car.movedDistances.set(i, car.movedDistances.get(i) + "-");
            }

        }

        // then
        assertThat(car.movedDistances).isEqualTo(Arrays.asList("", "", ""));
    }

    @Test
    void 이동_거리_출력문() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // moveRandomly()
        for (int i = 0; i < car.movedDistances.size(); i++) {

            if (Randoms.pickNumberInRange(4, 9) >= 4) {
                car.movedDistances.set(i, car.movedDistances.get(i) + "-");
            }

        }

        // when - printDistances()
        for (int k = 0; k < car.names.size(); k++) {
            System.out.println(car.names.get(k) + " : " + car.movedDistances.get(k));
        }

        System.out.println();

        // then
        assertThat(out.toString())
                .contains("pobi : -")
                .contains("woni : -")
                .contains("jun : -");

    }

    @Test
    void 이동_출력문() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        car.move(5);

        // then
        assertThat(out.toString())
                .contains(START_RACE.getMessage())
                .contains("pobi : ")
                .contains("woni : ")
                .contains("jun : ");
    }
}


