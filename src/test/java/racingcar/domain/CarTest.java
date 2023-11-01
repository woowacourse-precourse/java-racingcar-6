package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {
  Car car = new Car("빵빵이");

  @Test
  void Car_객체의_이름은_생성자의_인자로_결정된다() {
    assertThat(car.getName()).isEqualTo("빵빵이");
  }

  @Test
  void Car_객체의_이름은_앞_뒤_공백을_제거한_값이다() {
    Car testCar = new Car(" 방방이 ");
    assertThat(testCar.getName()).isEqualTo("방방이");
  }

  @Test
  void move_메소드는_자동차가_이동하고난_뒤의_위치를_반환한다() {
    //given
    int position = car.getPosition();

    //when
    car.move();

    //then
    assertThat(car.getPosition())
            .isEqualTo(position + 1);
  }

  @Test
  void Car_객체의_이름이_5자_이하가_아니면_예외() {
    assertThatThrownBy(() -> {
      new Car("dfdfde");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void Car_객체의_이름이_빈값이거나_NULL이면_예외() {
    assertThatThrownBy(() -> {
      new Car("");
      new Car(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}