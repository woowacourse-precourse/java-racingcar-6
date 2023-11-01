package view;

import static constants.OutputMessages.RACE_WINNERS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.Car;
import model.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @DisplayName("자동차 경주 결과는 정해진 형식에 맞게 출력한다.")
    @Test
    void printRacingResult() {
        Car car = new Car("test1");
        String racingResult = car.getName() + " : " + "-".repeat(car.getPosition());

        assertThat(racingResult).isEqualTo("test1 : ");
    }

    @DisplayName("우승자는 쉼표(,)를 기준으로 구분되어 정해진 형식에 맞게 출력한다.")
    @Test
    void printWinners() {
        Winner winner = new Winner();
        List<Car> carList = List.of(new Car("test1"), new Car("test2"), new Car("test3"));

        String winners = RACE_WINNERS + winner.getWinners(carList);

        assertThat(winners).isEqualTo("최종 우승자 : test1, test2, test3");
    }
}