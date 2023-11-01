package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.car.Car;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("입력된 시도 횟수 예외처리 확인")
    void setGameTest_시도횟수가_숫자가_아니면_예외처리() {
        System.setIn(createConsoleInput("asdf", "asdf"));

        assertThatIllegalArgumentException().isThrownBy(() ->
                new Game().setGame()
        );
    }

    private InputStream createConsoleInput(String carNames, String numberOfTry) {
        List<InputStream> stream = Arrays.asList(generateInput(carNames), generateInput("\n"), generateInput(numberOfTry));
        return new SequenceInputStream(Collections.enumeration(stream));
    }

    private InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
