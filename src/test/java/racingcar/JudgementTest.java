package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Judgement;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("최장거리 자동차 찾는 기능 확인")
    void 랜덤_숫자_생성() {
        Judgement judgement = new Judgement();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.carName = "siwon";
        car1.status = "----";
        Car car2 = new Car();
        car2.carName = "sean";
        car2.status = "--";
        cars.add(car1);
        cars.add(car2);
        judgement.findMaxDistance(cars);
        assertThat(judgement.maxDistance).isEqualTo(4);
    }

    @Test
    @DisplayName("우승자가 두 명 이상일 때 최종 결과 확인")
    void 우승자_2명_이상() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("sean,siwon,cool", "1");
                    assertThat(output()).contains("sean : -", "siwon : ", "cool : -", "최종 우승자 : sean, cool");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
