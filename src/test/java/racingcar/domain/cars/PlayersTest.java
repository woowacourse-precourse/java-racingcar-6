package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovement;

class PlayersTest {

    static final int MOVE_VALUE = 5;

    MockedStatic<Randoms> randoms;

    @BeforeEach
    void setUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void close() {
        randoms.close();
    }

    @Test
    @DisplayName("이름 리스트를 받아 생성할 수 있다.")
    void canConstructByNamesList() {
        // given
        List<String> names = Arrays.asList("kim", "tae", "Wan");

        // when
        Players players = new Players(names);

        // then
        assertThat(players.cars().size()).isEqualTo(3);
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
        assertThat(cars.get(0).name()).isEqualTo(names.get(0));
        assertThat(cars.get(1).name()).isEqualTo(names.get(1));
        assertThat(cars.get(2).name()).isEqualTo(names.get(2));
    }

    @Test
    @DisplayName("moveAll() 호출 시 모든 자동차들이 조건에 맞춰 움직인다.")
    void allCarsMoveWithCondition_whenMoveAll() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);

        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVE_VALUE);

        CarMovement expectedMovement = new CarMovement();
        expectedMovement.goForward();

        // when
        players.moveAll();

        // then
        assertThat(players.cars().get(0).movement()).isEqualTo(expectedMovement);
        assertThat(players.cars().get(1).movement()).isEqualTo(expectedMovement);
    }

    @Test
    @DisplayName("toString() 이 자동차들의 현재 진행 상황을 담은 문자열을 반환한다.")
    void toStringReturnCurrentRacingState() {
        // given
        List<String> names = Arrays.asList("tae", "wan");
        Players players = new Players(names);

        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVE_VALUE);

        players.moveAll();
        players.moveAll();

        String expectedMessage = "tae : --\nwan : --";

        // when
        String message = players.toString();

        // then
        assertThat(message).isEqualTo(expectedMessage);
    }
}