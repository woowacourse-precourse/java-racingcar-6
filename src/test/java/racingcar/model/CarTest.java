package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setup() {
        car = Car.withName("gyuwon");
    }

    @RepeatedTest(value = 1000)
    public void 랜덤값_생성_테스트() {
        //when
        int randomNumber = car.generateRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 정지_테스트(int randomNumber) {
        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 이동_테스트(int randomNumber) {
        //when
        car.moveOrStop(randomNumber);

        //then
        assertThat(car.getLocation()).isEqualTo(1);
    }

//    @ParameterizedTest
//    @DisplayName("자동차 이름 List를 통해 자동차들을 생성")
//    @MethodSource("carNameListProvider")
//    public void 자동차들_생성(List<String> carNameList) {
//        //when
//        List<Car> actualCarList = CarNames.createCars(carNameList);
//
//        //then
//        List<String> actualCarNameList = actualCarList.stream()
//                .map(Car::getName).toList();
//
//        assertThat(actualCarNameList).isEqualTo(carNameList);
//    }

    static Stream<Arguments> carNameListProvider() {
        return Stream.of(
                Arguments.arguments(List.of("")),
                Arguments.arguments(List.of("", "pobbi", "wonni")),
                Arguments.arguments(List.of("pobbii", "wonni", "jun")),
                Arguments.arguments(List.of("pobi", "wonni", "pobi"))
        );
    }
}
