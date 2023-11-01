package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private Referee racingReferee;
    private List<Car> carList;

    private static final List<String> carNames = Arrays.asList("pobi", "woni", "jun");
    private Car car;
    @BeforeEach
    void setUp() {
        racingReferee = new Referee();
        carList = new ArrayList<>();
        for (String name:carNames){
            car = new Car(name);
            car.moveForward();
            carList.add(car);
        }
    }

    @Test
    void 단독_우승자_결과_생성(){
        carList.get(0).moveForward();
        racingReferee.findWinner(carList);
        assertThat(racingReferee.getResult()).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void 공동_우승자_결과_생성(){
        racingReferee.findWinner(carList);
        assertThat(racingReferee.getResult()).isEqualTo("최종 우승자 : pobi, woni, jun");
    }
}