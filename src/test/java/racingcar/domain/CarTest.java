package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @Test
    @DisplayName("자동차를 이름과 함께 생성한다")
    void create_car_with_name() {
        String carName = "";
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외를 던진다")
    void exception_if_car_name_length_over_5() {
        assertThatThrownBy(() -> new Car("kkkkkkk"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외를 던진다.")
    void exception_if_car_name_is_empty(){
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외를 던진다.")
    void exception_if_car_name_is_null(){
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차는 0에서 9 사이의 랜덤값을 생성한다")
    void car_make_random_number_between_0_to_9() {
        Car car = new Car("kyj");
        assertThat(car.randomSpeed()).isBetween(0, 9);
    }

    @Test
    @DisplayName("자동차가 움직일 수 있다.")
    void car_can_move(){
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}