package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Controller.RacingGameController;
import racingcar.Model.Car;
import racingcar.View.RacingGameView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class ApplicationTest extends NsTest {

    private RacingGameController controller;
    private RacingGameView view;


    @AfterEach
    void tearDown() {
        Mockito.framework().clearInlineMocks();
    }

    @BeforeEach
    void 설정() {
        RacingGameView view = new RacingGameView();
        List<String> carNames = Arrays.asList("car1", "car2");
        controller = new RacingGameController(carNames, view);
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
    void 전진_정지() {
        // Arrange
        Mockito.mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(4); // 임의의 값을 설정

        // Act
        controller.startGame(1);

        // Assert
        List<Car> cars = controller.getCars();
        assertThat(cars).hasSize(2);

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }

    }

    @Test
    void 우승자_찾기() {
        // Arrange
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Mockito.mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(4);

        car1.move();
        car2.move();
        car3.move();
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // Act
        List<String> winners = controller.findWinner(cars);

        // Assert
        assertThat(winners).containsExactly("car1", "car2", "car3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}