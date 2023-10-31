package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private Cars testCars;
    private Car testCar;

    @BeforeEach
    void setUp() {
        String testCarName1 = "pobi";
        String testCarName2 = "woni";
        Car testCar1 = new Car(testCarName1);
        Car testCar2 = new Car(testCarName2);
        testCars = new Cars(new ArrayList<>(List.of(testCar1, testCar2)));

        String testCarName3 = "bang";
        testCar = new Car(testCarName3);
    }

    @Test
    void 자동차_이동_테스트() {
        testCars.moveAll(() -> true);

        assertThat(testCars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(testCars.getCars().get(1).getPosition()).isEqualTo(1);
    }

    @Test
    void 공동_우승자_찾기_테스트() {
        testCars.moveAll(() -> true);

        assertThat(testCars.findWinners().size()).isEqualTo(2);
        assertThat(testCars.findWinners().get(0).getName()).isEqualTo("pobi");
        assertThat(testCars.findWinners().get(1).getName()).isEqualTo("woni");
    }

    @Test
    void 한_명의_우승자_찾기_테스트() {
        testCars.moveAll(new MoveStrategy() {
            int moveCount = 0;

            @Override
            public boolean isAbleToMove() {
                moveCount++;
                return moveCount == 1;
            }
        });

        assertThat(testCars.findWinners().size()).isEqualTo(1);
        assertThat(testCars.findWinners().get(0).getName()).isEqualTo("pobi");
    }

    @Test
    void 반환된_자동차_목록_수정할_때_예외_발생() {
        assertThatThrownBy(() -> testCars.getCars().add(testCar))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 반환된_우승자_목록_수정할_때_예외_발생() {
        assertThatThrownBy(() -> testCars.findWinners().add(testCar))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}