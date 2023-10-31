package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintTest extends NsTest {

    private final Print print = new Print();

    @Test
    void 차수별_레이스_실행_결과_확인() {

        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = getCar(cars, "car1");
        moveForward(car1, 2);

        //when
        print.showResult(cars);

        //then
        assertThat(output()).isEqualTo("car1 : --");
    }

    @Test
    void 최종_우승자_출력() {

        //given
        List<Car> cars = new ArrayList<>();

        Car car1 = getCar(cars, "car1");
        Car car2 = getCar(cars, "car2");
        Car car3 = getCar(cars, "car3");

        moveForward(car1, 1);
        moveForward(car2, 3);
        moveForward(car3, 3);

        List<String> winnersName = new ArrayList<>();
        winnersName.add("car2");
        winnersName.add("car3");

        //when
        print.showWinner(cars, winnersName);

        //then
        assertThat(output()).isEqualTo("최종 우승자 : car2, car3");
    }

    private Car getCar(List<Car> cars, String name) {
        Car car = new Car(name);
        cars.add(car);
        return car;
    }

    private void moveForward(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.forward();
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
