package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarListTest {
  List<Car> duplicatedCars = List.of(
          new Car("jiyun"),
          new Car("jiyun"),
          new Car("yunyu")
  );

  @Test
  void CarList가_중복된_이름의_Car를_가질경우_예외() {
    Assertions.assertThatThrownBy(() -> new CarList(duplicatedCars))
            .isInstanceOf(IllegalArgumentException.class);
  }
}