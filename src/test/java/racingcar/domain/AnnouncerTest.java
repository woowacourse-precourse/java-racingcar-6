package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class AnnouncerTest {
    private final List<String> RESULT_CARS = Arrays.asList("pobi", "woni", "jun");
    private Announcer announcer;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        announcer = new Announcer();
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void result_각_차수별_실행_결과_출력() {
        List resultList = Arrays.asList("---", "--", "-");
        announcer.result(resultList, RESULT_CARS);
        assertThat(output()).contains("pobi : ---", "woni : --", "jun : -");
    }

    @Test
    void winner_단일_우승자_결과_출력() {
        List winnerList = Arrays.asList("pobi");
        announcer.winner(winnerList);
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    void winner_다중_우승자_결과_출력() {
        List winnerList = Arrays.asList("pobi", "jun");
        announcer.winner(winnerList);
        assertThat(output()).contains("최종 우승자 : pobi, jun");
    }

}