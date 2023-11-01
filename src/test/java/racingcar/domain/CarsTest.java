package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Cars.createNewCars;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final int MOVE_THRESHOLD = 4;
    private List<String> carNames;

    @BeforeEach
    void beforeEach() {
        carNames = new ArrayList<>();
    }

    @Test
    void 스트링_리스트로_생성자_호출() {
        carNames.add("a");
        carNames.add("b");
        carNames.add("c");

        Cars cars = createNewCars(carNames);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void 중복된_이름_존재시_생성_실패() {
        carNames.add("a");
        carNames.add("a");
        carNames.add("c");

        assertThatThrownBy(() -> {
            createNewCars(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름 삽입 불가");
    }

    @Test
    void 경기_참여_차_0대일시_우승자_탐색_실패() {
        Cars cars = createNewCars(carNames);

        assertThatThrownBy(() -> {
            cars.findWinners();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 개수는 1개 이상이어야 함");
    }

    @Test
    void 우승자_1명_탐색() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = createNewCars(carNames);
            Car singleWinner = Car.createNewCar("a");
            singleWinner.updateDistance();
            cars.insert(singleWinner);

            assertThat(cars.findWinners().size()).isEqualTo(1);
            assertThat(cars.findWinners().get(0)).isEqualTo("a");
        }, MOVE_THRESHOLD);
    }

    @Test
    void 우승자_여러명_탐색() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = createNewCars(carNames);
            Car winnerOne = Car.createNewCar("a");
            Car winnerTwo = Car.createNewCar("b");
            Car winnerThree = Car.createNewCar("c");

            winnerOne.updateDistance();
            winnerTwo.updateDistance();
            winnerThree.updateDistance();

            cars.insert(winnerOne);
            cars.insert(winnerTwo);
            cars.insert(winnerThree);

            assertThat(cars.findWinners().size()).isEqualTo(3);
        }, MOVE_THRESHOLD);
    }

}