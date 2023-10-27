package study.serviceTest;

import org.junit.jupiter.api.Test;
import racingcar.service.GameGuideTextPrintService;

public class GameGuideTextPrintServiceTest {

    @Test
    void inputCarNameTest() {
        GameGuideTextPrintService gameGuideTextPrintService = new GameGuideTextPrintService();
        gameGuideTextPrintService.inputCarName();
    }

    @Test
    void inputTryNumberTest() {
        GameGuideTextPrintService gameGuideTextPrintService = new GameGuideTextPrintService();
        gameGuideTextPrintService.inputTryNumber();
    }

    @Test
    void gameResult() {
        GameGuideTextPrintService gameGuideTextPrintService = new GameGuideTextPrintService();
        gameGuideTextPrintService.gameResult();
    }

    @Test
    void gameWinner() {
        GameGuideTextPrintService gameGuideTextPrintService = new GameGuideTextPrintService();
        gameGuideTextPrintService.gameWinner();
    }

}
