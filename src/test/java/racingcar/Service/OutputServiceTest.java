package racingcar.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputServiceTest {

    @Test
    @DisplayName("자동차 이름 질문 문구 출력기능 ")
    public void output1() {
        OutputService outputService = new OutputService();
        Assertions.assertThat(outputService.printCarnameQuestion()).
                isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
