package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;


class OutputViewTest {

    private ByteArrayOutputStream output;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        outputView = new OutputView();
    }

    @DisplayName("경주 게임 실행 결과 출력 테스트")
    @Test
    void printResult_test() throws Exception {
        // given
        List<CarName> carNames = List.of(new CarName("Car1"), new CarName("Car2"));
        Cars cars = new Cars(carNames);

        // when
        List<Car> carList = cars.getCarList();

        Field carPosition = Car.class.getDeclaredField("carPosition");
        carPosition.setAccessible(true);
        carPosition.set(carList.get(0), new CarPosition(3));
        carPosition.set(carList.get(1), new CarPosition(4));

        List<CarDto> carDtoList = CarDto.toDtoList(cars);
        outputView.printResult(carDtoList);

        // then
        assertEquals("Car1 : ---\nCar2 : ----\n\n", output.toString());
    }

    @DisplayName("최종 우승자 출력 테스트")
    @Test
    void printWinners_test() {
        List<CarName> winnerNames = new ArrayList<>();
        winnerNames.add(new CarName("Car1"));
        winnerNames.add(new CarName("Car2"));

        outputView.printWinners(winnerNames);
        assertEquals("최종 우승자 : Car1, Car2", output.toString());
    }
}
