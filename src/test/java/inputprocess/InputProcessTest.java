package inputprocess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.internal.ErrorMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class InputProcessTest {


    @DisplayName("메서드로 주어진 값을 구분")
    @Test
    void nameSplit() {
        String input = "1,qwer,qwds,zgqs";
        String [] output = input.split(",");
        // 순서를 포함해서 정확히 일치하는 지 확인하는 메소드
        assertThat(output).containsExactly("1","qwer","qwds","zgqs");
    }


    @DisplayName("문자열이 비거나 공백이 입력되었을 시에 IllegalArgumentException() 발생")
    @Test
    void blankInput() {
        String input2 = "  ";
        // isEmpty()는 비어있는 것만..
        assertThatThrownBy(() -> {
            if( input2.isBlank() ) {
                throw new IllegalArgumentException("문자열이 비거나 공백입니다.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열이 비거나 공백입니다.");
    }

    @DisplayName("5자 이하의 이름인지 확인")
    @Test
    void checkNameLength() {
        String input = "abcdqw";

        assertThatThrownBy(() -> {
            if( input.length() > 5 ) {
                throw new IllegalArgumentException("문자열이 5자를 넘었습니다.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열이 5자를 넘었습니다.");
    }


}