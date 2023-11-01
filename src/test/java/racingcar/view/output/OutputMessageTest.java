package racingcar.view.output;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.EnumSource.Mode.INCLUDE;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class OutputMessageTest extends NsTest {

    @ParameterizedTest
    @EnumSource(mode = INCLUDE, names = {"EXECUTION_RESULT"})
    void Enum_속_상수_선언_값_테스트(OutputMessage outputMessage) {
        assertNotNull(outputMessage);
    }

    @Override
    protected void runMain() {

    }
}
