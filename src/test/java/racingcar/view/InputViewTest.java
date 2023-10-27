package racingcar.view;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class InputViewTest extends NsTest {
    @Test
    void 자동차_이름_잘못된_입력_대한_예외_처리() {
        //given
        String normalInput = "qwer,asdf,zxcv";
        String duplicatedInput = "asdf,zxcv,asdf";
        String sizeOverInput = "asdfasdf,zxcv,qwer";
        String specialCharactersInput = "aa-,(zxvc),^_^";
        //when
        Throwable throwable1 = catchThrowable(() -> runException(normalInput));
        Throwable throwable2 = catchThrowable(() -> runException(duplicatedInput));
        Throwable throwable3 = catchThrowable(() -> runException(sizeOverInput));
        Throwable throwable4 = catchThrowable(() -> runException(specialCharactersInput));
        //then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable3).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable4).isInstanceOf(IllegalArgumentException.class);


    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
