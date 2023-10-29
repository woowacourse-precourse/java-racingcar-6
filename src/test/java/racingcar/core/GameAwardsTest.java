package racingcar.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameAwardsTest {
    private GameAwards gameAwards;
    private WinnerCheckSystem winnerCheckSystem;

    public GameAwardsTest() {
        this.winnerCheckSystem = new WinnerCheckSystem();;
    }
    @BeforeEach
    void before() {
        gameAwards = new GameAwards(winnerCheckSystem);
    }
    @Test
    @DisplayName("우승자 이름을 잘 가져오는지")
    void 우승자_이름을_잘_가져오는지() throws Exception {
        //given
        List<Car> cars = getCars();
        //when
        List<String> names = gameAwards.getNames(cars);
        //then
        assertThat(names.size()).isEqualTo(3);
        assertThat(names).containsExactly("이름1", "이름2", "이름3");
    }

    private static List<Car> getCars() {
        Car car1 = new Car("이름1");
        Car car2 = new Car("이름2");
        Car car3 = new Car("이름3");
        return List.of(car1, car2, car3);
    }

}