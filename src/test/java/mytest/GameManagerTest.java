package mytest;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import racingcar.GameManager;
import racingcar.Input;
import racingcar.RandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    private GameManager gameManagerMoving;
    private GameManager gameManagerStopping;
    private Input input;

    @BeforeEach
    void 자동차_이름_라운드_진행수_랜덤수_고정() {
        input = new Input() {
            @Override
            public String carName() {
                return "bmw,benz";
            }

            @Override
            public int roundNumber() {
                return 3;
            }
        };

        RandomNumber moveNumber = new RandomNumber() {
            @Override
            public int generator() {
                return 4;
            }
        };
        RandomNumber stopNumber = new RandomNumber() {
            @Override
            public int generator() {
                return 3;
            }
        };

        gameManagerMoving = new GameManager(input, moveNumber);
        gameManagerStopping = new GameManager(input, stopNumber);
    }

    @Test
    void 모두이동_동점자() {
        gameManagerMoving.startGame();
        List<String> winners = gameManagerMoving.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("benz", "bmw");
    }

    @Test
    void 모두정지_동점자() {
        gameManagerStopping.startGame();
        List<String> winners = gameManagerStopping.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("benz", "bmw");
    }

    @Test
    void 하나는_이동_하나는_정지() {
        RandomNumber mixedNumber = new RandomNumber() {
            private int moveFlag;

            @Override
            public int generator() {
                if (moveFlag % 2 == 0) {
                    moveFlag++;
                    return 4; // 전진 조건 충족
                } else {
                    moveFlag++;
                    return 3; // 정지 조건 충족
                }
            }
        };

        GameManager gameManagerMixed = new GameManager(input, mixedNumber);
        gameManagerMixed.startGame();
        List<String> winners = gameManagerMixed.getWinners();

        assertThat(winners).containsExactly("benz");
    }
}


