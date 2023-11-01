package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    void 쉼표_구분_자동차_이름_문자열_입력_List_반환() {
        String cars = "a,b,c";
        System.setIn(new ByteArrayInputStream(cars.getBytes()));

        List<String> actual = InputView.inputCars();

        assertThat(actual).containsExactly("a", "b", "c");
    }

    @Test
    void 시행_횟수_입력_int_반환() {
        String turn = "5";
        System.setIn(new ByteArrayInputStream(turn.getBytes()));

        int actual = InputView.inputTurn();

        assertThat(actual).isEqualTo(5);
    }
}
