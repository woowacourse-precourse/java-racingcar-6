package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    Referee referee=new Referee();
    @Test
    @DisplayName("우승자를 가려낸다.")
    void 우승자_확정(){
        //given
        User user=new User();
        List<Car> cars=user.nameForCar("car1,car2,car3");
        List<Car> expectedWinner=new ArrayList<>(Arrays.asList(cars.get(2)));

        //when
        for(int i=0;i<cars.size();i++){
            for(int j=0;j<=i;j++){
                cars.get(i).moveForward();
            }
        }

        List<Car> winner=referee.decideWinner(cars);

        //then
        Assertions.assertThat(winner).isEqualTo(expectedWinner);
    }

    @Test
    @DisplayName("우승자가 두명 이상인지 판단할 수 있다.")
    void 우승자_숫자_판단(){
        //given
        User user=new User();
        List<Car> cars=user.nameForCar("carA,carB");
        for(int i=0;i<2;i++){
            cars.get(i).moveForward();
            cars.get(i).moveForward();
        }

        //when
        boolean isTwoOrMore=referee.isNumberOfWinnerTwoOrMore(referee.decideWinner(cars));

        //then
        Assertions.assertThat(isTwoOrMore).isEqualTo(true);
    }



}