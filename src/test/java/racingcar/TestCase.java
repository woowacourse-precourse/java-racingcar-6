package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCase {
    @Test
    void 주어진_값을_구분() {
        String input = "ab,cd,df";
        Cars cars = new Cars(input);
        List<String> result = cars.carList;
        assertThat(result).contains("ab","cd","df");
    }

    @Test
    void 공백_포함시_예외발생(){
        String input = "ab,,df";
        assertThatThrownBy(() -> new Cars(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 될수 없습니다.");

    }
    @Test
    void 자동차_이름이_5글자_이상시_예외발생(){
        String input = "ab,cdefgh,ij";
        assertThatThrownBy(() ->new Cars(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하 이여야 합니다.");

    }
    @Test
    void 이름_중복시_예외발생(){
        String input = "ab,ab,cd";
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복이 될수 없습니다.");

    }



}
