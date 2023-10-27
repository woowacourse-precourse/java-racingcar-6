package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;

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
    void 차_생성() {
        CarController carController = new CarController();
        List<Car> cars = carController.makeCar("talal,sun");
        assertSimpleTest(() -> {
                    assertThat(cars.get(0).getName()).isEqualTo("talal");
                    assertThat(cars.get(1).getName()).isEqualTo("sun");
                }
        );
    }

    @Test
    void 차_생성_중복_불필요() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_생성() {
        GameController gameController = new GameController();
        Game game = gameController.makeGame("2");
        assertThat(game.getMaxRoundNumber()).isEqualTo(2);
    }

    @Test
    void 라운드_숫자에_대한_예외_처리() {
        GameController gameController = new GameController();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> gameController.makeGame("가나다"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 승자_집계() {
        Car car1 = new Car("pobi");
        car1.addDistance(3, 4);
        Car car2 = new Car("bh");
        car2.addDistance(4, 4);

        GameController gameController = new GameController();

        Cars cars = new Cars(List.of(car1, car2));
        assertSimpleTest(() -> {
                    assertThat(gameController.score(cars)).isEqualTo("bh");
                }
        );
    }

    @Test
    void Car_GetName_테스트() {
        Car car1 = new Car("pobi");
        assertThat(car1.getName()).isEqualTo("pobi");
    }

    @Test
    void Car_AddDistance_전진_테스트() {
        Car car1 = new Car("pobi");
        car1.addDistance(5, 4);
        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car1.getDistanceLine()).isEqualTo("pobi : -");
    }

    @Test
    void Car_AddDistance_정지_테스트() {
        Car car1 = new Car("pobi");
        car1.addDistance(3, 4);
        assertThat(car1.getDistance()).isEqualTo(0);
        assertThat(car1.getDistanceLine()).isEqualTo("pobi : ");
    }

    @Test
    void Car_AddDistance_오류_테스트() {
        Car car1 = new Car("pobi");
        assertThatThrownBy(() -> car1.addDistance(10, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
