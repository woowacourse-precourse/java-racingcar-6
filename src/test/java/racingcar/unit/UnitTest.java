package racingcar.unit;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.Validator;

import java.util.ArrayList;
import java.util.List;

public class UnitTest extends NsTest {
    @Test
    void inputValidateThrowTest(){
        List<String> list = new ArrayList<>();
        list.add("appleBack");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputCarList(list);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
