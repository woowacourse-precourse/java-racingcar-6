package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RaceTest {

    private List<Car> carList;

    @BeforeEach
    void setUp(){
        Car pobi = new Car("pobi");
        Car jae = new Car("jae");

        carList = new ArrayList<>();
        carList.add(pobi);
        carList.add(jae);
    }

    @Test
    @DisplayName("레이스를 자동차리스트와 함께 생성한다.")
    void create_race_with_carList(){
        Race race = new Race(carList,5);
        assertThat(race.getCarList()).isEqualTo(carList);
    }

    @Test
    @DisplayName("레이스 횟수가 양수가 아니면 예외를 던진다.")
    void exception_if_trial_is_not_positive_number(){
        assertThatThrownBy(() -> new Race(carList,0)).isInstanceOf(IllegalArgumentException.class);
    }



}