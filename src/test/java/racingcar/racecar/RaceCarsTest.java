package racingcar.racecar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.RaceCars;

class RaceCarsTest {

    @ParameterizedTest
    @DisplayName("String 기반 생성자 테스트")
    @ValueSource(strings = {"pobi,woni,jun"})
    void newConstructorTest(String names) {
        RaceCars raceCars = new RaceCars(names);
        System.out.println("raceCars = " + raceCars);
    }
}