package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 테스트_전체_실행() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "우승자: pobi");
        }, 4, 3);
    }

    @Test
    void 자동차_이름_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,javaji", "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void 시도_횟수_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,woni", "0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 숫자_입력_예외_테스트() {
        assertThatThrownBy(() -> run("pobi,woni", "not_a_number"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바른 숫자를 입력하세요.");
    }

    @Test
    void 자동차_생성_테스트() {
        String[] carNames = { "pobi", "woni" };
        List<Car> cars = InputManager.initializeCars(carNames);

        assertThat(cars).hasSize(2);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void 경주_시작_테스트() {
        Car car = new Car("pobi");
        car.move();

        assertThat(car.getPosition()).isIn(0, 1);
    }

    @Test
    void 경주_결과_출력_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car2.move();

        OutputManager.printRoundResult(1, List.of(car1, car2));
        assertThat(output()).contains("실행 결과", "pobi : -", "woni : ");
    }

    @Test
    void 우승자_결정_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car2.move();

        List<Car> cars = List.of(car1, car2);
        List<Car> winners = RaceGame.getWinners(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
