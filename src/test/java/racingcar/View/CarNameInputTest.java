package racingcar.View;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameInputTest {
    private static CarNameInput carNameInput;

    @BeforeAll
    public static void setup() {
        carNameInput = new CarNameInput();
    }

    @Test
    void playerList() {
        String allList = "hi,ho,li";


        List<String> players = Arrays.asList("hi", "ho", "li");

    }

    @Test
    void nameIsDigit() {
        final String fake = "2";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.nameIsDigit(fake));

        assertThat(exception.getMessage()).isEqualTo("글자를 입력하셔야 합니다");
    }

    @Test
    void nameOverLength() {
        final String fake = "hellooo";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.nameOverLength(fake));

        assertThat(exception.getMessage()).isEqualTo("차 이름이 5글자를 넘었습니다.");
    }

    @Test
    void nameIsNull() {
        final String fake ="";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->carNameInput.nameIsNull(fake));

        assertThat(exception.getMessage()).isEqualTo("차 이름이 null 값 입니다.");
    }
}