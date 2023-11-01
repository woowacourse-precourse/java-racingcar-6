package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PreprocessorTest {

    @Test
    void 자동차_이름_저장_테스트() {
        String[] carNames = Preprocessor.processCarNames("pobi,woni".split(","));
        Assertions.assertThat(carNames).containsExactly("pobi", "woni");

        String[] noName = Preprocessor.processCarNames(new String[]{" "});
        Assertions.assertThat(noName).containsExactly("null");
    }

    @Test
    void 자동차_이름_길이_테스트() {

        Preprocessor.checkCarNamesLength("pobi,woni".split(","));

        Assertions.assertThatThrownBy(() -> {
            Preprocessor.checkCarNamesLength("pobiwoni,jun".split(","));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_횟수_숫자_테스트() {

        long numOfMoves = Preprocessor.parseNumOfMoves("5");
        Assertions.assertThat(numOfMoves).isEqualTo((long)5);

        Assertions.assertThatThrownBy(() -> {
            Preprocessor.parseNumOfMoves("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}