package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputTest {


    @Test
    void 차를정상적으로입력했을때() {
        //given
        Input input = new Input("pobi,woni,jun");
        //when
        String[] result = input.inputCarNames();
        //then
        Assertions.assertThat(result).contains("pobi", "woni", "jun");
    }


    @Test
    void 차이름을비정상적으로입력했을때() {
        //given
        Input input = new Input("fjiejifjei");
        //when and then
        Assertions.assertThatThrownBy(() -> {
            input.inputCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수를정상적으로입력했을때() {
        //given
        Input input = new Input("3");
        //when
        String result = input.inputRounds();
        //then
        Assertions.assertThat(result).isEqualTo("3");
    }

    @Test
    void 횟수를비정상적으로입력했을때() {
        //given
        Input input = new Input("안녕");
        //when and then
        Assertions.assertThatThrownBy(() -> {
            input.inputRounds();
        }).isInstanceOf(IllegalArgumentException.class);

    }


}