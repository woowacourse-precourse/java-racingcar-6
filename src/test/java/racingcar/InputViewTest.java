package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputViewTest {
    /* 이름(carNames) 검증 */
    @Test
    void 이름_미입력_시_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력할 수 없습니다.");
    }

    @Test
    void 이름에_구분자만_있을_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames(",,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 구분자(,)로 끝날 수 없습니다.");
    }

    @Test
    void 이름이_구분자로_끝날_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("a,b,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 구분자(,)로 끝날 수 없습니다.");
    }

    @Test
    void 이름에_스페이스_문자_들어갈_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("a,k b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력할 수 없습니다.");
    }

    @Test
    void 이름에_탭_문자_들어갈_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("a,k    b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력할 수 없습니다.");
    }

    @Test
    void 이름을_한_개_입력할_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("Car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    void 이름이_정해진_길이에서_벗어날_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("Car123456,Car2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자 이내여야 합니다.");
    }

    @Test
    public void 이름이_중복될_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateCarNames("우와,우,아,우아,와,우와"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 존재합니다.");
    }

    /* 시도 횟수(tryCount) 검증 */
    @Test
    void 시도_횟수_미입력_시_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateTryCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력할 수 없습니다.");
    }

    @Test
    void 시도_횟수에_0을_입력할_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1회 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수에_음수_입력할_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateTryCount("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1회 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수에_숫자_아닌_값_입력할_때_예외_처리() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수로 숫자를 입력해주세요.");
    }
}