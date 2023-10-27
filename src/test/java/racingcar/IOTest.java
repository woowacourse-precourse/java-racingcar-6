package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;

public class IOTest {

    @Test
    void 정상적인_자동차_이름_입력() {
        // given
        GameRule rule = new GameRule(5, 0, 9);
        String[] names = new String[] {"BMW", "pobi", "woni", "abcde"};
        CarRecord expectedNames = CarRecordFactory.createEmptyCarRecord();
        for (int i = 0; i < names.length; i++) {
            expectedNames.register(CarFactory.car(rule, names[i]));
        }
        String rawInputString = String.join(",", names) + "\n";
        InputPrompt prompt = new InputPrompt(rule);
        // when
        InputStream stdIn = System.in;
        System.setIn(new ByteArrayInputStream(rawInputString.getBytes()));
        CarRecord actualNames = prompt.readCarNames();
        // then
        assertThat(actualNames).isEqualTo(expectedNames);
        prompt.close();
        System.setIn(stdIn);
   }

    /**
     * 자동차 이름은 대소문자 알파벳만 가능하다고 가정
     */
    @Test
    void 비정상적인_자동차_이름_입력() {
        // given
        GameRule rule = new GameRule(5, 0, 9);
        String[] names = new String[] {"woni1", "abcdef"};
        InputPrompt prompt = new InputPrompt(rule);
        InputStream stdIn = System.in;
        for (int i = 0; i < names.length; i++) {
            // when
            System.setIn(new ByteArrayInputStream(names[i].getBytes()));
            // then
            Assertions.assertThatThrownBy(() -> prompt.readCarNames()).isInstanceOf(IllegalArgumentException.class);
            prompt.close();
        }
        System.setIn(stdIn);
    }

   @Test
    void 정상적인_이동_횟수_입력() {
       // given
       GameRule rule = new GameRule(5, 0, 9);
       String[] inputs = new String[] {"5", "50", "05", "010201", "    3     "};
       int[] numbers = new int[] {5, 50, 5, 10201, 3};
       InputPrompt prompt = new InputPrompt(rule);
       InputStream stdIn = System.in;
       for (int i = 0; i < inputs.length; i++) {
           System.setIn(new ByteArrayInputStream(inputs[i].getBytes()));
           // when
           NumberOfRepetitions n = prompt.readNumberOfRepetitions();
           // then
           assertThat(n).isEqualTo(new NumberOfRepetitions(numbers[i]));
           prompt.close();
       }
       System.setIn(stdIn);
   }

    @Test
    void 비정상적인_이동_횟수_입력() {
        // given
        GameRule rule = new GameRule(5, 0, 9);
        String[] inputs = new String[] {"5k", "0", " k  3     ", "1   3"};
        int[] numbers = new int[] {5, 50, 5, 10201, 3};
        InputPrompt prompt = new InputPrompt(rule);
        InputStream stdIn = System.in;
        for (int i = 0; i < inputs.length; i++) {
            // when
            System.setIn(new ByteArrayInputStream(inputs[i].getBytes()));
            // then
            Assertions.assertThatThrownBy(() -> prompt.readNumberOfRepetitions())
                    .isInstanceOf(IllegalArgumentException.class);
            prompt.close();
        }
        System.setIn(stdIn);
    }
}
