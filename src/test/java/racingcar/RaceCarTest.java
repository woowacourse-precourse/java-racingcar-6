package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCarTest extends NsTest {
    private RaceCar raceCar;

    @BeforeEach
    void setUp(){
        raceCar = new RaceCar("car1");
    }

    @Test
    void RaceCar_생성자_테스트(){
        raceCar.currentPosition();
        assertThat(output()).isEqualTo("car1 :");
    }

    @Test
    void 전진_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "1");
                    assertThat(output()).contains("car1 : -", "car2 : ", "최종 우승자 : car1");
                },
                4, 1
        );
    }

    @Test
    void 우승자_이름_출력_밑_최대거리_갱신_테스트(){
        RaceCar newCar = new RaceCar("car2", 5);
        newCar.raceForward();
        assertThat(raceCar.winnerCarName()).isEqualTo("");
        assertThat(newCar.winnerCarName()).isEqualTo("car2");
    }

    @Test
    void 자동차_현재위치_출력_테스트(){
        RaceCar newCar = new RaceCar("car2", 5);
        assertSimpleTest(() -> {
                    newCar.currentPosition();
                    assertThat(output()).contains("car2 : -----");
                }
                );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
