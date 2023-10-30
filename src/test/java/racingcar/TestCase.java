package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.View.SystemMessage;
import racingcar.util.ExceptionHandling;
import racingcar.model.CarAction;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCase {
    @AfterEach
    public void afterEach(){
        Cars.carList = new ArrayList<>();
    }
    @Test
    void 주어진_값을_구분() {
        String input = "ab,cd,df";
        Cars cars = new Cars(input);
        List<String> result = Cars.carList;
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

    @Test
    void 랜덤_숫자에_따라_이동(){
        String input = "ab,cd,df";
        Cars cars = new Cars(input);
        CarAction carAction = new CarAction();
        carAction.carMoveCount();
        List<Integer> result = Cars.countList;
        assertThat(result).contains(1);
    }
    @Test
    void 숫자0_입력시_예외발생(){
        String input = "0";
        assertThatThrownBy(() -> ExceptionHandling.isNumberZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 입력할 수 없습니다");
    }




}
