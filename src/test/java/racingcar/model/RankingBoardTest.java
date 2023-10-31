package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RankingBoardTest {
    private String[] carNames = {"car1", "car2"};
    private RankingBoard rankingBoard;

    @BeforeEach
    public void beforeEach(){
        this.rankingBoard = new RankingBoard(carNames);
    }


    @Test
    public void getRankingBoardTest(){
        assertEquals(rankingBoard.getRankingBoard().size(), carNames.length);
    }

    @Test
    public void getCarNamesTest(){
        assertEquals(rankingBoard.getCarNames(), new HashSet<>(List.of(carNames)));
    }

    @Test
    public void plusTest(){
        // when
        rankingBoard.plus(carNames[0]);
        // then
        assertEquals(1, rankingBoard.getRankingBoard().get(carNames[0]));
    }

    @Test
    public void getWinners(){
        assertEquals(new HashSet<>(List.of(carNames)), new HashSet<>(rankingBoard.getWinners()));
    }

}
