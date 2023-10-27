package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private Game game;
    private IO io;

    @BeforeEach
    void setUp() {
        io = new IO();
        game = new Game(io);
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

    @Test
    public void findMaxVal_성공() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 25);
        map.put("c", 30);
        map.put("b", 35);

        int maxVal = game.findMaxVal(map);
        assertThat(maxVal).isEqualTo(35);
    }

    @Test
    public void findMaxVal_실패() {
        Map<String, Integer> emptyMap = new HashMap<>();

        assertThatThrownBy(() -> game.findMaxVal(emptyMap))
                .isInstanceOf(IllegalArgumentException.class);
    }
}