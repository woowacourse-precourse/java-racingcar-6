package racingcar.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Location;
import racingcar.model.RacingNumber;

public class LocationTest {

    @Test
    @DisplayName("한칸 앞으로 전진한다_숫자가 4 이상일 경우")
    void move_moreThan4() {
        RacingNumber testNumber = new TestNumber(5);
        Location location = new Location(testNumber);

        location.stopOrMove();

        Assertions.assertThat(location.getLocationLength())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("가만히 있는다_숫자가 4 미만일 경우")
    void stop_lessThan4() {
        RacingNumber testNumber = new TestNumber(3);
        Location location = new Location(testNumber);

        location.stopOrMove();

        Assertions.assertThat(location.getLocationLength())
                .isEqualTo(0);
    }
}
