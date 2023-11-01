package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnnouncerTest {

    @Test
    @DisplayName("우승자 발표 기능 테스트")
    void displayWinner_우승자_발표_기능_테스트() {
        Announcer announcer = new Announcer();
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");
        List<Car> winner = Arrays.asList(car1, car2);

        StringBuffer actual = announcer.displayWinner(winner);

        assertThat(actual.toString())
                .isEqualTo(new StringBuffer("최종 우승자 : pobi, jun").toString());
    }
}