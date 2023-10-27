package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;

public class IOTest {

    @Test
    void 정상적인_자동차_이름_입력() {
        // given
        GameRule rule = new GameRule(5, 0, 9);
        String[] names = new String[] {"K5", "BMW", "팰리세이드", "포르쉐"};
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
}
