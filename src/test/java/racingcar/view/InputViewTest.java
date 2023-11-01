package racingcar.view;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        String input = "카1,car2,car3\ncar1,car2/car3\ncar1,car2345,차\ncar1,car45,car1\ncar1\n" +
                "+12\n12\n-12\n12$";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        inputView = new InputView();
    }


    @Test
    @Order(1)
    void 사용자_자동차_이름_입력_테스트() {
        List<String> carNameList = inputView.InputCarName();

        assertEquals(3, carNameList.size());
        assertThat(carNameList).containsExactly("카1", "car2", "car3");
    }

    @Test
    @Order(2)
    @DisplayName("자동차 이름 입력 구분을 ,로 했는지 확인하는 테스트")
    void 사용자_자동차_이름_입력_예외_테스트1() {
        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 구분을 ,로 하지 않았습니다.");
    }


    @Test
    @Order(3)
    @DisplayName("자동차 이름이 길이 제한을 만족하는지 확인하는 테스트")
    void 사용자_자동차_이름_입력_예외_테스트2() {
        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 길이는 5이하 입니다.");
    }

    @Test
    @Order(4)
    @DisplayName("자동차 이름이 중복됐는지 확인하는 테스트")
    void 사용자_자동차_이름_입력_예외_테스트3() {
        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 중복됐습니다.");
    }

    @Test
    @Order(5)
    @DisplayName("자동차 개수가 경주할 만큼 있는지 확인하는 테스트")
    void 사용자_자동차_이름_입력_예외_테스트4() {
        assertThatThrownBy(() -> inputView.InputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 2대 이상 이여야 경주가 가능합니다.");
    }

    @Test
    @Order(6)
    void 시도_횟수_사용자_입력_테스트1() {
        int tryNum = inputView.InputTryNum();

        assertEquals(12, tryNum);
    }

    @Test
    @Order(7)
    void 시도_횟수_사용자_입력_테스트() {
        int tryNum = inputView.InputTryNum();

        assertEquals(12, tryNum);
    }

    @Test
    @Order(8)
    @DisplayName("시도 횟수 양수인지 확인하는 테스트")
    void 시도_횟수_사용자_입력_예외_테스트1() {
        assertThatThrownBy(() -> inputView.InputTryNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 옳바르지 않습니다. 양수로 입력해주세요.");
    }

    @Test
    @Order(9)
    @DisplayName("시도 횟수 타입이 정수인지 확인하는 테스트")
    void 시도_횟수_사용자_입력_예외_테스트2() {
        assertThatThrownBy(() -> inputView.InputTryNum())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수에 대한 입력이 정수가 아닙니다.");
    }
}
