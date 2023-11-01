package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class AnnouncerTest {

    @Test
    void enterCarNamesSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        announcer.sayEnterCars();

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void enterAttemptSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        announcer.sayEnterAttempt();

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void introPlayResultSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        announcer.sayIntroPlayResult();

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("실행 결과");
    }

    @Test
    void carPositionSay() {
        String carName = "car";

        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        Car car = new Car(carName);
        while (car.getPosition() != 3) {
            car.run();
        }

        announcer.sayCarPosition(car);

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("car : ---");
    }

    @Test
    void winnerSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        List<Car> cars = Arrays.stream(new Car[]{new Car("car1"), new Car("car2")}).toList();
        Car car1 = cars.get(0);
        while (car1.getPosition() != 3) {
            car1.run();

        }
        announcer.sayWinner(cars);

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("최종 우승자 : car1");
    }

    @Test
    void winnersSay() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        Announcer announcer = new Announcer();
        List<Car> cars = Arrays.stream(new Car[]{new Car("car1"), new Car("car2")}).toList();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        while (car1.getPosition() != 3) {
            car1.run();
        }
        while (car2.getPosition() != 3) {
            car2.run();
        }
        announcer.sayWinner(cars);

        String say = os.toString().replace(System.getProperty("line.separator"), "");
        Assertions.assertThat(say).isEqualTo("최종 우승자 : car1, car2");
    }
}
