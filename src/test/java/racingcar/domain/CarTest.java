package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private String name1;
    private String name2;


    @BeforeEach
    public void setUp() {
        name1 = "pobi";
        name2 = "jason";
    }

    @DisplayName("Car 생성")
    @Test
    public void createCar() throws Exception {
        //given
        String name = "pobi";

        //when
        Car Car = new Car(name);

        //then
        assertThat(Car.getName()).isEqualTo(name);
     }

    @DisplayName("Car 생성 예외 : Car 이름이 공백이면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\n\t"})
    public void createCar_exception_empty(String empty) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Car(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("내용이 없는 빈 자동차 이름은 사용할 수 없습니다.");
    }

    @DisplayName("Car 생성 예외 : Car 이름이 5자를 초과하면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"pobi12","jasonn","1234567"})
    public void createCar_exception_nameLength(String tooLongName) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Car(tooLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("Car eqauls 동작 확인 : 이름이 같으면 같은 Car이다.")
    @Test
    public void createCar_equals_true() throws Exception {
        //given, when
        Car car1 = new Car(name1);
        Car car2 = new Car(name1);

        //then
        assertThat(car1).isEqualTo(car2);
    }

    @DisplayName("Car eqauls 동작 확인 : 이름이 다르면 다른 Car이다.")
    @Test
    public void createCar_equals_false() throws Exception {
        //given, when
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        //then
        assertThat(car1).isNotEqualTo(car2);
    }

    @DisplayName("Car 이동 : 생성된 숫자가 4 이상일 경우 이동")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveCar_whenValue_up4(int movableValue) throws Exception {
        //given
        int repeat = 3;
        Car car = new Car(name1);

        //when
        for (int i = 0; i < repeat; i++) {
            car.tryToMove(() -> movableValue);
        }

        //then
        assertThat(car.getDistance()).isEqualTo(repeat);
    }

    @DisplayName("Car 멈춤 : 숫자가 4 미만일 경우 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void stopCar_whenValue_down4(int stopValue) throws Exception {
        //given
        int repeat = 3;
        Car car = new Car(name1);

        //when
        for (int i = 0; i < repeat; i++) {
            car.tryToMove(() -> stopValue);
        }

        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
