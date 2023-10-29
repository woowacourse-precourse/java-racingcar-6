package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValueTest {

    private InputValue inputValue;

    @BeforeEach
    void Setup() {
        inputValue = new InputValue();
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,jun")
    void 자동차_이름_입력(String input) {
        generateUserInput(input);
        String[] names = inputValue.InputNameOfCars();
        assertThat(names).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    private static void generateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}