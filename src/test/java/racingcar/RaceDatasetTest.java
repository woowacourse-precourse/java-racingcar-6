package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceDatasetTest {

    @BeforeEach
    public void setUpStream() {
        String mockInput = "alpha,bravo,charm\n5";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        Console.close();
        System.setIn(System.in);
    }

    @Test
    public void createDefaultPaceMap() {
        Machines machines = new Machines();
        PaceComputer paceComputer = new PaceComputer();

        machines.getInput();

        LinkedHashMap<String, Integer> testMap = paceComputer.createDefaultPaceMap(machines);

        assertThat(testMap.keySet()).containsExactly("alpha", "bravo", "charm");
        assertThat(testMap.values()).containsExactly(0, 0, 0);
    }

    @Test
    public void updatePaceMapValues() {
        Machines machines = new Machines();
        RaceLap raceLap = new RaceLap();
        PaceComputer paceComputer = new PaceComputer();
        LeaderBoard leaderBoard = new LeaderBoard();

        machines.getInput();
        raceLap.getInput();

        leaderBoard.showRace(machines, raceLap, paceComputer);

        List<LinkedHashMap<String, Integer>> paceMapList = leaderBoard.getPaceMapList();
        List<Integer> valuesInMap =
                paceMapList
                        .stream()
                        .flatMap(paceMap -> paceMap.values().stream())
                        .collect(Collectors.toList());
        List<Integer> generatedNumbers = paceComputer.getRandomNumberList();

        assertThat(valuesInMap).isEqualTo(generatedNumbers);
    }
}