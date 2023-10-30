package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {
    @Test
    void 정규식테스트() {
        String regex = "^[0-9a-zA-Zㄱ-ㅎ가-힣,]*$";
        assertThat("1,2".matches(regex)).isEqualTo(true);
        assertThat("1123,,24325".matches(regex)).isEqualTo(true);
        assertThat("가나,다라".matches(regex)).isEqualTo(true);
        assertThat("ㄱㄴㄷㄹ1,2ㅁㅄ".matches(regex)).isEqualTo(true);
        assertThat("abc,def".matches(regex)).isEqualTo(true);
        assertThat("a1bc,deㄱf".matches(regex)).isEqualTo(true);
        assertThat(",".matches(regex)).isEqualTo(true);
        assertThat("123456".matches(regex)).isEqualTo(true);
        assertThat("abcdef".matches(regex)).isEqualTo(true);
        assertThat("ㄱㄴㄷㄹ".matches(regex)).isEqualTo(true);
        assertThat("가나다라".matches(regex)).isEqualTo(true);
        assertThat("1!,3432".matches(regex)).isEqualTo(false);
        assertThat("%%,^^".matches(regex)).isEqualTo(false);
        assertThat(", ,".matches(regex)).isEqualTo(false);
    }

    @Test
    void 스플릿테스트() {

        boolean error = false;
        try {
            new CarNameValidator("123,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

        error = false;
        try {
            new CarNameValidator("123,,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",,123,456");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("123,456,,");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator(",,");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);
    }

    @Test
    void 중복테스트() {

        boolean error = false;
        try {
            new CarNameValidator("12345,12345,123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("가나,나다,가나,가나다");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,def");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,gh");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

    }

    @Test
    void 길이테스트() {

        boolean error = false;
        try {
            new CarNameValidator("123456,123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("가나다라마바,나다,가나");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abc,def,def123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(true);

        error = false;
        try {
            new CarNameValidator("abcde,가나다라마,12345,가나123");
        } catch (IllegalArgumentException iae) {
            error = true;
        }
        assertThat(error).isEqualTo(false);

    }

}
