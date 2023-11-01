package racingcar.carRacing.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.car.model.Car;
import racingcar.carRacing.service.CarRacingInputService;

public class CarRacingTest {

    private final CarRacingInputService carRacingInputService = new CarRacingInputService();

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @Test
    void 자동차_이름_목록으로_자동차_객체_리스트_저장() {
        String input = "a,b,c,d,e,f,g,h,i,j,k";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> carNames = carRacingInputService.inputCarNameList();
        CarRacing carRacing = new CarRacing();
        List<Car> cars;

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        carRacing.initCarList(carNames);
        cars = carRacing.getCarList();
        for (Car car : cars) {
            System.out.println(car.getName() + ",");
        }
        assertThat(out.toString()).contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
    }
}
