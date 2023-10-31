package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class GameTest {

    @Test
    void inputCarNameSplit() {
        String carName = "pobi,MJ,tjwls";
        String[] racerNameArrayExpected = {"pobi", "MJ", "tjwls"}; // 원하는 결과 배열
        String[] racerNameArraySplit = carName.split(",");

        // 공백을 제거하여 원하는 결과와 비교
        for (int i = 0; i < racerNameArraySplit.length; i++) {
            racerNameArraySplit[i] = racerNameArraySplit[i].trim();
        }

        assertArrayEquals(racerNameArrayExpected, racerNameArraySplit);

    }
}