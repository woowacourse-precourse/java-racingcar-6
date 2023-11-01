package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.MockedStatic.Verification;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;

@DisplayName("Racing 도메인 테스트")
class RacingTest {

    @Test
    void 사용자가_입력한_이름으로_자동차_생성() {
        // given
        Racing racing = new Racing();
        List<String> carsName = List.of("car A", "car B");

        // when
        racing.generateCars(carsName);

        // then
        List<Car> cars = racing.getCars();
        Assertions.assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars).hasSize(carsName.size()),
                () -> assertThat(cars.get(0).getName()).isEqualTo(carsName.get(0))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 자동차_전진(int randomNumber) {
        // given
        Racing racing = new Racing();
        racing.generateCars(List.of("Car A"));

        // when
        Executable executable = randomNumberMockTest(randomNumber, () -> {
            racing.runRace();
            List<Car> cars = racing.getCars();
            assertThat(cars.get(0).getForwardStep()).isEqualTo(1);
        });

        // then
        Assertions.assertDoesNotThrow(executable);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void 자동차_정지(int randomNumber) {
        // given
        Racing racing = new Racing();
        racing.generateCars(List.of("Car A"));

        // when
        Executable executable = randomNumberMockTest(randomNumber, () -> {
            racing.runRace();
            List<Car> cars = racing.getCars();
            assertThat(cars.get(0).getForwardStep()).isEqualTo(0);
        });

        // then
        Assertions.assertDoesNotThrow(executable);
    }

    private Executable randomNumberMockTest(int randomNumber, Executable executable) {
        return () -> {
            try (MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
                Verification verification = () -> Randoms.pickNumberInRange(anyInt(), anyInt());
                mockRandoms.when(verification).thenReturn(randomNumber);

                executable.execute();
            }
        };
    }

    @Test
    void 최종_우승자_선정() {
        // given
        Racing racing = new Racing();
        racing.generateCars(List.of("Car A", "Car B", "Car C"));

        Car carA = racing.getCars().get(0);
        carA.moveForward();
        Car carC = racing.getCars().get(2);
        carC.moveForward();

        // when
        List<Car> winingCars = racing.getWiningCars();

        // then
        Assertions.assertAll(
                () -> assertThat(winingCars).hasSize(2),
                () -> assertThat(winingCars).containsAll(List.of(carA, carC))
        );
    }

    @Test
    void 자동차_이름_중복_검증() {
        // given & when & then
        assertThatThrownBy(() -> new Racing().generateCars(List.of("Car", "Car")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름입니다.");
    }
}