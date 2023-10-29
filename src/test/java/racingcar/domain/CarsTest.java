package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Utils;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        List<String> nameList = List.of("pobi", "lee", "kim");
        cars = new Cars();
        cars.makeCars(nameList);
    }

    @DisplayName("입력값을 기반으로 자동차를 생성한다.")
    @Test
    void makeCars() {
        // given, when
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList.size()).isEqualTo(3);
    }

    @DisplayName("getter 호출 시 깊은 복사로 반환한다.")
    @Test
    void getCars() {
        // given, when
        List<Car> carList = cars.getCars();

        // then
        assertNotSame(cars.getCars(), carList);
    }

    @DisplayName("자동차가 랜덤 숫자에 따라 움직이거나 멈춘다.")
    @Test
    void moveCars() {
        // given
        List<Integer> resultDistance = List.of(1,1,0);
        mockStatic(Utils.class);
        when(Utils.makeRandomNumber()).thenReturn(7,5, 2);

        // when
        cars.moveCars();
        List<Car> carList = cars.getCars();

        // then
        IntStream.range(0, carList.size())
                .forEach(i -> {
                    Car car = carList.get(i);
                    assertThat(car.getDistance()).isEqualTo(resultDistance.get(i));
                });
    }

    @DisplayName("")
    @Test
    void findWinner() {
        // given
        mockStatic(Utils.class);
        when(Utils.makeRandomNumber()).thenReturn(7,5, 6, 8, 6, 2, 9, 1, 0);
        for(int i=0; i<3; i++) { cars.moveCars(); }

        // when
        List<String> winnerList = cars.findWinner();

        // then
        assertThat(winnerList.get(0)).isEqualTo("pobi");
    }
}