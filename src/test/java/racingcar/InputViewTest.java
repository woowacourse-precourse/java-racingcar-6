package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    void getCars_테스트() {
        //given
        InputStream inputStream = new ByteArrayInputStream("pobi, woni, jun".getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();
        //when
        List<String> carStrings = inputView.getCars();
        //then
        assertThat(carStrings).containsExactly("pobi", "woni", "jun");
    }
}