package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    @DisplayName("자동차에 이름을 부여한다.")
    void 이름_부여(){
        List<String> carsName=user.separateNames("car1,car2,car3,car4");
        List<Car> cars=user.nameForCar("car1,car2,car3,car4");
        for(int i=0;i<4;i++){
            Assertions.assertThat(cars.get(i).getName().equals(carsName.get(i))).isEqualTo(true);
        }
    }



}