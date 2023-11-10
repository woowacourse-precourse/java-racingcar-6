package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
    void 자동차_이름만큼_리스트_생성() {
        assertThat(this.cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 모든_자동차의_초기_position_0_확인() {
        assertThat(this.cars.sumPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_경주_1회_후_최대_position() {
        int number = 1;

        for (Car car : this.cars.getCars()) {
            car.move(number);
            number = number * 2 + 1;
        }

        Car maxPositionCar = this.cars.getMaxPositionCar();

        assertThat(maxPositionCar).extracting("position").isEqualTo(1);
    }

    @Test
    void 자동차_경주_1회_후_다중_우승자() {
        for (Car car : this.cars.getCars()) {
            car.move(this.moveNumber);
        }

        List<String> winners = this.cars.getWinnerNames();

        assertThat(winners).isEqualTo(List.of("july", "june", "joo"));
    }

    @Test
    void 자동차_경주_1회_후_단일_우승자() {
        for (Car car : this.cars.getCars()) {
            car.move(this.moveNumber);
            this.moveNumber = this.moveNumber * 2 + 1;
        }

        List<String> winners = this.cars.getWinnerNames();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).isEqualTo(List.of("joo"));
    }

    @Test
    void 사용자가_입력한_round_만큼_경기_결과_확인() {
        int roundNumber = 3;
        List<List<String>> results = new ArrayList<>();

        IntStream.range(0, roundNumber).forEach(i -> {
            this.cars.carsMove();
            results.add(this.cars.carsResult());
        });

        assertThat(results.size()).isEqualTo(3);
    }
}
