package racingcar.controller;

import static java.beans.Beans.isInstanceOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.view.Input;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameTest {
    private final Game game = new Game();

    @ParameterizedTest
    @MethodSource("carNameAndRounds")
    void inputTest_차이름_라운드수_잘못된_입력_확인(String carName, String rounds) throws IOException {
        InputStream carNameInput = new ByteArrayInputStream(carName.getBytes());
        InputStream roundsInput = new ByteArrayInputStream(rounds.getBytes());
        InputStream is = new SequenceInputStream(carNameInput, roundsInput);
        System.setIn(is);
        assertThatThrownBy(this::gameRunTest)
                .isInstanceOf(IllegalArgumentException.class);
        camp.nextstep.edu.missionutils.Console.close();
    }

    private static Stream<Arguments> carNameAndRounds() {
        return Stream.of(
                Arguments.of("harry, \n", "3\n"), //공백이 있음
                Arguments.of("harryyyy,ron\n", "4\n"), //이름의 길이가 5 초과
                Arguments.of("harry,ron\n", "-3\n") //라운드 수가 음수
        );
    }

    private void gameRunTest() throws IllegalArgumentException {
        game.gameStart();
    }

}