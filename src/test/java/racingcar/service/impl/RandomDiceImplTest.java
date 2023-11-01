package racingcar.service.impl;

import static racingcar.AppConfig.MAX_DICE_NUMBER;
import static racingcar.AppConfig.MIN_DICE_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.service.Dice;

public class RandomDiceImplTest {

    Dice dice;

    @BeforeEach
    public void beforeEach() {
        dice = new AppConfig().dice();
    }

    @Test
    void rollTest() {
        //given
        int result;
        //when
        result = dice.roll();
        //then
        Assertions.assertThat(result).isBetween(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    @Test
    void ManyRollTest() {
        //given
        int result;
        boolean flag = false;
        //when
        int count = 0;
        while (count < 100) {
            result = dice.roll();
            if(!(result >= MIN_DICE_NUMBER && result <= MAX_DICE_NUMBER)){
                flag = true;
            }
            count++;
        }
        //then
        Assertions.assertThat(flag).isFalse();
    }
}