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

    @DisplayName("동일 이동 거리의 차가 2대 이상 일 경우 컴마(',')를 추가하여 이름을 출력한다.")
    @Test
    void getWinnerNamesWithWinnerDelim() {
        //given
        addCars();
        moveCar(1);
        moveCar(2);

        //when
        referee.selectWinnerList(carList);
        OutputView outputView = new OutputView();

        //then
        Assertions.assertThat(outputView.getWinnerNames(carList))
                .isEqualTo("최종 우승자 : 홍길동, 포비");
    }

    @DisplayName("자동차 마일리지로 변경 ")
    @Test
    void distanceToPosition() {

        //given
        addCars();
        moveCar(1);
        moveCar(1);
        moveCar(1);
        Car car = carList.get(1);

        //then
        Assertions.assertThat(OutputView.distanceToPosition(car))
                .isEqualTo("---");
    }

    @DisplayName("자동차 마일리지가 없을 경우 ")
    @Test
    void zeroDistanceToPosition() {
        //given
        addCars();
        Car car = carList.get(1);

        //then
        Assertions.assertThat(OutputView.distanceToPosition(car))
                .isEqualTo("");
    }

    @DisplayName("자동차 이름을 구분자와 함께 출력하는 기능 ")
    @Test
    void carNameWithDelim() {
        //given
        addCars();
        Car car = carList.get(1);

        //then
        Assertions.assertThat(OutputView.nameConcatDelim(car))
                .isEqualTo("홍길동 : ");
    }

    @DisplayName("붉은 색 신호등 출력")
    @Test
    void printRedLight() {
        //given
        String redLight = OutputView.redLight();

        //then
        Assertions.assertThat(redLight).isEqualTo("빨간 불 입니다!! [이동하는 차량이 없습니다.] ");
    }
}
