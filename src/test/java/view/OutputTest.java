package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @Test
    void 숫자_입력메시지_출력(){
        OutputView outputView = new OutputView();
        Assertions.assertThat( outputView.numberInputMessage()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


}


