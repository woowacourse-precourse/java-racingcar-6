package racingcar.view;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class InputViewTest extends NsTest {
    @Test
    void 자동차_이름_입력에_대한_예외_처리() {
        //given
        String normalInput = "qwer,asdf,zxcv";
        String duplicatedInput = "asdf,zxcv,asdf";
        String sizeOverInput = "asdfasdf,zxcv,qwer";
        String specialCharactersInput = "aa-,(zxvc),^_^";
        //when
        Throwable normal = catchThrowable(() -> runException(normalInput));
        Throwable duplicated = catchThrowable(() -> runException(duplicatedInput));
        Throwable sizeOver = catchThrowable(() -> runException(sizeOverInput));
        Throwable specialCharacters = catchThrowable(() -> runException(specialCharactersInput));
        //then
        assertThat(normal).doesNotThrowAnyException();
        assertThat(duplicated).isInstanceOf(IllegalArgumentException.class);
        assertThat(sizeOver).isInstanceOf(IllegalArgumentException.class);
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수_입력에_대한_예외_처리() {
        //given
        String carName = "carName";
        String normalInput = "5";
        String sizeOverInput = "10001";
        String specialCharactersInput = "specialCharacters";
        //when
        Throwable normal = catchThrowable(() -> runException(normalInput, normalInput));
        Throwable sizeOver = catchThrowable(() -> runException(normalInput, sizeOverInput));
        Throwable specialCharacters = catchThrowable(() -> runException(normalInput, specialCharactersInput));
        //then
        assertThat(normal).doesNotThrowAnyException();
        assertThat(sizeOver).isInstanceOf(IllegalArgumentException.class);
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
