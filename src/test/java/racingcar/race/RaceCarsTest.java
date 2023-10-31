package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.Input;

class RaceCarsTest {

    @ParameterizedTest
    @DisplayName("String 기반 생성자 테스트")
    @ValueSource(strings = {"pobi,woni,jun"})
    void newConstructorTest(String names) {
        Input testInput = new TestInput(names);
        RaceCars raceCars = new RaceCars(testInput);
        System.out.println("raceCars = " + raceCars);
    }

    private record TestInput(String input) implements Input {

        @Override
        public String readLine() {
            return input;
        }
    }
}