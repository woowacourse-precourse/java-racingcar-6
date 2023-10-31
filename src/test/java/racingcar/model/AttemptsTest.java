package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AttemptsTest {

    @Test
    void getNumber_fail() {
        Attempts attempts = new Attempts(1);
        assertThat(attempts.getNumber()).isEqualTo("1");
    }
    @Test
    void getNumber() {
        Attempts attempts = new Attempts(1);
        assertThat(attempts.getNumber()).isEqualTo(1);
    }

    @Test
    void getNumber_String_fail() {
        Attempts attempts = new Attempts("1");
        assertThat(attempts.getNumber()).isEqualTo("1");
    }

    @Test
    void getNumber_String() {
        Attempts attempts = new Attempts("1");
        assertThat(attempts.getNumber()).isEqualTo(1);
    }

    @Test
    void 잘못된_입력_테스트() {
        assertThatThrownBy(() -> new Attempts("-1.1")).isInstanceOf(IllegalArgumentException.class);
    }
}