package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    @Test
    void 자동차_이동_테스트(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("junki"));
        carList.add(new Car("kijun"));
        carList.add(new Car("kujin"));

        NumberGenerator numberGenerator = new moveNumberGenerator();
        Racing racing = new Racing(numberGenerator);
        racing.moveCar(carList);

        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(1);
        assertThat(carList.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_정지_테스트(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("junki"));
        carList.add(new Car("kijun"));
        carList.add(new Car("kujin"));

        NumberGenerator numberGenerator = new stopNumberGenerator();
        Racing racing = new Racing(numberGenerator);
        racing.moveCar(carList);

        assertThat(carList.get(0).getPosition()).isEqualTo(0);
        assertThat(carList.get(1).getPosition()).isEqualTo(0);
        assertThat(carList.get(2).getPosition()).isEqualTo(0);
    }


    public static class moveNumberGenerator implements NumberGenerator{
        @Override
        public int createNumber(){
            return 4;
        }
    }

    public static class stopNumberGenerator implements NumberGenerator{
        @Override
        public int createNumber(){
            return 3;
        }
    }


}
