package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.exception.ExceptionMessage;
import racingcar.player.Player;

class RacingCarGameTest {

    private Car car;
    private Player player;

    @BeforeEach
    void setUp() {
        car = new Car();
        player = new Player();
    }

    @ParameterizedTest
    @CsvSource({"'ham,torri','ham'", "'pika,king','king'", "'lion,cute,angel','angel'"})
    void createName_메서드_사용시_경주할_자동차_이름을_반환(String name, String expected) {
        car.createName(name);

        List<String> actual = car.getNames();

        assertThat(actual).contains(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"내가짱이야양", "짬뽕국물맛있겠다", "우테코가즈아!"})
    void createName_메서드_사용시_이름이_5자_초과_예외_발생(String name) {
        assertThatThrownBy(
                () -> car.createName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NAME_OF_RANGE);
    }

    @Test
    void driving_메서드_사용시_전진_또는_멈춤_수행_최소_최대_주행_확인() {
        car.createName("ooo,ppp,ccc");
        car.driving();

        Collection<Integer> drivingValues = car.getValues();

        int max = Collections.max(drivingValues);
        int min = Collections.min(drivingValues);

        System.out.println("최대 전진 수: " + max + "\n" + "최소 전진 수: " + min);
    }

    @Test
    void winnerList_메서드_사용시_우승자_명단_반환() {
        car.createName("Alex,Lux,Jinx");

        List<String> result = car.winnerList();

        assertThat(result).contains("Alex", "Lux", "Jinx");
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    void moveOnInput_메서드_사용시_경기_시도할_횟수_반환(String tryCount, int expected) {
        player.moveOnInput(tryCount);

        int actual = player.getCount();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "hello", "오잉?", "%"})
    void moveOnInput_메서드_사용시_0보다_큰_정수_아닐_때_예외_발생(String tryCount) {
        assertThatThrownBy(
                () -> player.moveOnInput(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MOVE_OF_RANGE);
    }
}
