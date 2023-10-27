package racingcar.game.inputgenerateManager;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.game.enums.NumberSize;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalTypeException;

class InputGenerateManagerImplTest {

    @RepeatedTest(10)
    void generateRandomInt() {
        //if
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        Integer generateRandomInt = inputGenerateManager.generateRandomInt();

        //then
        Assertions.assertThat(generateRandomInt).isInstanceOf(Integer.class);
        Assertions.assertThat(generateRandomInt)
                .isBetween(NumberSize.START_INCLUSIVE.getSize(), NumberSize.END_INCLUSIVE.getSize());
    }

    @Test
    void generateInputStringToInt() {
        //if
        String rawString = "thisSectionMustBeNumberString";
        String nullString = "";

        //when
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //then
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(rawString)).isInstanceOf(
                IllegalTypeException.class);
    }

    @Test
    void generateInputStringSplitWithComma() {
        //if
        String rawString = "한놈,두식이,석삼,너구리밥";
        String illegalRawString = "한놈한놈21,두식이1,석삼,너구리";
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        List<String> processedStrings = inputGenerateManager.generateInputStringSplitWithComma(rawString);

        //then
        Assertions.assertThat(processedStrings).size().isEqualTo(4);
        Assertions.assertThat(processedStrings).contains("한놈", "두식이", "석삼", "너구리밥");
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringSplitWithComma(illegalRawString))
                .isInstanceOf(IllegalLengthException.class);
    }
}