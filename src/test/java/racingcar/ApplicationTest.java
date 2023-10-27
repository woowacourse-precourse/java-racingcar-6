package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameConfig;
import racingcar.domain.Judgment;
import racingcar.domain.Race;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CAR_NAMES = "pobi, woni, junki, minji, himin, ho  ,jayz";
    private Car car;
    public GameConfig gameConfig;
    private Judgment judgment;
    private Race race;


    @BeforeEach
    void setting() {
        gameConfig = new GameConfig();
        judgment = new Judgment();
        race = new Race();
    }


    @Test
    void 자동차_생성() {
        //given
        String carNames = CAR_NAMES;

        //when
        List<Car> createdCars = gameConfig.createCars(carNames);
        String[] splitCarNames = carNames.split(",");

        //then
        assertThat(createdCars.size()).isEqualTo(splitCarNames.length);
    }

    @Test
    void 이름에_대한_예외처리_5글자초과() {
        //given
        String carNames = ",  , junki, kimminji,";

        //when
        assertThatThrownBy(() -> gameConfig.createCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 이름에_대한_예외처리_빈문자열() {
        //given
        String carNames = ",  ,,";

        //when
        assertThatThrownBy(() -> gameConfig.createCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_입력() {
        //given
        int moveCount = MOVING_FORWARD;

        //when
        gameConfig.setMoveCount(moveCount);

        //then
        assertThat(gameConfig.getMoveCount()).isEqualTo(moveCount);
    }

    @Test
    void 레이스_시작() {
        //given
        gameConfig.setMoveCount(MOVING_FORWARD);
        int moveCount = gameConfig.getMoveCount();
        List<Car> cars = gameConfig.createCars(CAR_NAMES);

        //when
        race.startRace(cars, moveCount);
        Car car1 = cars.get(0);

        //then
        if (car1.getForwardCount() != 0) {
            assertThat(car1.getForward()).contains("-");
        } else {
            assertThat(car1.getForward()).isEqualTo("");
        }
    }

    @Test
    void 우승자_선정() {
        //given
        List<Car> cars = gameConfig.createCars("pobi,woni,junki,code");
        cars.get(0).setForward("--");
        cars.get(1).setForward("---");
        cars.get(2).setForward("---");
        cars.get(3).setForward("-");

        //when
        List<String> winners = judgment.checkWinners(cars);

        //then
        assertThat(winners).contains("woni", "junki");
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
