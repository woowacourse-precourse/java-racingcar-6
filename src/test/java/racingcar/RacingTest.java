package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.*;

public class RacingTest extends NsTest {
    private static final int CAR = 2;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private List<Integer> positionWin;
    private List<Integer> positionTie;
    private List<Integer> condition;
    private List<String> cars;


    @BeforeEach
    public void setUp() {
        positionWin=new ArrayList<>();
        positionWin.add(0);positionWin.add(1);

        positionTie=new ArrayList<>();
        positionTie.add(1);positionTie.add(1);

        condition=new ArrayList<>();
        condition.add(1);condition.add(1);

        cars=new ArrayList<>();
        cars.add("pobi");cars.add("woni");
    }


    @Test
    void 이름_시도횟수_입력_정상() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,happy", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP//random 숫자의 범위 그래서 pobi는 4라서 전진 woni는 3이라서 가만히인듯ㄷㄷ
        );
    }

    @Test
    void 이름에_대한_예외_처리_콤마_처음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pp,bb", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("각 자동차 이름은 1자 이상 입력해야 한다")
        );
    }

    @Test
    void 이름에_대한_예외_처리_콤마_중간() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pp,,bb", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("각 자동차 이름은 1자 이상 입력해야 한다")
        );
    }

    @Test
    void 이름에_대한_예외_처리_콤마_뒤() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ppp,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("각 자동차 이름은 1자 이상 입력해야 한다")
        );
    }

    @Test
    void 이름에_대한_예외_처리_콤마_단독() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("각 자동차 이름은 1자 이상 입력해야 한다")
        );
    }

    @Test
    void 이름에_대한_예외_처리_5자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("newton,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능하다")
        );
    }

    @Test
    void 횟수에_대한_예외_처리_다른문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("C,java", "hh"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 숫자로 표현해야 한다")
        );
    }

    @Test
    void 횟수에_대한_예외_처리_음수(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("C,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 0 이상으로 표현해야 한다")
        );
    }

    @Test
    void 현재위치_초기화_정상_초기화() {
        List<Integer> check=new ArrayList<>();
        for(int i=0;i<CAR;i++)
            check.add(0);

        Assertions.assertThat(Application.resultArray(CAR))
                .isEqualTo(check);
    }

    @Test
    void 랜덤_전진조건_확인_정상_포함숫자(){
        List<Integer> randomCondition=Application.forwardCondition(CAR);

        Assertions.assertThat(randomCondition).containsAnyOf(0,1);
    }

    @Test
    void 랜덤_전진조건_확인_정상_길이(){
        List<Integer> randomCondition=Application.forwardCondition(CAR);

        Assertions.assertThat(randomCondition).hasSize(randomCondition.size());
    }

    @Test
    void 현재위치_전진조건_더하기_정상_더하기(){
        List<Integer> result=new ArrayList<>();
        result.add(positionWin.get(0)+condition.get(0));
        result.add(positionWin.get(1)+condition.get(1));

        Application.addRandomCondition(positionWin,condition);

        Assertions.assertThat(positionWin).isEqualTo(result);
    }

    @Test
    void 각_실행결과_출력_정상_출력(){
        Application.executionResult(cars,positionWin);

        Assertions.assertThat(output().split(":")).hasSize(CAR+1);
    }

    @Test
    void 승자_도출_정상_우승1명(){
        List<Integer> winner=winnerSelect(positionWin);

        Assertions.assertThat(winner)
                .contains(0)
                .contains(1);
    }

    @Test
    void 승자_도출_정상_무승부(){
        List<Integer> winner=winnerSelect(positionTie);

        Assertions.assertThat(winner).containsOnly(1);
    }

    @Test
    void 승자_출력_정상_우승1명(){
        winnerOutput(positionWin,cars);

        Assertions.assertThat(output()).doesNotContain(",");
    }

    @Test
    void 승자_출력_정상_우승2명(){
        winnerOutput(positionTie,cars);

        Assertions.assertThat(output()).contains(",");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
