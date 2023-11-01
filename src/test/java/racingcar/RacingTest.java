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

    //inputCars 정상- 제대로 나눠졌는가 쉼표에 대해
    //tryGameOut 정상- 제대로 int가 return 되는가
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

    //inputCars 오류- 5자 초과 입력 시 오류가 나는가
    @Test
    void 이름에_대한_예외_처리_5자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("newton,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능하다")
        );
    }

    //tryGameOut 오류- 숫자로 표현 안된 경우
    @Test
    void 횟수에_대한_예외_처리_다른문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("C,java", "hh"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 숫자로 표현해야 한다")
        );
    }
    //tryGameOut 오류- 0이상 입력 필요(음수일때)
    @Test
    void 횟수에_대한_예외_처리_음수(){//코드 작성
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("C,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 0 이상으로 표현해야 한다")
        );
    }


    //resultArray 정상- 제대로 초기화됐는가- 길이로 판단
    @Test
    void 현재위치_초기화_정상_초기화() {
        List<Integer> check=new ArrayList<>();
        for(int i=0;i<CAR;i++)
            check.add(0);

        Assertions.assertThat(Application.resultArray(CAR))
                .isEqualTo(check);
    }

    //forwardCondition 정상- 1이나 0이 아닌 값이 반환값List<Integer>에 없어야함
    @Test
    void 랜덤_전진조건_확인_정상_contain01(){
        List<Integer> randomCondition=Application.forwardCondition(CAR);

        Assertions.assertThat(randomCondition).containsAnyOf(0,1);
    }
    //forwardCondition 정상- 랜덤값을 조정했을 때 제대로 1, 0 판단하는가, 길이도 맞아야함
    @Test
    void 랜덤_전진조건_확인_정상_길이(){
        List<Integer> randomCondition=Application.forwardCondition(CAR);

        Assertions.assertThat(randomCondition).hasSize(randomCondition.size());
    }

    //addRandomCondition 정상- 여기서 더한거랑 저거 결과값이랑 같은 지 판단
    @Test
    void 현재위치_전진조건_더하기_정상_더하기(){
        List<Integer> result=new ArrayList<>();
        result.add(positionWin.get(0)+condition.get(0));
        result.add(positionWin.get(1)+condition.get(1));

        Application.addRandomCondition(positionWin,condition);

        Assertions.assertThat(positionWin).isEqualTo(result);
    }

    //executionResult 정상- 몇 줄 출력됐는 지를 파악
    @Test
    void 각_실행결과_출력_정상_출력(){
        Application.executionResult(cars,positionWin);

        Assertions.assertThat(output().split(":")).hasSize(CAR+1);
    }

    //winnerSelect 정상- result 리스트에 따라(2명 중 1명, 2명 중 무승부)
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

    //winnerOutput 정상- 한 명 우승이랑 무승부 우승일 때 "," 개수 파악
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
