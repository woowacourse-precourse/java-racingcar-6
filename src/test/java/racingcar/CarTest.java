package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 생성하기")
    void newCar(){
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("자동차 이름 Null이면 예외")
    void validateNull() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null을 입력하지 마세요.");
    }
    @Test
    @DisplayName("자동차 이름의 길이가 0이면 예외")
    void validateLengthZero(){
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이를 0보다 크게 입력하셔야 합니다.");
    }
    @Test
    @DisplayName("자동차 이름의 길이가 5를 넘으면 예외")
    void validateLengthUnderFive(){
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이를 5이하로 입력해주세요.");
    }

    @Test
    void 자동차_이름_가져오기(){
        Car car = new Car("car");
        assertThat(car.getName()).isEqualTo("car");
    }
    @Test
    @DisplayName("자동차 움직임 테스트")
    void move(){
        Car car = new Car("car");
        int randomNumber = car.getRandomNumber();
        car.move(randomNumber);
        if(randomNumber<4){
            assertThat(car.getPosition()).isEqualTo(0);
        }
        if(randomNumber>=4){
            assertThat(car.getPosition()).isEqualTo(1);

        }
    }
    @Test
    void 랜덤값_뽑기(){
        Car car = new Car("car");
        int randomNumber = car.getRandomNumber();
        System.out.println(randomNumber);
    }
    @Test
    void 자동차_위치_문자열_반환() {
        Car car = new Car("car");
        car.move(4);
        car.move(4);
        assertThat(car.getPositionString()).isEqualTo("--");
    }
}