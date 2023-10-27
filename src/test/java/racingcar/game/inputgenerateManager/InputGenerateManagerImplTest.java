package racingcar.game.inputgenerateManager;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.game.enums.NumberSize;

class InputGenerateManagerImplTest {

    @RepeatedTest(10)
    void generateRandomInt() {
        //if
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        int generateRandomInt = inputGenerateManager.generateRandomInt();

        //then
        Assertions.assertThat(generateRandomInt).isInstanceOf(Integer.class);
        Assertions.assertThat(generateRandomInt)
                .isBetween(NumberSize.START_INCLUSIVE.getSize(), NumberSize.END_INCLUSIVE.getSize());
    }

    @Test
    void generateInputStringToInt() {
    }

    @Test
    void generateInputStringSplitWithComma() {
    }
}