package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest extends NsTest {

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

    @Test
    @DisplayName("5자 초과인 이름은 불가능하다.")
    void 이름_사이즈_확인x(){
        //given
        String name="Caaaaar";

        //when
        boolean pass=user.validateName(name);

        //then
        Assertions.assertThat(pass).isEqualTo(false);
    }

    @Test
    @DisplayName("5자 이하인 이름은 가능하다.")
    void 이름_사이즈_확인o(){
        //given
        String name="Caaar";

        //when
        boolean pass=user.validateName(name);

        //then
        Assertions.assertThat(pass).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차의 이름이 없으면 예외를 발생한다.")
    void 이름_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hello, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 숫자가 2대 미만이면 예외를 발생시킨다.")
    void 자동차_숫자_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }



}