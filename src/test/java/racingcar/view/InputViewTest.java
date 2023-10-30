package racingcar.view;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class InputViewTest extends NsTest {
    @Test
    void 자동차_이름_입력이_정상인지_검증() {
        //given
        String normalInput = "qwer,asdf,zxcv";
        //when
        Throwable normal = catchThrowable(() -> runException(normalInput));
        //then
        assertThat(normal).doesNotThrowAnyException();
    }

    @Test
    void 중복된_자동차_이름_입력에_대한_검증() {
        //given
        String normalInput = "qwer,asdf,zxcv";
        String duplicatedInput = "asdf,zxcv,asdf";
        //when
        Throwable normal = catchThrowable(() -> runException(normalInput));
        Throwable duplicated = catchThrowable(() -> runException(duplicatedInput));
        //then
        assertThat(normal).doesNotThrowAnyException();
        assertThat(duplicated).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_자동차_이름이_주어진_길이를_넘겼는지_검증() {
        //given
        String sizeOverInput = "asdfasdf,zxcv,qwer";
        //when
        Throwable sizeOver = catchThrowable(() -> runException(sizeOverInput));
        //then
        assertThat(sizeOver).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_자동차_이름이_특수문자를_포함하는지_검증() {
        //given
        String specialCharactersInput = "aa-,(zxvc),^_^";
        //when
        Throwable specialCharacters = catchThrowable(() -> runException(specialCharactersInput));
        //then
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_이동횟수가_정상인지_검증() {
        //given
        String carName = "name";
        String normalInput = "5";
        //when
        Throwable normal = catchThrowable(() -> runException(carName, normalInput));
        //then
        assertThat(normal).doesNotThrowAnyException();
    }

    @Test
    void 입력된_이동횟수가_범위에_속하는지_검증() {
        //given
        String carName = "name";
        String sizeOverInput = "10001";
        //when
        Throwable sizeOver = catchThrowable(() -> runException(carName, sizeOverInput));
        //then
        assertThat(sizeOver).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_이동횟수가_숫자로_이루어졌는지_검증() {
        //given
        String carName = "name";
        String specialCharactersInput = "specialCharacters";
        //when
        Throwable specialCharacters = catchThrowable(() -> runException(carName, specialCharactersInput));
        //then
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
