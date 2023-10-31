package racingcar.domain.CarList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.view.IOTest;

class CarTest extends IOTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final Car car = new Car("aaa");

    @DisplayName("자동차 이동 테스트")
    @Test
    void checkMoveOrNot() {
        int randomNumber = randomNumberGenerator.generate();

        assertRandomNumberInRangeTest(
            () -> {
                run("aaa,bbb", "1");
                assertThat(getOutput()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            4, 3
        );

    }

    @Test
    void createDto() {

    }
}