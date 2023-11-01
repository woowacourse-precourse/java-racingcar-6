package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void 자동차와_위치_올바르게_출력() {
        String[] carNames = {"po", "ta", "to"};
        int[] positions = {1, 2, 3};
        Result result = new Result();

        result.printRapResult(carNames, positions);
    }

    @Test
    void prinetWinnr() {

    }
}