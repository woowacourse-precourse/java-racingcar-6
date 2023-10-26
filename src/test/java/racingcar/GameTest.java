package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void inputName_정상_작동() {
        String input = "a,b,c";
        provideInput(input);

        String[] nameArr = game.inputName();

        assertThat(nameArr).containsExactly("a", "b", "c");
    }

    @Test
    void inputName_앞에_쉼표_발견() {
        String input = ",b,c";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputName_뒤에_쉼표_발견() {
        String input = "a,b,";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputNumber_정상_작동() {
        String input = "6";
        provideInput(input);

        int number = game.inputNumber();

        assertThat(number).isEqualTo(6);
    }

    @Test
    void inputNumber_입력_안함() {
        String input = "";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @Test
    void inputNumber_숫자가_아닌_경우() {
        String input = "a";
        provideInput(input);

        assertThatIllegalArgumentException();
    }

    @AfterEach
    void 테스트종료() {
        Console.close();
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}