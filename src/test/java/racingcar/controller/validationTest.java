package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.controller.InputValidator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class validationTest {

    @ParameterizedTest
    @ValueSource(strings = {"longname,short", ",,,", ""})
    void 잘못된_이름_테스트(String player) {

        assertThatThrownBy(() -> {
            nameValidation(player);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"kim, lee, son","kim,,,lee, son"})
    void 올바른_이름_테스트(String player) {

        List<String> players = nameValidation(player);
        List<String> validPlayers = new ArrayList<>(Arrays.asList(new String[]{"kim", "lee", "son"}));

        Assertions.assertEquals(players,validPlayers);

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "notNumber", "1,2"})
    void number_Validation_Test(String testNumber) {

        // 음수 입력
        assertThatThrownBy(() -> {
            numberValidation(testNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
