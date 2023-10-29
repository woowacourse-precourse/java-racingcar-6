package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class InputViewTest {
    InputView view = new InputView();
    @Test
    void split_쉼표테스트(){
        String cars = "car1,car2,car3";
        List<String> carArray = view.inputCarNameToList(cars);
        assertThat(carArray).containsExactly("car1","car2","car3");
    }
    @Test
    void 시도회수가_0보다_큰_정수인지_테스트(){
        assertThatThrownBy(()->view.validTryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}