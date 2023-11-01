package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 자동차_이름_길이_예외처리() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("abcd");
        carNameList.add("abcde");
        carNameList.add("abcdef");
        assertThatThrownBy(() -> {
            Validator.InputCarName(carNameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }




}