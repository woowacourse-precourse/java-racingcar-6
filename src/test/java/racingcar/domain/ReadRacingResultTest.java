package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadRacingResultTest {

    private LinkedHashMap<Entry<Integer, String>, Integer> racingResult;
    private ReadRacingResult readRacingResult;

    @BeforeEach
    void setUp() {
        racingResult = new LinkedHashMap<>();
        readRacingResult = new ReadRacingResult();
    }

    @Test
    void readHashMap() {
        //차가 1대일때
        Map.Entry<Integer, String> entry1 = new AbstractMap.SimpleEntry<>(0, "CarA");
        racingResult.put(entry1, 4);

        String result = readRacingResult.readHashMap(racingResult);
        assertThat(result).isEqualTo("CarA : ----\n");
        //차가 3대일때
        entry1 = new AbstractMap.SimpleEntry<>(0, "CarA");
        racingResult.put(entry1, 1);
        Map.Entry<Integer, String> entry2 = new AbstractMap.SimpleEntry<>(1, "CarB");
        racingResult.put(entry2, 3);
        Map.Entry<Integer, String> entry3 = new AbstractMap.SimpleEntry<>(2, "CarC");
        racingResult.put(entry3, 2);

        result = readRacingResult.readHashMap(racingResult);
        assertThat(result).isEqualTo("CarA : -\nCarB : ---\nCarC : --\n");
        //차가 0칸을 간 차가 있을때
        entry1 = new AbstractMap.SimpleEntry<>(0, "CarA");
        racingResult.put(entry1, 0);
        entry2 = new AbstractMap.SimpleEntry<>(1, "CarB");
        racingResult.put(entry2, 1);
        entry3 = new AbstractMap.SimpleEntry<>(2, "CarC");
        racingResult.put(entry3, 2);

        result = readRacingResult.readHashMap(racingResult);
        assertThat(result).isEqualTo("CarA : \nCarB : -\nCarC : --\n");




    }

    @Test
    void judgmentWinnerTest() {

        //1명 이상의 우승자
        Map.Entry<Integer, String> entry1 = new AbstractMap.SimpleEntry<>(0, "CarA");
        racingResult.put(entry1, 1);
        Map.Entry<Integer, String> entry2 = new AbstractMap.SimpleEntry<>(1, "CarB");
        racingResult.put(entry2, 3);
        Map.Entry<Integer, String> entry3 = new AbstractMap.SimpleEntry<>(2, "CarC");
        racingResult.put(entry3, 2);
        Map.Entry<Integer, String> entry4 = new AbstractMap.SimpleEntry<>(3, "CarD");
        racingResult.put(entry4, 1);
        Map.Entry<Integer, String> entry5 = new AbstractMap.SimpleEntry<>(4, "CarE");
        racingResult.put(entry5, 3);
        Map.Entry<Integer, String> entry6 = new AbstractMap.SimpleEntry<>(5, "CarF");
        racingResult.put(entry6, 0);
        String result = readRacingResult.judgmentWinner(racingResult);
        assertThat(result).isEqualTo("최종 우승자 : CarB, CarE");

        //1명의 우승자
        readRacingResult.winners = new ArrayList<>();
        Map.Entry<Integer, String> entry7 = new AbstractMap.SimpleEntry<>(5, "CarG");
        racingResult.put(entry7, 10);
        result = readRacingResult.judgmentWinner(racingResult);
        assertThat(result).isEqualTo("최종 우승자 : CarG");


    }

}