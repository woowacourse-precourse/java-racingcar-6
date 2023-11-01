package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.Winners;
import data.DTO;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final List<String> list=new ArrayList<String>(Arrays.asList("joo","lim","sung"));
    private static final Map<String, Integer> records=new HashMap<String, Integer>(Map.of("joo",2,"lim",7,"sung",6));
	private static final String [] eachName= {"joo","lim","sung"};
	private static final data.DTO dto=new DTO(7, records, eachName);
    
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
    
    @Test
    void 이름이_null인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 횟수가_문자열인_경우의_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("min,sin,lim", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 횟수가_null인_경우의_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("min,sin,lim", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void init_records가_0만을_포함() {
    	String [] arr= {"lim","min","joo"};
        Map<String, Integer> result=new racingcar.Game().init_records(arr);

        assertThat(result).containsValues(0);
    }
    
    @Test
    void 기록_저장용_Map의_요소_확인() {
        Map<String, Integer> result=new racingcar.Game().init_records(eachName);

        assertThat(result).containsOnlyKeys("joo","sung","lim");
    }
    
    @Test
    void 점수만큼_하이픈_출력() {
    	int score=7;
    	String hyphens=new controller.RoundDriver(dto).typeConverter(score);
    	
    	assertThat(hyphens).isEqualTo("-------");
    }
    
    @Test
    void List의_Values를_콤마_단위의_문자열로_변환() {
    	String result=new Winners(dto).typeConverter(list);
    	
    	assertThat(result).isEqualTo("joo, lim, sung");
    }
    
    @Test
    void 최고점수_추출() {
    	int highest_score=new Winners(dto).getHighestScore();
    	
    	assertThat(highest_score).isEqualTo(7);
    }
    
    @Test
    void 우승자_추출() {
    	List<String> winners=new Winners(dto).whoAreTheWinners();
    	
    	assertThat(winners).contains("lim");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
