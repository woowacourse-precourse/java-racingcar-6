package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.dto.WinnersDto;
import racingcar.service.GameService;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    @Test
    void 우승자_계산_테스트() {
        GameService gameService = new GameService(new TestRandomNumberGenerator(4));
        gameService.initializeGame("car1,car2,car3", "5");
        gameService.playRound(); // 모든 자동차가 전진
        WinnersDto winners = gameService.getWinners();
        assertEquals(Arrays.asList("car1", "car2", "car3"), winners.winners());
    }

    @Test
    void 우승자_출력_테스트() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        OutputView outputView = new OutputView();
        WinnersDto winners = new WinnersDto(Arrays.asList("car1", "car2", "car3"));
        outputView.printWinners(winners);
        assertEquals("최종 우승자 : car1, car2, car3\n", outContent.toString());
        System.setOut(System.out); // System.out 다시 원래대로 복구
    }
}
