package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private String names = "july,june,joo";
    private Cars cars;
    private List<String> carsNames;
    private int moveNumber = 1;

    @BeforeEach
    void set() {
        this.cars = Cars.createCars(this.names);
        this.carsNames = this.cars.getCars().stream().map(Car::getName).toList();
    }

    @Test
    void 자동차_쉽표_이름_생성_확인() {
        String july = "july";
        String june = "june";
        String joo = "joo";
        assertThat(this.carsNames).contains(july);
        assertThat(this.carsNames).contains(june);
        assertThat(this.carsNames).contains(joo);
    }

    @Test
    void 자동차_경주_1회_후_최대_position() {
        int number = 1;

        for (Car car : this.cars.getCars()) {
            car.move(number);
            number = number * 2 + 1;
        }

        int maxPosition = this.cars.getMaxPosition();

        assertThat(maxPosition).isEqualTo(1);
    }

    @Test
    void 자동차_경주_1회_후_다중_우승자() {
        for (Car car : this.cars.getCars()) {
            car.move(this.moveNumber);
        }

        List<String> winners = this.cars.getWinner();

        assertThat(winners).isEqualTo(List.of("july", "june", "joo"));
    }

    @Test
    void 자동차_경주_1회_후_단일_우승자() {
        for (Car car : this.cars.getCars()) {
            car.move(this.moveNumber);
            this.moveNumber = this.moveNumber * 2 + 1;
        }

        List<String> winners = this.cars.getWinner();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).isEqualTo(List.of("joo"));
    }
}
