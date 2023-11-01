package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.NameLocationPair;
import racingcar.dto.PlayResultDTO;
import racingcar.dto.ResultEachTry;

class PlayResultViewTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @Test
    void 결과에_맞는_출력() {
        PlayResultDTO playResultDTO = new PlayResultDTO(
                Arrays.asList(
                        new ResultEachTry(1, Arrays.asList(
                                new NameLocationPair("go", 1),
                                new NameLocationPair("stay", 0))
                        ),
                        new ResultEachTry(2, Arrays.asList(
                                new NameLocationPair("go", 2),
                                new NameLocationPair("stay", 0))
                        ),
                        new ResultEachTry(3, Arrays.asList(
                                new NameLocationPair("go", 3),
                                new NameLocationPair("stay", 0))
                        )
                )
        );

        PlayResultView playResultView = new PlayResultView(playResultDTO);

        playResultView.view();

        assertEquals(
                "실행 결과\n"
                + "go : -\n"
                + "stay : \n"
                + "\n"
                + "go : --\n"
                + "stay : \n"
                + "\n"
                + "go : ---\n"
                + "stay : \n"
                + "\n",
                outputMessage.toString());
    }
}