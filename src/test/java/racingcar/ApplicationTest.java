package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest( // values 3으로 이뤄진 배열이 됨. 따라서 첫번째 pobi는 4, woni는 3의 값을 가짐.
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

    @Test
    void 이름을_알맞게_나누는지() {
        CallNsTestMethod testMethod = new CallNsTestMethod();
        String inputName = "aaa,bbb,ccc,ddd, cc.dd";
        testMethod.myCommand(inputName);
        RacingGame racingGame = new RacingGame();
        List<String> nameList = racingGame.inputCarName();
        assertThat(nameList.get(0)).isEqualTo("aaa");
        assertThat(nameList.get(1)).isEqualTo("bbb");
        assertThat(nameList.get(2)).isEqualTo("ccc");
        assertThat(nameList.get(3)).isEqualTo("ddd");
        assertThat(nameList.get(4)).isEqualTo("cc.dd");
    }

    @Test
    void 숫자값_잘못_입력시_예외_처리() {
        String inputName = "-5";
        CallNsTestMethod.myCommand(inputName);
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.inputCountNum()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤수가_0_9_사이인지() {
        RacingGame racingGame = new RacingGame();
        int ranNum = racingGame.getRandomNum();
        assertThat(ranNum).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    void 알맞게_전진하는지_확인() {
        RacingGame racingGame = new RacingGame();
        int inputNum1 = 4;
        int inputNum2 = 3;
        int inputNum3 = 9;
        int result1 = racingGame.forwardOrStop(inputNum1);
        int result2 = racingGame.forwardOrStop(inputNum2);
        int result3 = racingGame.forwardOrStop(inputNum3);
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(1);
    }

    @Test
    void 한_회차가_끝난_이후_총_이동거리_확인() {
        String[] nameArr = {"aa", "bb", "cc"};
        List<String> nameList =(Arrays.asList(nameArr));
        List<Integer> previousDistance = new ArrayList<>( Arrays.asList(1,3,0));
        List<Integer> expectedList = new ArrayList<>( Arrays.asList(2,3,0));
        RacingGame racingGame = new RacingGame();
        CallNsTestMethod.assertRandomNumberInRangeTest(
                ()->{
                    racingGame.getDistanceList(nameList, previousDistance);
                    assertThat(previousDistance).isEqualTo(expectedList);
                },
                4,0
        );
    }

    @Test
    void 처음부터_여러번_회차_진행_이후_이동거리_확인(){
        RacingGame racingGame = new RacingGame();
        String[] nameArr = {"aa", "bb", "cc"};
        List<String> nameList =(Arrays.asList(nameArr));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(2,1,1));
        CallNsTestMethod.assertRandomNumberInRangeTest(
                ()->{
                    List<Integer> distanceList = racingGame.runAllCycle(nameList, 3);
                    assertThat(distanceList).isEqualTo(expectedList);
                },
                4,0,0,0,0,0,4,4,4
        );
    }

    @Test
    void 최대값이_옳바르게_구해지는지_확인(){
        RacingGame racingGame = new RacingGame();
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,4,2,7,12,4,12,3,0));
        int max = racingGame.findMax(numList);
        assertThat(max).isEqualTo(12);

    }

    @Test
    void 우승자_이름_리스트(){
        RacingGame racingGame = new RacingGame();
        List<String> nameList = new ArrayList<>(Arrays.asList("aa","bb","cc"));
        List<Integer> distanceList = new ArrayList<>(Arrays.asList(2,2,0));
        List<String> winnerList = racingGame.chooseWinner(nameList, distanceList);
        List<String> expectedList = new ArrayList<>(Arrays.asList("aa","bb"));
        assertThat(winnerList).isEqualTo(expectedList);
    }

    @Test
    void 우승자_이름_문자열_변환(){
        RacingGame racingGame = new RacingGame();
        List<String> winnerList = new ArrayList<>(Arrays.asList("aa","bb","cc"));
        String winnerStr = racingGame.getWinnerNameString(winnerList);
        assertThat(winnerStr).isEqualTo("aa,bb,cc");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
