package racingcar.model;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private Judge judge;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup() {
        car1 = new Car("pobi");
        car2 = new Car("woni");
        judge = new Judge(asList(car1, car2));
    }

    @DisplayName("가장 멀리 간 자동차가 여러 대면 우승자도 여러 명이어야 한다.")
    @Test
    void multipleWinnersShouldBeDeclaredWhenTheyAreAtTheSamePosition() {
        // Given
        car1.move();
        car2.move();

        // When
        List<Car> winners = judge.decideWinner();

        // Then
        assertThat(winners).hasSize(2);
    }

    @DisplayName("가장 멀리 간 자동차가 우승해야 한다.")
    @Test
    void carThatMovedTheFarthestShouldWin() {
        // Given
        car1.move();
        car1.move();
        car2.move();

        // When
        List<Car> winners = judge.decideWinner();

        // Then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }
}