package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    private Winner winner;

    @BeforeEach
    void setup() {
        winner = new Winner();
    }

    @Test
    void 우승자_찾기_1명인_경우() {

        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("Pobi");
        carNameList.add("jung");

        ArrayList<List<String>> carProgress = new ArrayList<>();
        carProgress.add(List.of("---"));
        carProgress.add(List.of("----"));
        ArrayList<String> finalWinners = winner.getFinalWinner(carNameList, carProgress);
        assertEquals(1, finalWinners.size());
    }

    @Test
    void 우승자_찾기_2명이상인_경우() {
        Winner winner = new Winner();

        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("Pobi");
        carNameList.add("jung");
        carNameList.add("leo");
        ArrayList<List<String>> carProgress = new ArrayList<>();
        carProgress.add(List.of("-----"));
        carProgress.add(List.of("-----"));
        carProgress.add(List.of("-----"));
        ArrayList<String> finalWinners = winner.getFinalWinner(carNameList, carProgress);
        assertEquals(3, finalWinners.size());
    }

}
