package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    // isMoveAble에 대한 테스트
//    void 전진여부에_대한_예외_처리() {
//        //given
//        CarInput carInput = CarInput.of("test1,test2");
//        RacingGame racingGame = new RacingGame.Builder()
//                .carInput(carInput)
//                .tryCount(1)
//                .build();
//
//        test.moveForward();
//    }

    @Test
    void 게임_종료_전_우승자_확인_금지() {
        //given
        CarInput carInput = CarInput.of("test1,test2");
        RacingGame racingGame = new RacingGame.Builder()
                .carInput(carInput)
                .tryCount(1)
                .build();

        // when + then
        assertThatThrownBy(racingGame::getWinner)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.GAME_NOT_FINISHED);
    }



    @Test
    // atPosition
    void 자동차_위치_확인() {
        Car car = new Car("test");
        car.moveForward();

        assertThat(car.atPosition(1)).isTrue();
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
