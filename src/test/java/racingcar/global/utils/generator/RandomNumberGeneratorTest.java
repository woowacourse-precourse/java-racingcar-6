package racingcar.global.utils.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    public void testGenerate() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int numberOfGames = 4;
        int nameCount = 3;

        List<List<Integer>> result = randomNumberGenerator.generate(numberOfGames, nameCount);


        assertEquals(nameCount, result.size());
        for (List<Integer> innerNumbers : result) {
            assertEquals(numberOfGames, innerNumbers.size());
        }
    }

}