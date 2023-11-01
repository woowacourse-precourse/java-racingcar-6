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

    @Test
    void 입력_횟수_숫자가_아닐떄_예외처리() {
        String inputName = "a12";
        assertThatThrownBy(() -> {
            Validator.InputRaceCount(inputName);
        }).isInstanceOf(IllegalArgumentException.class);
    }




}