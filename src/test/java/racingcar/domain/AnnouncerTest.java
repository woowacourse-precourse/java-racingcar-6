package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnnouncerTest {
    private Announcer announcer;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        announcer = new Announcer();
        car1 = new Car("pobi");
        car2 = new Car("jun");
    }

    @Test
    @DisplayName("우승자 발표 기능 테스트")
    void displayWinner_우승자_발표_기능_테스트() {
        List<Car> winner = Arrays.asList(car1, car2);

        StringBuffer actual = announcer.displayWinner(winner);

        assertThat(actual.toString())
                .isEqualTo("최종 우승자 : pobi, jun");
    }

    @Test
    @DisplayName("우승자 발표 기능 테스트 (솔로우승)")
    void displayWinner_우승자_발표_기능_테스트_솔로우승() {
        List<Car> winner = Arrays.asList(car1);

        StringBuffer actual = announcer.displayWinner(winner);

        assertThat(actual.toString())
                .isEqualTo("최종 우승자 : pobi");
    }
}