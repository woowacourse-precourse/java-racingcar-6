package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    
    @Test
    void 자동차별_점수_초기화() {
        String[] carArray = new String[]{"kim", "yi", "park"};
        Race race = new Race();
        
        race.initScorePerCar(carArray);
        assertThat(race.scorePerCar).hasSize(3);
        assertThat(race.scorePerCar).contains(entry("kim", ""), entry("yi", ""), entry("park", ""));
    }
    
    @Test
    void 경주_진행() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] carArray = new String[]{"kim", "yi", "park"};
        Race race = new Race();
        
        race.initScorePerCar(carArray);
        race.tryNum = 3;
        
        race.raceProgress();
        assertThat(out.toString()).contains("실행 결과");
    }
    
    @Test
    void 우승자_한명_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();
        
        race.scorePerCar.put("kim", "---");
        race.scorePerCar.put("yi", "-");
        race.scorePerCar.put("park", "--");
        
        race.findWinner();
        assertThat(out.toString()).contains("최종 우승자 : kim").
        doesNotContain("park", "yi");
    }
    
    @Test
    void 우승자_여러명_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();
        
        race.scorePerCar.put("kim", "---");
        race.scorePerCar.put("yi", "---");
        race.scorePerCar.put("park", "-");
    
        race.findWinner();
        assertThat(out.toString()).contains("kim", "yi").
        doesNotContain("park");
    }
    
    @Test
    void 이름_입력_없을때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 이름중_빈_값이_있을때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,yi,,park", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 시도할_횟수_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim,yi,park", "aa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
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
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
