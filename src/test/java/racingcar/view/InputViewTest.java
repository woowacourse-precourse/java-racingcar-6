package racingcar.view;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import static racingcar.common.Constants.MESSAGE_OF_REQUEST_NAMES;
import static racingcar.common.Constants.MESSAGE_OF_REQUEST_TRY_NUMBER;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;

class InputViewTest extends IOTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        systemOut();
    }

    @AfterEach
    void after() {
        clean();
    }

    @Test
    void requestNames_메서드로_경주차_이름_입력문구_출력() {
        //given
        systemIn("seori,snow,joy");

        //when
        inputView.requestNames();

        //then
        assertThat(getOutput()).contains(MESSAGE_OF_REQUEST_NAMES);
    }

    @Test
    void requestTryNumber_메서드로_시도_횟수_입력문구_출력() {
        //given
        systemIn("1");

        //when
        inputView.requestTryNumber();

        //then
        assertThat(getOutput()).contains(MESSAGE_OF_REQUEST_TRY_NUMBER);
    }

}