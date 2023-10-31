package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarsTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final List<String> stringCarName = new ArrayList<>();
    StubNineNumberGenerator stubNineNumberGenerator = new StubNineNumberGenerator();

    @BeforeEach
    void setUpCars() {
        stringCarName.add("pobi");
        stringCarName.add("woni");
    }

    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("racing 메서드는 숫자값이4 이상일때 자동차의 포지션이 +1 되어야합니다.")
    @Test
    void racing() {
        Cars cars = new Cars(stringCarName);
        // 숫자가 9만 생성되는 stubNineNumberGenerator 주입
        cars.racing(stubNineNumberGenerator);

        List<Car> currentCarList = cars.getCurrentCarList();
        List<Integer> collect = currentCarList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(collect).isEqualTo(Arrays.asList(1, 1));
    }

    @DisplayName("getFurthestCarNameList메서드는 포지션이 가장 큰 자동차들의 이름 리스트를 반환한다.")
    @Test
    void getFurthestCarNameList() {
        Cars cars = new Cars(stringCarName);
        // 숫자가 9만 생성되는 stubNineNumberGenerator 주입
        cars.racing(stubNineNumberGenerator);
        List<String> furthestCarNameList = cars.getFurthestCarNameList();

        List<Car> currentCarList = cars.getCurrentCarList();
        List<String> collect = currentCarList.stream()
                .filter(car -> car.getPosition() == 1)
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(furthestCarNameList).containsExactlyInAnyOrderElementsOf(collect);
    }

    @DisplayName("자동차들의 상태를 정상적으로 출력하는지 검사한다.")
    @Test
    void printCarsStatus() {
        setUpOutputStream();

        Cars cars = new Cars(stringCarName);
        cars.printCarsStatus();

        assertThat(output.toString().trim()).isEqualTo("pobi : \r\nwoni :");

        restoreOutputStream();
    }

    // 숫자가 9만 생성되는 stubNineNumberGenerator
    static class StubNineNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 9;
        }
    }
}