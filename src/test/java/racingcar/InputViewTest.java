package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputView;

class InputViewTest extends NsTest {
    private InputStream originalSystemIn;

    public static void main(String[] args) {
        InputView.getMoveCount();
    }

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    void getCars_테스트() {
        //given
        InputStream inputStream = new ByteArrayInputStream("pobi, woni, jun".getBytes());
        System.setIn(inputStream);
        //when
        List<String> carStrings = InputView.getCarStrings();
        //then
        assertThat(carStrings).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void getMoveCount_테스트() {
        //given
        InputStream inputStream = new ByteArrayInputStream("10".getBytes());
        System.setIn(inputStream);
        //when
        //then
        assertThat(InputView.getMoveCount()).isEqualTo(10);
    }

    @Test
    void getMoveCount_오동작_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}