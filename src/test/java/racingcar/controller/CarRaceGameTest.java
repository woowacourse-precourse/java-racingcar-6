package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRaceGameTest {
    @ParameterizedTest
    @ValueSource(strings = {",,",  "abcdef,abc", "abc,de,f,"})
    void 자동차이름테스트(String carNames) {
        Assertions.assertThatThrownBy().isInstanceOf(IllegalArgumentException.class);
    }

}