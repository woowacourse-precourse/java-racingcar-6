package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @Test
    void 사용자_자동차_이름_입력_테스트() {
        InputView inputView = new InputView();

        String input = "car1,car2,car3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<String> carNameList = inputView.InputCarName();

        assertEquals(3, carNameList.size());
        assertThat(carNameList).containsExactly("car1", "car2", "car3");
    }

    @Test
    void 사용자_자동차_이름_입력_예외_테스트1() {
        InputView inputView = new InputView();

        String input = "car1,car2/car3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 구분을 ,로 하지 않았습니다.");
    }

    @Test
    void 사용자_자동차_이름_입력_예외_테스트2() {
        InputView inputView = new InputView();

        String input = "car1,car2345,차";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 길이는 5이하 입니다.");
    }

    @Test
    void 사용자_자동차_이름_입력_예외_테스트3() {
        InputView inputView = new InputView();

        String input = "car1,car45,car1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 중복됐습니다.");
    }

    @Test
    void 사용자_자동차_이름_입력_예외_테스트4() {
        InputView inputView = new InputView();

        String input = "car1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 2대 이상 이여야 경주가 가능합니다.");
    }

    @Test
    void 시도_횟수_사용자_입력_테스트1() {
        InputView inputView = new InputView();

        String input = "+12";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int tryNum = inputView.InputTryNum();

        assertEquals(12, tryNum);
    }

    @Test
    void 시도_횟수_사용자_입력_테스트() {
        InputView inputView = new InputView();

        String input = "12";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int tryNum = inputView.InputTryNum();

        assertEquals(12, tryNum);
    }

    @Test
    void 시도_횟수_사용자_입력_예외_테스트1() {
        InputView inputView = new InputView();

        String input = "-12";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputTryNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 옳바르지 않습니다. 양수로 입력해주세요.");
    }

    @Test
    void 시도_횟수_사용자_입력_예외_테스트2() {
        InputView inputView = new InputView();

        String input = "12$";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.InputTryNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수에 대한 입력이 정수가 아닙니다.");
    }
}
