package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.Output;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class OutputTest {

    private static ByteArrayOutputStream outputMessage;
    Output output = new Output();
    Judge judge = new Judge();
    List<Car> cars;
    List<Car> winner;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
        car1 = new Car("amy",4);
        car2 = new Car("lisa",5);
        car3 = new Car("jenny",5);
        cars = new ArrayList<>(List.of(car1,car2));
        winner = new ArrayList<>();
    }

    @Test
    @DisplayName("자동차 실행 결과 알맞게 출력")
    public void printCarMove_1() {
        output.printProgress("amy",3);
        assertThat(outputMessage.toString()).contains("amy : ---");
    }

    @Test
    @DisplayName("자동차 실행 결과 알맞게 출력")
    public void printCarMove_2() {
        output.printProgress("amy",0);
        assertThat(outputMessage.toString()).contains("amy : ");
    }


    @Test
    @DisplayName("우승자 알맞게 출력")
    public void printWinner_1() {
        winner = judge.findWinner(cars);

        output.printWinner(winner);
        assertThat(outputMessage.toString()).contains("최종 우승자 : lisa");
    }

    @Test
    @DisplayName("여러 우승자 알맞게 출력")
    public void printWinner_2() {
        cars.add(car3);
        winner = judge.findWinner(cars);

        output.printWinner(winner);
        assertThat(outputMessage.toString()).contains("최종 우승자 : lisa, jenny");
    }

}