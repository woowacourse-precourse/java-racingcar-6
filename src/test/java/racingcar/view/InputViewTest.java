package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
    }

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @Test
    @DisplayName("사용자에게 자동차 A,B를 입력 받은 후 반환한다.")
    void readCars() throws Exception {
        //given
        String input = "A,B";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        String cars = inputView.readCars();
        //then
        assertThat(cars).isEqualTo("A,B");
    }

    @Test
    @DisplayName("사용자에게 횟수 5를 입력 받은 후 반환한다.")
    void readCarsGameCount() throws Exception {
        //given
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        String count = inputView.readCarsGameCount();
        //then
        assertEquals("5", count);
    }


}