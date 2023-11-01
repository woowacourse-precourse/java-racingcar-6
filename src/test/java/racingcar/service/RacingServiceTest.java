package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    RacingService racingService = new RacingService();
    @Test
    void stringToList_쉼표를_구분자로_리스트_변환() {
        String input = "pobi,woni,jun";
        List<String> inputList = racingService.stringToList(input);

        assertThat(inputList).containsOnly("pobi", "woni", "jun");
    }
}
