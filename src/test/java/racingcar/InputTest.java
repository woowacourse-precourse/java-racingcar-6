package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
  @Test
  void 이름에_대한_예외_처리_5자초과() {
    assertThatThrownBy(() -> new Car("aa,bb,ccccc"))
      .isInstanceOf(IllegalArgumentException.class);
  }
  @Test
  void 이름에_대한_예외_처리_공백() {
    assertThatThrownBy(() -> new Car("aa,bb,,cc,dd"))
      .isInstanceOf(IllegalArgumentException.class);
  }
  @Test
  void 이름에_대한_예외_처리_중복입력() {
    assertThatThrownBy(() -> new Car("aa,bb,cc,aa"))
      .isInstanceOf(IllegalArgumentException.class);
  }
}