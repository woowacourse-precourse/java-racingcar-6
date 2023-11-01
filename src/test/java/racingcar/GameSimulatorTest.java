package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameSimulatorTest extends InputTest {
    @Test
    @DisplayName("차의 게임 진행상태 확인")
    public void testPrintCarStatus() {
        List<Car> cars = new ArrayList<>();
        cars.add(0, new Car(Collections.singletonList("Car1"), 2));
        cars.add(1, new Car(Collections.singletonList("Car2"), 3));
        cars.add(2, new Car(Collections.singletonList("Car3"), 5));

        // 가상의 출력을 캡처하기 위한 StringWriter 생성
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream virtualOut = new PrintStream(output);

        System.setOut(virtualOut);

        GameSimulator gameSimulator = new GameSimulator();
        gameSimulator.printCarStatus(cars);

        String expectedOutput = "Car1 : --\nCar2 : ---\nCar3 : -----\n\n";
        expectedOutput = expectedOutput.replaceAll("\n", "\r\n");

        assertThat(expectedOutput).isEqualTo(output.toString());
    }

    @Test
    @DisplayName("단독 우승자 확인 테스트")
    public void testPrintOneWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(0, new Car(Collections.singletonList("Car1"), 1));
        cars.add(1, new Car(Collections.singletonList("Car2"), 2));
        cars.add(2, new Car(Collections.singletonList("Car3"), 3));

        // 가상의 출력을 캡처하기 위한 StringWriter 생성
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream virtualOut = new PrintStream(output);

        System.setOut(virtualOut);

        // GameSimulator 객체 생성 및 시뮬레이션 실행
        GameSimulator simulator = new GameSimulator();
        simulator.printCarStatus(cars);
        simulator.printWinners(cars);

        // 예상 출력 결과를 확인
        String expectedOutput = "Car1 : -\nCar2 : --\nCar3 : ---\n\n최종 우승자 : Car3";
        expectedOutput = expectedOutput.replaceAll("\n", "\r\n");

        // 실제 출력과 기대 출력을 비교
        assertThat(expectedOutput).isEqualTo(output.toString());
    }

    @Test
    @DisplayName("우승자가 2명일때 확인 테스트")
    public void testPrintTwoWinner() {
        List<Car> cars = new ArrayList<>();
        cars.add(0, new Car(Collections.singletonList("Car1"), 1));
        cars.add(1, new Car(Collections.singletonList("Car2"), 4));
        cars.add(2, new Car(Collections.singletonList("Car3"), 4));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream virtualOut = new PrintStream(output);

        System.setOut(virtualOut);

        // GameSimulator 객체 생성 및 시뮬레이션 실행
        GameSimulator simulator = new GameSimulator();
        simulator.printCarStatus(cars);
        simulator.printWinners(cars);

        // 예상 출력 결과를 확인
        String expectedOutput = "Car1 : -\nCar2 : ----\nCar3 : ----\n\n최종 우승자 : Car2, Car3\n";
        expectedOutput = expectedOutput.replaceAll("\n", "\r\n");

        // 실제 출력과 기대 출력을 비교
        assertThat(expectedOutput).isEqualTo(output.toString());
    }


}
