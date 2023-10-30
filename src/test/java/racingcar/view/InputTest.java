package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    Input input = new Input();

    @Test
    void Input_자동차의_이름들을_입력(){
        String text = "pobi,hash,neo";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        String[] carNames = input.InputCarName();

        assertThat(new String[]{"pobi","hash","neo"}).isEqualTo(carNames);
    }

    @Test
    void Input_자동차의_시도할_횟수를_입력(){
        String text = "5";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        int number = input.InputMovingNumber();

        assertThat(Integer.parseInt(text)).isEqualTo(number);
    }

    @Test
    void Input_자동차의_시도할_횟수에서_예외_발생(){
        String text = "5sfsfsf7";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.InputCarName())
                .isInstanceOf(IllegalArgumentException.class);
    }
}