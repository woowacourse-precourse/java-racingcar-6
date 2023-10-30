package racingcar.game.inputgenerateManager;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.game.enums.InputSize;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalLengthException;

class InputGenerateManagerImplTest {

    private final InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();
    private final String STRING_NUMBER = "999";
    private final int PURE_NUMBER = 999;
    private final String STRING_NAME = "한놈,두식이,석삼";
    private final String[] NAME_LIST = {"한놈","두식이","석삼"};

    @RepeatedTest(10)
    void 난수_범위() {
        Integer generateRandomInt = inputGenerateManager.generateRandomInt();

        Assertions.assertThat(generateRandomInt).isInstanceOf(Integer.class);
        Assertions.assertThat(generateRandomInt)
                .isBetween(InputSize.START_INCLUSIVE.getSize(), InputSize.END_INCLUSIVE.getSize());
    }

    @Test
    void 문자열_정수변환() {
        Integer integerFromString = inputGenerateManager.generateInputStringToInt(STRING_NUMBER);

        Assertions.assertThat(integerFromString).isInstanceOf(Integer.class);
        Assertions.assertThat(integerFromString).isEqualTo(PURE_NUMBER);
    }

    @Test
    void 문자열_쉼표기준변환() {
        List<String> nameList = inputGenerateManager.generateInputStringSplitWithComma(STRING_NAME);

        Assertions.assertThat(nameList.size()).isEqualTo(3);
        Assertions.assertThat(nameList).contains(NAME_LIST[0], NAME_LIST[1], NAME_LIST[2]);
    }
}