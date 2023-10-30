package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    void makeCars() {
        List<String> list = new ArrayList<>();
        list.add("pobi");
        list.add("woni");

        Race.makeCars(list);

        assertEquals(2, Race.carRace.size());
    }
}