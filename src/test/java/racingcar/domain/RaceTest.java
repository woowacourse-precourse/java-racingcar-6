package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {

    private static ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUpStream() {
        byteArrayOutputStream = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(byteArrayOutputStream)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoreStream() {
        System.setOut(System.out); // 원상복귀
    }
    @Test
    void printWinner_우승자가_한명_이면_단독으로_출력하기() {
        Car pobi = Car.of("pobi", 5);
        Car woni = Car.of("woni", 1);
        Car jun = Car.of("jun", 3);
        List<Car> cars = List.of(pobi, woni, jun);
        Race race = new Race(cars);
        race.printWinner();
        assertEquals("최종 우승자 : pobi", byteArrayOutputStream.toString());
    }

    @Test
    void printWinner_우승자가_여려명_구분자_쉼표를_붙여서_출력하기() {
        Car pobi = Car.of("pobi", 5);
        Car woni = Car.of("woni", 1);
        Car jun = Car.of("jun", 5);
        List<Car> cars = List.of(pobi, woni, jun);
        Race race = new Race(cars);
        race.printWinner();
        assertEquals("최종 우승자 : pobi, jun", byteArrayOutputStream.toString());
    }

    @Test
    void printWinner_모든_사용자가_동점이면_모두_출력하기() {
        Car pobi = Car.of("pobi", 5);
        Car woni = Car.of("woni", 5);
        Car jun = Car.of("jun", 5);
        List<Car> cars = List.of(pobi, woni, jun);
        Race race = new Race(cars);
        race.printWinner();
        assertEquals("최종 우승자 : pobi, woni, jun", byteArrayOutputStream.toString());
    }
}