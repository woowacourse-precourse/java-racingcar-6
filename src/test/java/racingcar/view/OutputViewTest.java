package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.CarDto;

public class OutputViewTest {
    OutputView outputView;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("실행 결과 메세지 출력 기능 테스트")
    @Test
    void testRaceResultMessage() {
        String expected = "\n실행 결과\n";

        outputView.raceResultMessage();
        System.setOut(System.out);

        assertEquals(expected, outputStream.toString());
    }

    @DisplayName("차수별 실행 결과 메세지 출력 기능 테스트")
    @Test
    void testRaceResultByOrderMessage() {
        List<CarDto> carList = new ArrayList<>();
        carList.add(new CarDto("pobi", 2));
        carList.add(new CarDto("woni", 4));
        carList.add(new CarDto("jun", 3));

        outputView.raceResultByOrderMessage(carList);
        System.setOut(System.out);

        String expected = "pobi : --\nwoni : ----\njun : ---\n\n";

        assertEquals(expected, outputStream.toString());
    }

    @DisplayName("차수별 실행 결과 메세지 출력 기능 테스트")
    @Test
    void testWinnerMessage() {
        List<String> carList = new ArrayList<>();
        carList.add("pobi");
        carList.add("jun");

        outputView.raceWinnerMessage(carList);
        System.setOut(System.out);

        String expected = "최종 우승자 : pobi, jun\n";

        assertEquals(expected, outputStream.toString());
    }
}
