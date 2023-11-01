package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingService;

public class ApplicationUnitTest {

    @Test
    void 입력한_자동차_이름만큼_객체생성_확인() throws NoSuchFieldException, IllegalAccessException {
        //given
        RacingService racingService = new RacingService();
        Field carNameField = RacingService.class.getDeclaredField("carName");
        carNameField.setAccessible(true);
        List<String> carNames = List.of("car1", "car2", "car3");
        carNameField.set(racingService, carNames);

        //when
        racingService.makeCar();
        Field carsField = RacingService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        List<Car> cars = (List<Car>) carsField.get(racingService);

        //then
        assertThat(cars).hasSize(3);
        for (int i=0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(carNames.get(i));
        }


    }

    @Test
    void 경기_횟수에_대한_예외처리() {
        //given
        RacingService racingService = new RacingService();
        String input = "a\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThrows(IllegalArgumentException.class, racingService::inputRacingTime);
    }

    @Test
    void 다중_우승자_확인() throws NoSuchFieldException, IllegalAccessException {
        // given
        RacingService racingService = new RacingService();
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        for (Car car : cars) {
            Field carDistanceField = car.getClass().getDeclaredField("distance");
            carDistanceField.setAccessible(true);
            carDistanceField.set(car, 1);
        }

        Field carsField = RacingService.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        carsField.set(racingService, cars);

        Field maxDistanceField = RacingService.class.getDeclaredField("maxDistance");
        maxDistanceField.setAccessible(true);
        maxDistanceField.set(racingService, 1);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        racingService.printWinner();

        // then
        String expectedOutput = "최종 우승자 : car1, car2\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

}
