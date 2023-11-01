package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    private String name1;

    private String name2;

    private String name3;

    @BeforeEach
    public void setUp() {
        name1 = "pobi";
        name2 = "jason";
        name3 = "hihi";
    }

    @DisplayName("Cars 생성")
    @Test
    public void createCars() throws Exception {
        //when
        Cars cars = new Cars(List.of(name1, name2, name3));
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList).containsExactly(
                new Car(name1), new Car(name2), new Car(name3)
        );
    }

    @DisplayName("Cars 생성 예외 : Car 이름에 공백만 존재하는 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\n\t"})
    public void createCars_exception_empty(String empty) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Cars(List.of(name1, name2, empty)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("내용이 없는 빈 자동차 이름은 사용할 수 없습니다.");
    }

    @DisplayName("Cars 생성 예외 : Car 이름이 5자를 초과하면 IllegalArgumentException 발생")
    @Test
    public void createCars_exception_nameLength() throws Exception {
        // given
        String tooLongName = "I'm long name";

        //when, then
        assertThatThrownBy(() -> new Cars(List.of(name1, name2, tooLongName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("Cars 생성 예외 : Car 이름이 중복되면 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource({"pobi,pobi,3", "pobi,pobi  ,3", "pobi,3,pobi", "3,pobi,pobi"})
    public void createCars_exception_nameDuplicated() throws Exception {
        //when, then
        assertThatThrownBy(() -> new Cars(List.of(name1, name1, name3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 이름이 존재합니다.");
    }

    @DisplayName("Cars 모든 Car 이동 : 생성된 숫자가 4 이상일 경우 모두 이동")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveCar_whenValue_up4(int movableValue) throws Exception {
        //given
        int repeat = 3;
        Cars cars = new Cars(List.of(name1, name2, name3));

        //when
        for (int i = 0; i < repeat; i++) {
            cars.tryToMove(() -> movableValue);
        }

        //then
        cars.getCars().stream()
                .forEach((car) -> assertThat(
                        car.getDistance()).isEqualTo(repeat)
                );
    }

    @DisplayName("Cars 모든 Car 멈춤 : 생성된 숫자가 4 미만일 경우 모두 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void stopCar_whenValue_down4(int stopValue) throws Exception {
        //given
        int repeat = 3;
        Cars cars = new Cars(List.of(name1, name2, name3));

        //when
        for (int i = 0; i < repeat; i++) {
            cars.tryToMove(() -> stopValue);
        }

        //then
        cars.getCars().stream()
                .forEach((car) -> assertThat(
                        car.getDistance()).isEqualTo(0)
                );
    }

    @DisplayName("Cars 랜덤 이동 : 모든 Car들이 반복 범위 안에 존재")
    @Test
    public void moveCarInRandom() throws Exception {
        //given
        int repeat = 3;
        Cars cars = new Cars(List.of(name1, name2, name3));
        RandomMovingStrategy movingStrategy = new RandomMovingStrategy();

        //when
        for (int i = 0; i < repeat; i++) {
            cars.tryToMove(movingStrategy);
        }

        //then
        cars.getCars().stream()
                .forEach((car) -> assertThat(
                        car.getDistance()).isBetween(0, repeat)
                );
    }

    @DisplayName("Cars 이동결과 toString() 메시지 일치 확인")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveResult_whenMove(int movableValue) throws Exception {
        //given
        int repeat = 3;

        Cars cars = new Cars(List.of(name1, name2, name3));

        //when
        for (int i = 0; i < repeat; i++) {
            cars.tryToMove(() -> movableValue);
        }

        //then
        assertThat(cars.toString()).isEqualTo(
                name1 + " : ---\n" +
                        name2 + " : ---\n" +
                        name3 + " : ---"
        );
    }
}
