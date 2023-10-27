package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        IO io = new IO();
        game = new Game(io);
    }

    @Test
    void generateMapFromArray() {
        String[] arr = {"a", "b", "c"};
        Map<String, Integer> result = game.generateMapFromArray(arr);

        assertThat(result).containsOnlyKeys("a", "b", "c");
        assertThat(result.values()).allMatch(value -> value == 0);
    }

    @Test
    void run() {
        String[] nameArr = {"a", "b", "c"};
        Map<String, Integer> nameMap = game.generateMapFromArray(nameArr);
        int number = 5;

        game.run(nameArr, nameMap, number);

        assertThat(nameMap.values()).allMatch(value -> value >= 0 && value <= number);
    }

    @Test
    void determineCarMove() {
        Map<String, Integer> nameMap = game.generateMapFromArray(new String[]{"a"});
        String name = "a";
        int number = 5;

        game.determineCarMove(name, nameMap);

        assertThat(nameMap.get(name)).isLessThanOrEqualTo(number);
    }

    @Test
    public void findMaxValueInMap_성공() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 25);
        map.put("c", 30);
        map.put("b", 35);

        int maxVal = game.findMaxValueInMap(map);
        assertThat(maxVal).isEqualTo(35);
    }

    @Test
    public void findMaxValueInMap_실패() {
        Map<String, Integer> emptyMap = new HashMap<>();

        assertThatThrownBy(() -> game.findMaxValueInMap(emptyMap))
                .isInstanceOf(IllegalArgumentException.class);
    }
}