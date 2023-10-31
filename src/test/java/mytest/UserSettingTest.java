package mytest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

import racingcar.model.Car;
import racingcar.utils.UserList;

public class UserSettingTest {
    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차_생성_태스트() {
        assertThatCode(()-> new Car("pobi"))
                .doesNotThrowAnyException();
    }


}
