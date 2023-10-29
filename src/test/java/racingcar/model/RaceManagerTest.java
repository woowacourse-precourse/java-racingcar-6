package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceManagerTest {

    @ParameterizedTest
    @DisplayName("입력값의 유효성 테스트")
    @ValueSource(strings = {"", "-1", "fjk"})
    public void 이동_횟수_유효성검증_테스트(String playerInput) {
        //then
        assertThatThrownBy(() -> RaceManager.validateNumberOfMove(playerInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승자_한명_테스트() {
        //given
        Car car1 = new Car("gyuwon");
        Car car2 = new Car("pobbi");
        Car car3 = new Car("wendy");

        //when
        for (int i = 4; i < 10; i++) {
            car1.moveOrStop(i);
            car2.moveOrStop(i - 1);
            car3.moveOrStop(i - 2);
        }

        //then
        assertThat(RaceManager.decideWinner(List.of(car1, car2, car3)))
                .isEqualTo(List.of(car1.getNameForTest()));
    }

    @Test
    public void 우승자_두명_테스트() {
        //given
        Car car1 = new Car("gyuwon");
        Car car2 = new Car("pobbi");
        Car car3 = new Car("wendy");

        //when
        for (int i = 1; i < 10; i++) {
            car1.moveOrStop(i);
            car2.moveOrStop(i);
            car3.moveOrStop(i - 1);
        }

        //then
        assertThat(RaceManager.decideWinner(List.of(car1, car2, car3)))
                .isEqualTo(List.of(car1.getNameForTest(), car2.getNameForTest()));
    }
}
