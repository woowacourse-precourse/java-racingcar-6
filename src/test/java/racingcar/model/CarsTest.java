package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingCarGameUtils;

class CarsTest {

  @Test
  @DisplayName("[Success] 유효한 Car 이름들로 Cars를 생성합니다. ")
  void 유효한_차_이름들로_생성() {
    // given
    String validStr = "우,테,코,재,밌,다";
    // when && then
    assertDoesNotThrow(
        () -> Cars.createFromCarNames(RacingCarGameUtils.convertStringToList(validStr)));
  }

  @Test
  @DisplayName("[Success] 위치가 가장 큰 차가 우승자입니다.(단독)")
  void Location_위치에_따라_단독_우승자를_판별() {
    // given
    Car car1 = Car.from(new CarName("Car1"), new Location(1));
    Car car2 = Car.from(new CarName("Car2"), new Location(2));
    Car car3 = Car.from(new CarName("Car3"), new Location(3));

    // when && then
    Cars carsList = Cars.createCarsFromList(Arrays.asList(car1, car2, car3));

    Assertions.assertThat(carsList.getWinnerByDistance()).isEqualTo("Car3");
  }

  @Test
  @DisplayName("[Success] 위치가 가장 큰 차가 우승자입니다.(공동)")
  void Location_위치에_따라_공동_우승자를_판별() {
    // given
    Car car1 = Car.from(new CarName("Car1"), new Location(1));
    Car car2 = Car.from(new CarName("Car2"), new Location(3));
    Car car3 = Car.from(new CarName("Car3"), new Location(3));

    // when && then
    Cars carsList = Cars.createCarsFromList(Arrays.asList(car1, car2, car3));

    Assertions.assertThat(carsList.getWinnerByDistance()).isEqualTo("Car2, Car3");
  }
}