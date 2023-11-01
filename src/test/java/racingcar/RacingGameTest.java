package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

  @Test
  void AddCar_메소드_정상동작_확인() {
    RacingGame racingGame = RacingGame.getInstance();
    Car carA = new Car("A");
    Car carB = new Car("B");
    racingGame.AddCar(carA);
    racingGame.AddCar(carB);

    assertThat(carA.getName()).isEqualTo("A");
    assertThat(carB.getName()).isEqualTo("B");
  }

}