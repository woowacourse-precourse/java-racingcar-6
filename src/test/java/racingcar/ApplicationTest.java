package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    void TestvalidateLength() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void TestvalidateDuplicates() {
    	assertSimpleTest(() ->
        		assertThatThrownBy(() -> runException("apple,apple,grape", "1"))
        				.isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void TestvalidateNotEmpty() {
    	assertSimpleTest(() ->
        		assertThatThrownBy(() -> runException("  ,  ", "1"))
        				.isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void TestvalidateTimes() {
    	assertSimpleTest(() ->
        		assertThatThrownBy(() -> runException("apple,grape", "123"))
        				.isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void TestinputCarList() {
    	String carInput = "apple  ,  , grape ,,  ";
    	List<String> carList = Arrays.stream(carInput.split(","))
    			.map(car -> car.trim())
    			.filter(car -> !car.isEmpty())
    			.toList();
    	
    	assertThat(carList).containsExactly("apple", "grape");	
    }
    
    @Test
    void TestsetCarsOnStart() {
    	List<String> carList = Arrays.asList("apple", "grape");
    	List<Integer> results = IntStream.range(0, carList.size())
    			.mapToObj(result -> 0)
    			.collect(Collectors.toList());
    	
    	assertThat(results).containsExactly(0, 0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
