package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

@DisplayName("레이싱 게임 우승자 결정 룰 테스트")
class RefereeTest {

    @DisplayName("자동차의 이동 거리를 기준으로 내림차순 정렬하여 우승자를 선정한다.")
    @Test
    void selectWinnerListByDistanceDescending() {
        //given
        List<Car> list = Arrays.asList(new Car("김민수"), new Car("홍길동"), new Car("최종민"));
        Car car = list.get(1);
        Referee referee = new Referee();

        //when
        car.accel();
        List<Car> cars = referee.selectWinnerList(list);

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("홍길동");
    }

    @DisplayName("자동차의 이동 거리를 기준으로 내림차순 정렬하여 우승자를 선정한다. 모든 자동차의 이동 거리가 같을 경우 정렬하지 않는다.")
    @Test
    void eachDistanceSameNotTry() {
        //given
        List<Car> list = Arrays.asList(new Car("김민수"), new Car("홍길동"), new Car("최종민"));
        Referee referee = new Referee();

        //when
        List<Car> cars = referee.selectWinnerList(list);

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("김민수");
    }

    @DisplayName("우승자 이름을 반환한다.")
    @Test
    void getWinnerName() {
        //given
        List<Car> list = Arrays.asList(new Car("김민수"), new Car("홍길동"), new Car("최종민"));
        Referee referee = new Referee();
        Car car = list.get(1);

        car.accel();
        OutputView outputView = new OutputView();
//        when
        String winnerName = outputView.winnerName(referee.selectWinnerList(list));

//        then
        Assertions.assertThat(winnerName).isEqualTo("최종 우승자 : 홍길동");
    }
}
