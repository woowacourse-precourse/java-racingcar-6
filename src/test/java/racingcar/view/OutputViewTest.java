package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final OutputView outputView = new OutputView();

    @Test
    void 결과출력_메시지를_알맞게_출력한다(){
        String expectedOutput = "실행 결과\n";
        String output = captureSystemOut(() -> outputView.printResultMessage());
        Assertions.assertEquals(expectedOutput,output);
    }

    @Test
    void 진행중인_레이싱_현황을_알맞게_출력한다(){
        List<Car> cars = Arrays.asList(
                new Car("pobi",3),
                new Car("woni",2),
                new Car("jun",0)
        );
        Racing racing = new Racing(cars,0);

        String expectedOutput = "pobi : ---\n" +
                "woni : --\n" +
                "jun : \n\n";
        String output = captureSystemOut(() -> outputView.printCarDistanceNow(racing));
        Assertions.assertEquals(expectedOutput,output);
    }

    @Test
    void 우승자가_한명일때_알맞게_출력한다(){
        List<String> winners = Arrays.asList("포비");
        String output = captureSystemOut(() -> outputView.printRacingWinner(winners));
        String expectedOutput = "최종 우승자 : 포비\n";
        Assertions.assertEquals(expectedOutput,output);
    }
    @Test
    void 우승자가_여러명일때_알맞게_출력한다(){
        List<String> winners = Arrays.asList("포비","워니");
        String output = captureSystemOut(() -> outputView.printRacingWinner(winners));
        String expectedOutput = "최종 우승자 : 포비, 워니\n";
        Assertions.assertEquals(expectedOutput,output);
    }

    private String captureSystemOut(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            runnable.run();
            return new String(outputStream.toByteArray(), Charset.defaultCharset());
        } finally {
            System.setOut(originalOut);
        }
    }
}