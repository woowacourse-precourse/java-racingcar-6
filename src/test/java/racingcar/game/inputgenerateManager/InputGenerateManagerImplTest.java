package racingcar.game.inputgenerateManager;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.game.enums.InputSize;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;

class InputGenerateManagerImplTest {

    @RepeatedTest(10)
    void generateRandomInt() {
        //if
        InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();

        //when
        Integer generateRandomInt = inputGenerateManager.generateRandomInt();

        //then
        Assertions.assertThat(generateRandomInt).isInstanceOf(Integer.class);
        Assertions.assertThat(generateRandomInt)
                .isBetween(InputSize.START_INCLUSIVE.getSize(), InputSize.END_INCLUSIVE.getSize());
    }

    @Test
    void generateInputStringToInt() {
        //if
        String rawString = "thisSectionMustBeNumberString";
        String overIntString = "999999999999999999999999";
        String nullString = "";

        //when
        InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();

        //then
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(rawString))
                .isInstanceOf(IllegalTypeException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(nullString))
                .isInstanceOf(IllegalBlankException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(overIntString))
                .isInstanceOf(IllegalRangeException.class);
    }

    @Test
    void generateInputStringSplitWithComma() {
        //if
        String rawString = "한놈,두식이,석삼,너구리밥";
        String illegalRawString = "한놈한놈21,두식이1,석삼,너구리";
        String nullString = "";
        InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();

        //when
        List<String> processedStrings = inputGenerateManager.generateInputStringSplitWithComma(rawString);

        //then
        Assertions.assertThat(processedStrings).size().isEqualTo(4);
        Assertions.assertThat(processedStrings).contains("한놈", "두식이", "석삼", "너구리밥");
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringSplitWithComma(illegalRawString))
                .isInstanceOf(IllegalLengthException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringSplitWithComma(nullString))
                .isInstanceOf(IllegalBlankException.class);
    }
}