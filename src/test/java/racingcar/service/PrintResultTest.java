package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

class PrintResultTest extends NsTest {
    private final PrintResult printResult;

    public PrintResultTest() {
        this.printResult = new PrintResult();
    }

    @DisplayName("최종 우승자가 1명인 경우")
    @Test
    void onlyOneWinner() {
        //given
        List<Car> cars = createCar();
        cars.stream().filter(car -> car.getName().equals("pobi"))
                .forEach(car -> car.move());

        //when
        printResult.printWinner(cars);

        //then
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @DisplayName("최종 우승자가 2명인 경우")
    @Test
    void twoWinner() {
        //given
        List<Car> cars = createCar();
        cars.stream().filter(car -> car.getName().equals("pobi"))
                .forEach(car -> car.move());

        cars.stream().filter(car -> car.getName().equals("woni"))
                .forEach(car -> car.move());

        //when
        printResult.printWinner(cars);

        //then
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    private List<Car> createCar() {
        Car pobi = Car.createCar("pobi");
        Car woni = Car.createCar("woni");
        Car jun = Car.createCar("jun");
        return List.of(pobi, woni, jun);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}