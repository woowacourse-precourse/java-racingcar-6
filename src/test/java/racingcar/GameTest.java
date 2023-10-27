package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void arrToMap() {
        String[] arr = {"a", "b", "c"};
        Map<String, Integer> result = game.arrToMap(arr);

        assertThat(result).containsOnlyKeys("a", "b", "c");
        assertThat(result.values()).allMatch(value -> value == 0);
    }

    @Test
    void logic() {
        String[] nameArr = {"a", "b", "c"};
        Map<String, Integer> nameMap = game.arrToMap(nameArr);
        int number = 5;

        game.logic(nameArr, nameMap, number);

        assertThat(nameMap.values()).allMatch(value -> value >= 0 && value <= number);
    }

    @Test
    void judge() {
        Map<String, Integer> nameMap = game.arrToMap(new String[]{"a"});
        String name = "a";
        int number = 5;

        game.judge(name, nameMap);

        assertThat(nameMap.get(name)).isLessThanOrEqualTo(number);
    }
}