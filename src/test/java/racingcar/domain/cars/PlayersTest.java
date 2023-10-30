package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.car.Car;

class PlayersTest {

    static final int MOVE_VALUE = 5;
    static final int DONT_MOVE_VALUE = 1;

    @Test
    @DisplayName("이름 리스트를 받아 생성할 수 있다.")
    void canConstructByNamesList() {
        // given
        List<String> names = Arrays.asList("kim", "tae", "Wan");

        // when
        Players players = new Players(names);

        // then
        assertThat(players.cars().size()).isEqualTo(3);
        assertThat(
            players.cars().stream()
                .map(Car::name)
                .collect(Collectors.toList())
        ).isEqualTo(names);
    }

    @Test
    @DisplayName("cars() 가 저장된 자동차들을 모두 반환한다.")
    void carsReturnAllSavedCars() {
        // given
        List<String> names = Arrays.asList("kim", "tae", "Wan");
        Players players = new Players(names);

        // when
        List<Car> cars = players.cars();

        // then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(
            cars.stream()
                .map(Car::name)
                .collect(Collectors.toList())
        ).isEqualTo(names);
    }

    @Test
    @DisplayName("moveAll() 호출 시 모든 자동차들이 조건에 맞춰 움직인다.")
    void allCarsMoveWithCondition_whenMoveAll() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);

        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
            .thenReturn(MOVE_VALUE, DONT_MOVE_VALUE);

        // when
        players.moveAll();

        // then
        assertThat(players.cars().get(0).movement().movement()).isEqualTo(1);
        assertThat(players.cars().get(1).movement().movement()).isEqualTo(0);

        mockedRandoms.close();
    }
}