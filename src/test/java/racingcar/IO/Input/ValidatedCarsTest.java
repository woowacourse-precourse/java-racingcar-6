package racingcar.IO.Input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.IO.Input.UnValidatedCars;
import racingcar.IO.Input.ValidatedCars;

class ValidatedCarsTest {

  @DisplayName("자동차 이름이 5자 이상일 때 예외처리")
  @Test
  void if_name_length_more_than_five_throw_exception() {
    // given
    UnValidatedCars unValidatedCars = UnValidatedCars.of("pooooo,zaa,zaaa");

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedCars.of(unValidatedCars));
  }

  @DisplayName("자동차 이름이 공백일 때 예외처리")
  @Test
  void if_name_is_empty_throw_exception() {
    // given
    UnValidatedCars unValidatedCars = UnValidatedCars.of("poo,,zaa,");

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedCars.of(unValidatedCars));
  }

  @DisplayName("자동차 이름이 화이트 스페이스일 때 예외처리")
  @Test
  void if_name_is_blank_throw_exception() {
    // given
    UnValidatedCars unValidatedCars = UnValidatedCars.of("poo, ,zaa,");

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedCars.of(unValidatedCars));
  }
}