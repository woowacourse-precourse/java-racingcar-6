package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarRepositoryTest {

    private final CarRepository carRepository = new CarRepository();

    @AfterEach
    public void clearRepository() {
        carRepository.deleteAll();
    }

    @ParameterizedTest
    @MethodSource("carNamesAndCount")
    void 경주차_여러개_생성하기(List<String> nameList, Integer expectedCount) {
        // given & when
        for(String name: nameList) {
            carRepository.save(name);
        }

        // then
        assertEquals(expectedCount, carRepository.getCarCount());
    }

    @ParameterizedTest
    @MethodSource("carNamesAndCount")
    void 경주차_여러개_생성하고_모두_조회하기(List<String> nameList, Integer expectedCount) {
        // given
        for(String name: nameList) {
            carRepository.save(name);
        }

        // when
        List<Car> carList = carRepository.findAll();

        // then
        assertThat(carList).hasSize(expectedCount)
            .extracting(Car::getName)
            .containsAll(nameList);
    }

    static Stream<Arguments> carNamesAndCount() {
        return Stream.of(
            Arguments.arguments(List.of("jongmi", "meoru"), 2),
            Arguments.arguments(List.of("gari"), 1),
            Arguments.arguments(List.of("gari", "meoru", "zzol"), 3)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 경주차_전진횟수_수정하기(int repetition) {
        // given
        Car car = carRepository.save("jongmi");

        // when
        for(int i = 0; i < repetition; i++) {
            car.updateForwardCount();
        }
        carRepository.update(car);

        // then
        Car updatedCar = carRepository.findById(car.getId());
        assertEquals(repetition, updatedCar.getForwardCount());
    }

    @Test
    void 중복되는이름의_경주차를_생성하면_예외발생시키기() {
        // given
        carRepository.save("meoru");

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carRepository.save("meoru");
        });
    }
}