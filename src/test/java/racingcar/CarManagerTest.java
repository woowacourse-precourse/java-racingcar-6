package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarManagerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static void main(String[] args) {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        CarManager pobiManager = new CarManager(pobi);
        CarManager woniManager = new CarManager(woni);

        pobiManager.moveIfSatisfy();
        woniManager.moveIfSatisfy();

        System.out.println(pobi);
        System.out.println(woni);
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    main(new String[]{});
                    assertThat(output()).contains("pobi : -", "woni :"); // output() 메서드의 trim() 적용됨을 유의
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}