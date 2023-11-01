package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import racingcar.model.Car;

public class CarListTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static Stream<Arguments> provideCarList() {
        final CarList carList = CarListFactory.create("pobi, woni, jun");
        final CarList sameOther = CarListFactory.create("pobi, woni, jun");

        return Stream.of(
                Arguments.of(carList, null, false),
                Arguments.of(carList, carList, true),
                Arguments.of(carList, List.of(""), false),
                Arguments.of(carList, sameOther, true)
        );
    }

    @Test
    void getCarList_메소드_변경_불가능한_목록_반환() {
        final CarList carList = CarListFactory.create("pobi, woni, jun");
        final List<Car> unModifiableCarList = carList.getCarList();

        assertThatThrownBy(() -> unModifiableCarList.set(0, null))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("한 횟수 동안 N 대의 자동차는 전진 또는 멈춘다.")
    void Car_리스트_안에_있는_모든_Car를_앞으로_움직임() {
        final CarList carList = CarListFactory.create("pobi, woni, jun");
        final List<Integer> expected = List.of(1, 1, 0);

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            carList.moveForward();

            final List<Integer> actual = carList.getCarList()
                    .stream()
                    .map(Car::getDistance)
                    .collect(Collectors.toList());

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void Car_리스트_안에서_가장_멀리_간_Car_목록_생성() {
        final List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        final CarList carList = CarListFactory.create(cars);
        final List<Car> expected = List.of(cars.get(0), cars.get(1));

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            carList.moveForward();
            final List<Car> actual = carList.getCarListWithLongestDistance();

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void Car_리스트에서_최종_우승자_이름_목록_생성() {
        final CarList carList = CarListFactory.create("pobi, woni, jun");
        final String expected = "pobi, woni";

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            carList.moveForward();
            final String actual = carList.getWinners();

            assertThat(actual).isEqualTo(expected);
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarList")
    void equals_메소드_순서대로_같은_이름을_가진_CarList_일때_True_반환(final CarList carList, final Object other, boolean expected) {
        final boolean actual = carList.equals(other);
        assertThat(actual).isEqualTo(expected);
    }
}
