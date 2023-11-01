package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class CarServiceTest {
    CarService carService = new CarService();

    @Test
    void inputCarName() {
        String input = "carA,carB";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] strings = carService.inputCarName();
        Assertions.assertThat("carA").isEqualTo(strings[0]);
        Assertions.assertThat("carB").isEqualTo(strings[1]);
    }

    @Test
    void createCarImpl() {
        String[] carNames = {"carA","carB","carC"};
        ArrayList<Car> carImpl = carService.createCarImpl(carNames);
        for (Car oneCar : carImpl) {
            Assertions.assertThat(oneCar).isInstanceOf(Car.class);
        }
    }

    @Test
    void tryingNumber() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int i = carService.tryingNumber();
        Assertions.assertThat(4).isEqualTo(i);
    }

    @Test
    void tryingNumber_exception() {
        String input = "four";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {carService.tryingNumber();}
        );
    }

    @Test
    void findWinner() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("carA"));
        carList.add(new Car("carB"));
        carList.add(new Car("carC"));
        carList.get(0).addDistance();
        carList.get(0).addDistance();
        carList.get(1).addDistance();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        carService.findWinner(carList);
        Assertions.assertThat("최종 우승자 : carA").isEqualTo(out.toString());
    }
}