package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayTypeTest {

    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    public void 임의의_전진숫자의_타입을_찾아_GO를_반환(int goNumber){
        PlayType result = PlayType.findByNum(goNumber);
        assertThat(result).isEqualTo(PlayType.GO);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    public void 임의의_정지숫자의_타입을_찾아_STOP을_반환(int stopNumber){
        PlayType result = PlayType.findByNum(stopNumber);
        assertThat(result).isEqualTo(PlayType.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = { 10, -1, 100})
    public void 이외의_숫자입력시_예외_반환(int errorNumber){
        assertThatThrownBy(() -> PlayType.findByNum(errorNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}