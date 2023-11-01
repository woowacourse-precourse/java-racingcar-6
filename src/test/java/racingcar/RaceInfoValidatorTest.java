package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceInfoValidatorTest {

    @Test
    void 자동차_이름_길이에_대한_예외처리(){
        String[] carNames = {"car","car123"};
        assertThatThrownBy(()->RaceInfoValidator.checkCarNameLength(carNames)).isInstanceOf(IllegalArgumentException.class).hasMessage(Constants.EXCEED_NAME_LENGTH);


    }

    @Test
    void 자동차_이름_공백에_대한_예외처리(){
        String[] carNames = {"car1"," ","car2"};
        assertThatThrownBy(()->RaceInfoValidator.isNameEmpty(carNames)).isInstanceOf(IllegalArgumentException.class).hasMessage(Constants.EMPTY_CAR_NAME);
    }

    @Test
    void 자동차_이름_중복에_대한_예외처리(){
        String[] carNames = {"car1","car1","car2"};
        assertThatThrownBy(()->RaceInfoValidator.hasUniqueName(carNames)).isInstanceOf(IllegalArgumentException.class).hasMessage(Constants.DUPLICATE_CAR_NAME);
    }

    @Test
    void 자동차_개수에_대한_예외처리(){
        String[] carNames = {"car1"};
        assertThatThrownBy(()->RaceInfoValidator.hasMultipleCars(carNames)).isInstanceOf(IllegalArgumentException.class).hasMessage(Constants.CAR_COUNT_INSUFFICIENT);
    }

    @ParameterizedTest
    @CsvSource({"0","-1"})
    void 시도횟수에_대한_예외처리(String attemptCount){
        assertThatThrownBy(()->RaceInfoValidator.checkAttemptCount(attemptCount)).isInstanceOf(IllegalArgumentException.class).hasMessage(Constants.INVALID_ATTEMPT_COUNT);

    }


}