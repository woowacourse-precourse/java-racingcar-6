package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.manager.view.UserView;

public class UserViewTest {

    private final UserView userView = new UserView();

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @Test
    void 숫자_이외_입력_들어올_시_예외_처리(){
        String inputCount = "2a";
        InputStream in = new ByteArrayInputStream(inputCount.getBytes());
        System.setIn(in);
        assertThatThrownBy(userView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_정수로_바꾸기_테스트(){
        String inputCount = "234";
        Integer expectedResult = 234;
        assertThat(userView.stringToInt(inputCount)).isEqualTo(expectedResult);
    }

}
