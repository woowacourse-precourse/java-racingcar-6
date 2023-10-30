package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMakerTest {
    @Test
    void 생성자_확인() {
        GameMaker gm = new GameMaker();
        System.out.print("total round = ");
        System.out.println(gm.totalRounds);

    }
}