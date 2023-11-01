package racingcar.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

    ByteArrayOutputStream outputStream;
    Referee referee;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        referee = new Referee();
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void announcementWinners() {
        List<Car> carList = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        referee.announcementWinners(carList);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : Car1, Car2, Car3");
    }
}