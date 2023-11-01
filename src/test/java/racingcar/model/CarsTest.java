package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.RacingCarGameUtils;

class CarsTest {

  @Test
  @DisplayName("[Success] 유효한 Car 이름들로 Cars를 생성합니다. ")
  void 유효한_차_이름들로_생성() {
    // given
    String validCarNames = "우,테,코,재,밌,다";

    // when && then
    assertDoesNotThrow(
        () -> Cars.createFromCarNames(RacingCarGameUtils.convertStringToList(validCarNames)));
  }

  @ParameterizedTest
  @DisplayName("[Success] 위치에 따라 우승자를 판별")
  @CsvSource({"1,2,3,Car3", "1,3,3,'Car2, Car3'"})
  void testWinnersByDistance(int location1, int location2, int location3, String expectedWinner) {
    // given
    Car car1 = Car.from(new CarName("Car1"), new Location(location1));
    Car car2 = Car.from(new CarName("Car2"), new Location(location2));
    Car car3 = Car.from(new CarName("Car3"), new Location(location3));

    // when
    Cars carsList = Cars.createCarsFromList(Arrays.asList(car1, car2, car3));

    // then
    Assertions.assertThat(carsList.getWinnerByDistance()).isEqualTo(expectedWinner);
  }
}