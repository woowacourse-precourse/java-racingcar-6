package racingcar.Input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatedCarsTest {

  @DisplayName("자동차 이름이 5자 이상일 때 예외처리")
  @Test
  void if_name_length_more_than_five_throw_exception() {
    // given
    UnValidatedCars unValidatedCars = UnValidatedCars.of(List.of("poo0000", "zoo", "zaa"));

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedCars.of(unValidatedCars));
  }

  @DisplayName("자동차 이름이 공백일 때 예외처리")
  @Test
  void if_name_is_empty_throw_exception() {
    // given
    UnValidatedCars unValidatedCars = UnValidatedCars.of(List.of("poo", "", "zaa"));

    // when && then
    assertThrows(IllegalArgumentException.class, () -> ValidatedCars.of(unValidatedCars));
  }
}