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
    //TODO : 중복예외, 마지막 (,)이후 엔터시 예외
    @RepeatedTest(10)
    void 난수값이_지정된범위_내_생성되는지_확인() {
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
    void 문자열_정수변환_예외() {
        //if
        String rawString = "thisSectionMustBeNumberString";
        String overIntString = "999999999999999999999999";
        String blankString = "";

        //when
        InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();

        //then
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(rawString))
                .isInstanceOf(IllegalTypeException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(blankString))
                .isInstanceOf(IllegalBlankException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringToInt(overIntString))
                .isInstanceOf(IllegalRangeException.class);
    }

    @Test
    void 문자열_쉼표기준_나뉘는지_And_5자이상_빈값일때_예외() {
        //if
        String rawString = "한놈,두식이,석삼,너구리밥";
        String illegalRawString = "한놈한놈21,두식이1,석삼,너구리";
        String blankString = "";
        InputGenerateManager inputGenerateManager = InputGenerateManagerImpl.createInputGenerateManager();

        //when
        List<String> processedStrings = inputGenerateManager.generateInputStringSplitWithComma(rawString);

        //then
        Assertions.assertThat(processedStrings).size().isEqualTo(4);
        Assertions.assertThat(processedStrings).contains("한놈", "두식이", "석삼", "너구리밥");
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringSplitWithComma(illegalRawString))
                .isInstanceOf(IllegalLengthException.class);
        Assertions.assertThatThrownBy(() -> inputGenerateManager.generateInputStringSplitWithComma(blankString))
                .isInstanceOf(IllegalBlankException.class);
    }
}