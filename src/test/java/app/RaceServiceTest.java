package app;

import app.domain.Race;
import app.service.RaceService;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class RaceServiceTest {

    private final RaceService raceService = new RaceService();

    private void command(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    private void close() {
        Console.close();
    }

    @Test
    void getCarName() {
        String[] input = {"a,b,c", "aaaa,bbbb,cccc", "asdd,a,b,ddd", "a"};
        command(input);

        for (String inputCarName : input) {
            Race race = raceService.getCarName();
            String[] split = inputCarName.split(",");
            Map<String, Integer> raceMap = race.testGetRace();

            for (String name : split) {
                assertThat(raceMap.keySet().contains(name)).isTrue();
            }
        }
    }


    @Test
    void getMaxNum() {
        String[] input = {"a,b,c"};
        command(input);

        Race race = raceService.getCarName();
        Map<String, Integer> raceMap = race.testGetRace();

        String[] split = input[0].split(",");
        raceMap.put(split[0], raceMap.getOrDefault(split[0], 0) + 3);
        raceMap.put(split[1], raceMap.getOrDefault(split[1], 0) + 4);
        raceMap.put(split[2], raceMap.getOrDefault(split[2], 0) + 2);
        int maxNum = race.getMaxNum();

        assertThat(maxNum).isEqualTo(4);

    }

    @Test
    void getRank() {
        String[] input = {"a,b,c"};
        command(input);

        Race race = raceService.getCarName();
        Map<String, Integer> raceMap = race.testGetRace();

        String[] split = input[0].split(",");
        raceMap.put(split[0], raceMap.getOrDefault(split[0], 0) + 4);
        raceMap.put(split[1], raceMap.getOrDefault(split[1], 0) + 4);
        raceMap.put(split[2], raceMap.getOrDefault(split[2], 0) + 2);
        int maxNum = race.getMaxNum();

        String[] rank = race.getWinner(maxNum);
        assertThat(rank).isEqualTo(new String[]{"a", "b"});

    }
}