package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Referee;

class OutputViewTest {
    private List<Car> carList;
    private Referee referee;

    @BeforeEach
    public void generate() {
        carList = new ArrayList<>();
        referee = new Referee();
        addCars();
    }

    void addCars() {
        carList.add(new Car("김민수"));
        carList.add(new Car("홍길동"));
        carList.add(new Car("포비"));
    }

    void moveCar(int index) {
        carList.get(index).accel();
    }

    @DisplayName("이동 거리가 가장 긴 차의 이름을 반환한다.")
    @Test
    void getWinnerName() {
        //given
        addCars();
        moveCar(1);

        //when
        referee.selectWinnerList(carList);
        OutputView outputView = new OutputView();

        //then
        Assertions.assertThat(outputView.getWinnerNames(carList))
                .isEqualTo("최종 우승자 : 홍길동");
    }
}
