package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user=new User();
    @Test
    @DisplayName("자동차의 이름들은 쉼표를 기준으로 구분한다.")
    void 자동차이름_구분하기(){
        //given
        String[] cars={"car1","car2","car3"};
        List<String> originalCarsName=new ArrayList<>(Arrays.asList(cars));

        //when
        List<String> newCarsName=user.separateNames("car1,car2,car3");

        //then
        Assertions.assertThat(originalCarsName).isEqualTo(newCarsName);
    }

}