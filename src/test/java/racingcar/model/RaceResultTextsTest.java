package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.StringFormatter;

class RaceResultTextsTest {

    @DisplayName("경주 결과들을 하나의 문자열로 통합한다.")
    @Test
    void convertOneLine() {
        // given
        RaceResultTexts raceResultTexts = createFirstRaceResults();

        // when
        String result = raceResultTexts.convertOneLine();
        String expected = String.format("apple : -%nbear : %ncake : -%n");

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("경주 결과들을 줄바꿈을 통해 구별하며 하나의 문자열로 통합한다.")
    @Test
    void convertTotalOneLine() {
        // given
        RaceResultTexts multiRaceResults =
                createMultiRaceResults(createFirstRaceResults(), createSecondRaceResults());

        // when
        String result = multiRaceResults.convertTotalOneLine();
        String expected = String.format("apple : -%nbear : %ncake : -%n\n"
                + "apple : --%nbear : %ncake : -%n");

        // then
        assertThat(result).isEqualTo(expected);
    }

    private RaceResultTexts createFirstRaceResults() {
        List<String> list = new ArrayList<>();
        list.add(StringFormatter.raceResultFormat("apple", "-"));
        list.add(StringFormatter.raceResultFormat("bear", ""));
        list.add(StringFormatter.raceResultFormat("cake", "-"));
        return new RaceResultTexts(list);
    }

    private RaceResultTexts createSecondRaceResults() {
        List<String> list = new ArrayList<>();
        list.add(StringFormatter.raceResultFormat("apple", "--"));
        list.add(StringFormatter.raceResultFormat("bear", ""));
        list.add(StringFormatter.raceResultFormat("cake", "-"));
        return new RaceResultTexts(list);
    }

    private RaceResultTexts createMultiRaceResults(RaceResultTexts first, RaceResultTexts second) {
        List<String> list = new ArrayList<>();
        list.add(first.convertOneLine());
        list.add(second.convertOneLine());
        return new RaceResultTexts(list);
    }
}
