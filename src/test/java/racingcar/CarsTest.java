package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsTest {
    public static final String 포비 = "pobi";
    public static final String 워니 = "woni";
    public static final String 준 = "jun";
    public static final String 콤마 = ",";

    @Test
    @DisplayName("주어진 자동차 문자열에서 콤마기준으로 구분하여 자동차 리스트를 반환한다")
    void 주어진_자동차_문자열에서_자동차_리스트를_반환한다() {
        Cars cars = new Cars(포비 + 콤마 + 워니 + 콤마 + 준);

        assertThat(cars.getCars())
                .extracting("name")
                .containsExactly(포비, 워니, 준);
    }

    @Test
    @DisplayName("자동차 목록에서 최대 이동 횟수를 반환한다")
    void 자동차목록에서_최대이동횟수를_반환한다() {
        Cars cars = new Cars();

        int maxMovingCount = cars.getMaxMovingCount(Arrays.asList(
                new Car(포비, 1),
                new Car(워니, 2),
                new Car(준, 3)
        ));

        assertThat(maxMovingCount).isEqualTo(3);
    }

    @Test
    @DisplayName("최종우승자를 반환한다(1명)")
    void 최종우승자를_반환한다() {
        Cars cars = new Cars();

        List<String> winners = cars.getWinners(Arrays.asList(
                new Car(포비, 3)
                , new Car(워니, 2)
                , new Car(준, 1)));

        assertThat(winners)
                .containsExactly(포비);
    }

    @Test
    @DisplayName("최종우승자를 반환한다(2명이상)")
    void 최종우승자를_반환한다_2명이상() {
        Cars cars = new Cars();

        List<String> winners = cars.getWinners(Arrays.asList(
                new Car(포비, 3)
                , new Car(워니, 3)
                , new Car(준, 1)));

        assertThat(winners)
                .containsExactly(포비, 워니);
    }
}
