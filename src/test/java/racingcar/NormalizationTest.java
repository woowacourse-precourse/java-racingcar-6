package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;

class NormalizationTest extends NsTest {
    
    @Test
    void 공백_문자열_정상화_처리() {
    	String input="  l    im,   s   i  n    , min  ,j oo";
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	
    	String [] arr=new controller.InputValues().provideNames();
    	
    	assertThat(arr).contains("lim","sin","min","joo");
    	System.setOut(null);
    }
    
    @Test
    void 입력_횟수_공백_정상화_처리() {
    	//setIn은 초기화하지 않으면 계속 누적
    	
    	String input=" 1    2 ";
    	int count=Integer.parseInt(new controller.InputValues().removeSpace(input));
    	
    	assertThat(count).isEqualTo(12);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
