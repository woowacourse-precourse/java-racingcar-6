package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("사용자의 이름은 5글자 이하이다")
    void hasIllegalName() {
        //given
        String legal = "a,bb,ccc,dddd,eeeee";
        String[] legals = legal.split(",");

        String illegal1 = "a,bb,abcdef";
        String[] illegals1 = illegal1.split(",");

        String illegal2 = ",a,b,c,";
        String[] illegals2 = illegal2.split(",");

        String illegal3 = ",,,";
        String[] illegals3 = illegal3.split(",");

        for (String s : illegals3) {
            System.out.println("s = " + s);
        }

        //when
        //then
        assertThat(Validation.hasIllegalName(legals)).isFalse();
        assertThat(Validation.hasIllegalName(illegals1)).isTrue();
        assertThat(Validation.hasIllegalName(illegals2)).isTrue();
        assertThat(Validation.hasIllegalName(illegals3)).isTrue();
    }
}