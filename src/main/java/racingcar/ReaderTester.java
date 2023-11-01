package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReaderTester {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("올바른 자동차 입력 인지 확인")
    void readMembers() {
        Reader reader = new Reader();
        System.setIn(createUserInput("poni,woni,jun"));

        assertThat(reader.readInput()).isEqualTo(List.of("poni", "woni", "jun"));
    }

    @Test
    @DisplayName("올바른 시도 횟수 인지 확인")
    void readNumber() {
        Reader reader = new Reader();
        System.setIn(createUserInput("1"));

        assertThat(reader.readNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("잘못된 자동차 이름(5자 이상)을 입력했을 경우")
    void readWrongMembers() {
        Reader reader = new Reader();
        System.setIn(createUserInput("junijuni,woni,jun"));

        assertThatThrownBy(() -> reader.readInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 5글자가 넘었습니다.");
    }

    @Test
    @DisplayName("잘못된 시도 횟수 입력(숫자가 아닌 입력)")
    void readWrongNumber() {
        Reader reader = new Reader();
        System.setIn(createUserInput("n"));

        assertThatThrownBy(() -> reader.readNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력 되었습니다.");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
