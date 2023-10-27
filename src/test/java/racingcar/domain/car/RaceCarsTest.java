package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import racingcar.util.CarListConverter;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RaceCarsTest{

    @Test
    @DisplayName("Collections.unmodifiableList()를 사용해서 꺼낸 리스트는 add, remove를 사용시 예외가 발생한다.")
    public void getCars() {
        // given
        String[] names = {"pobi", "haen", "jun"};
        RaceCars raceCars = createRaceCars(names);
        // when // then
        List<Car> cars = raceCars.getCars();

        assertThatThrownBy(() -> cars.add(new Car("test")))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> cars.remove(cars.get(0)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @TestFactory
    @DisplayName("경기에 승리한 자동차의 이름들을 출력할 수 있다.")
    public Collection<DynamicTest> getWinningCarNames() {

        return List.of(
                DynamicTest.dynamicTest("단독 우승일 경우", () -> {
                    //given
                    String[] names = {"haen"};
                    RaceCars raceCars = createRaceCars(names);
                    //when
                    String winningCarNames = raceCars.getWinningCarNames();
                    //then
                    assertThat(winningCarNames).isEqualTo("haen");

                }), DynamicTest.dynamicTest("공동 우승일 경우", () -> {
                    //given
                    String[] names = {"haen", "pobi"};
                    RaceCars raceCars = createRaceCars(names);
                    //when
                    String winningCarNames = raceCars.getWinningCarNames();
                    //then
                    assertThat(winningCarNames).isEqualTo("haen, pobi");
                }));
    }

    @TestFactory
    @DisplayName("입력값이 4이상이면 자동차를 움직일 수 있다.")
    public Collection<DynamicTest> executeRace() {

        return List.of(
                DynamicTest.dynamicTest(("입력값이 4미만이면 정지한다."), () -> {
                    //given
                    RaceCars raceCars = createRaceCars(new String[]{"haen"});
                    //when
                    raceCars.executeRace(3);
                    Car car = raceCars.getCars().get(0);
                    //then
                    assertThat(car.getMoveCount()).isZero();
                }),
                DynamicTest.dynamicTest(("입력값이 4이상이면 전진한다."), () -> {
                    //given
                    RaceCars raceCars = createRaceCars(new String[]{"haen"});
                    //when
                    raceCars.executeRace(4);
                    Car car = raceCars.getCars().get(0);
                    //then
                    assertThat(car.getMoveCount()).isOne();
                }));
    }

    private RaceCars createRaceCars(String[] names) {
        List<Car> cars = CarListConverter.convertStringArrayToCarList(names);
        return new RaceCars(cars);
    }

}