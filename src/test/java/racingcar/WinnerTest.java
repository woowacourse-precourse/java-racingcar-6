package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private List<Car> carList;
    private Winner winner;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        winner = new Winner();
    }

    @Test
    void 경주에_참여한_자동차중에_우승자가_존재하는경우(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        for(int i=0;i<5;i++){
            for(Car car : carList){
                car.tryOneStep();
            }
        }


        assertThat(winner.setWinnerList(carList)).containsAnyOf(car1, car2, car3);
    }
    @Test
    void 공동_우승자가_존재하는경우(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertThat(winner.setWinnerList(carList)).isEqualTo(carList);
    }


}
