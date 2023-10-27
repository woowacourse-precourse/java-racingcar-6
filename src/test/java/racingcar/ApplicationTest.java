package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

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
    void 이름길에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름_중복에_따른_예외_처리() {
    	assertSimpleTest(() ->
        		assertThatThrownBy(() -> runException("apple,apple,grape", "1"))
        				.isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 유효한_이름_없음_예외_처리() {
    	assertSimpleTest(() ->
        		assertThatThrownBy(() -> runException("  ,  ", "1"))
        				.isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_및_빈값_제거() {
    	String carInput = "apple  ,  , grape ,,  ";
    	
    	String[] separate = carInput.split(",");
    	List<String> carList = new ArrayList<>();
    	
    	for(int i = 0; i < separate.length; i++) {
    		carList.add(separate[i].trim());
    	}
    	while(carList.remove(String.valueOf("")));
    	
    	assertThat(carList).containsExactly("apple", "grape");	
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
