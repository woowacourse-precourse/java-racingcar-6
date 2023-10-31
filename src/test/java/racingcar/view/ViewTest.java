package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ViewTest {
    @Test
    public void InputView_자동차_이름_입력_화면_테스트() {
        assertThat(InputView.enterCarNamesMessage()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void InputView_총_라운드_수_입력_화면_테스트() {
        assertThat(InputView.enterCarNamesMessage()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void OutputView_실행_결과_출력_화면_테스트() {
        assertThat(OutputView.resultHeaderMessage()).isEqualTo("실행 결과");
    }
}
