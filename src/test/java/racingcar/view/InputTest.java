package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    Input input = new Input();

    @Test
    void Input_자동차의_이름들을_입력받는다(){
        String text = "pobi,hash,neo";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        String[] carNames = input.InputCarName();

        assertThat(new String[]{"pobi","hash","neo"}).isEqualTo(carNames);
    }

}