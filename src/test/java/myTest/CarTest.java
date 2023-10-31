package myTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.view.Player;

public class CarTest extends NsTest{
    
    @Test
    void 중복된_자동차_이름이_존재하는_경우() {
        List<String> names = List.of("pobi", "pobi", "theo");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 자동차가_한대만_입력되면() {
        List<String> names = List.of("1");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승한_자동차가_없을때() {
        Map<String, Integer> score = new HashMap<>();

        Racing racing = new Racing((HashMap<String, Integer>) score);

        assertThatThrownBy(() -> racing.findWinners())
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    void 자동차_이름_5초과(String input) {
        assertThatThrownBy(() ->  new Cars(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 자동차_이름_1미만(String input) {
        assertThatThrownBy(() ->  new Cars(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 랜덤_수가_4미만일때_멈춤() {
        Car car = new Car("pobi");

        car.moveForward(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이름 세미콜론(;) 문자열 분리가 잘 되는지")
    @Test
    void splitWithSemicolon() {
        List<String> input = List.of("pobo;ba;yo"); // 세미콜론으로 구분
        String names = String.join(",", input);

        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
