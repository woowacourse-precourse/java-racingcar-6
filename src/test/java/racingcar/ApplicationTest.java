package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("동점인 경우")
    @Test
    void sameScoreTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                4, 4
        );
    }

    @DisplayName("자동차 생성 테스트")
    @Test
    void generatorCarsTest() {
        Game game = new Game();
        String carNamesInput = "pobi,woni";

        List<Car> cars = game.generateCars(carNamesInput);

        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("pobi",0));
        carList.add(new Car("woni",0));

        assertThat(Objects.equals(cars, carList));
    }

    @DisplayName("게임 라운드 횟수 생성 테스트")
    @Test
    void generatorRoundCountTest() {
        Game game = new Game();
        String roundCountInput = "5";

        int roundCount = game.generateRoundCount(roundCountInput);

        assertThat(roundCount==5);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
