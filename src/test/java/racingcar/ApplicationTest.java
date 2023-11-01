package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Controller.RacingGameController;
import racingcar.Model.Car;
import racingcar.View.RacingGameView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_테스트() {
        RacingGameView view = new RacingGameView();
        String[] carNames = {"verylongcarname", "short"};
        assertThatThrownBy(() -> new RacingGameController(Arrays.asList(carNames), view))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }


    @Test
    void 게임_횟수_음수_테스트() {
        RacingGameController controller = new RacingGameController(Arrays.asList("pobi", "woni"), new RacingGameView());

        assertThatThrownBy(() -> controller.startGame(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 랜덤_값_테스트() {
        RacingGameView view = new RacingGameView();
        String[] carNames = {"car1", "car2"};
        RacingGameController controller = new RacingGameController(Arrays.asList(carNames), view);

        Mockito.mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(4);

        controller.startGame(1);

    }


    @Test
    void 우승자_찾기_테스트() {
        // Arrange
        RacingGameView view = new RacingGameView();
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("crong"));
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        RacingGameController controller = new RacingGameController(carNames, view);

        // Act
        for (int i = 0; i < 5; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
        List<String> winners = controller.findWinner(cars);

        assertThat(winners).containsAnyOf("pobi", "woni", "crong");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}