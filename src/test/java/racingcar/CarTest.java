package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static void main(String[] args) {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.moveIfSatisfy();
        pobi.moveIfSatisfy();
        woni.moveIfSatisfy();
        woni.moveIfSatisfy();

        System.out.println(pobi.getMoveCount());
        System.out.println(woni.getMoveCount());
    }

    @Test
    void getMoveCount_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    main(new String[]{});
                    assertThat(output()).contains("1", "2"); // output() 메서드의 trim() 적용됨을 유의
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}