package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.io.InputView;

class InputViewTest {

    @AfterEach
    void after() {
        Console.close();
    }

    public void setUpInputStream(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void readLineTest() {
        //given
        String input = "hello";
        setUpInputStream(input);

        //when
        String s = Console.readLine();

        //then
        Assertions.assertEquals(s, input);
    }

    @Test
    void carNamesInputTest() {
        //given
        String input = "a1,b1,c1,d1";
        setUpInputStream(input);

        //when
        String carNamesInput = InputView.carNamesInput();

        //then
        Assertions.assertEquals(carNamesInput, input);
    }

    @Test
    void tryCountInputTest() {
        //given
        String input = "5";
        setUpInputStream(input);

        //when
        String tryCountInput = InputView.tryCountInput();

        //then
        Assertions.assertEquals(tryCountInput, input);
    }
}
