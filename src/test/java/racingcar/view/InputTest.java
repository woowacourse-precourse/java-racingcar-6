package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    Input input = new Input();

    @Test
    void Input_자동차의_이름들을_입력(){
        String text = "pobi,hash,neo";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        String[] carNames = input.inputCarName();

        assertThat(new String[]{"pobi","hash","neo"}).isEqualTo(carNames);
        Console.close();
    }

    @Test
    void input_자동차의_이름을_구분하는_표시를_띄어쓰기로_한_경우_예외(){
        String text = "pobi hash neo";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉽표(,)를 통해 구분해 주세요.");
        Console.close();
    }

    @Test
    void input_자동차의_이름을_5자를_초과한_경우_예외(){
        String text = "pobi,suyeon,neo";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
        Console.close();
    }

    @Test
    void input_경기에_출전하는_자동차가_2대_미만인_경우_예외(){
        String text = "pobi";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상이 경기에 참여해야 합니다");
        Console.close();
    }

    @Test
    void Input_자동차의_시도할_횟수를_입력(){
        String text = "5";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        int number = input.inputMovingNumber();

        assertThat(Integer.parseInt(text)).isEqualTo(number);
        Console.close();
    }

    @Test
    void Input_자동차의_시도할_횟수에서_예외(){
        String text = "5sfsfsf7";
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> input.inputMovingNumber())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }
}