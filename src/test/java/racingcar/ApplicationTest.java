package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.Car;
import model.InputImpo;
import model.OutputImpo;
import validators.InputValidator;

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
    
    @Test
    void 입력값이_비어있을때_예외_처리() {
    	String input = "";
    	
    	assertThatThrownBy(() -> InputValidator.checkNull(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("입력값이 비어있습니다.");
    }
    
    // 직접 짠 테스트 코드
    @Test
    void 이동횟수에_잘못된_값_입력_예외_처리() {
    	String input = "이동";
    	
    	assertThatThrownBy(() -> InputValidator.checkCarMoveFomat(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("입력값을 잘못 입력하셨습니다.");
    }
    
    @Test
    void 이동횟수가_0일때_예외_처리() {
    	int input = 0;
    	
    	assertThatThrownBy(() -> InputValidator.checkCarMove(input))
	    	.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이동횟수는 0 이상을 지정해주세요.");
    }

    @Test
    void 문자열을_리스트로_변경() {
    	String text = "닌텐도, 스위치";
    	List<String> list = InputImpo.changeList(text);
    	
    	assertThat(list).containsExactly("닌텐도", "스위치");
    }
    
    @Test
    void 문자열을_숫자로_변경() {
    	String textInt = "2";
    	int i = InputImpo.changeInt(textInt);
    	
    	assertThat(i).isEqualTo(2);
    }
    
    @Test
    void 경기_과정_출력() {
    	Car car = new Car("자동차1");
    	List<Integer> list = new ArrayList<>();
    	list.add(5);
    	list.add(2);
    	list.add(6);
    	car.setNumberList(list);
    	
    	for(int i = 0; i < list.size(); i++) {
    		OutputImpo.showMovingProcess(car, i);
    	}
    	assertThat(car.getForword()).isEqualTo(2);
    }
    
    @Test
    void 우승자_이동값_출력() {
    	Car player1 = new Car("자동차1");
    	Car player2 = new Car("자동차2");
    	player1.setForword(5);
    	player2.setForword(4);
    	
    	List<Car> carList = new ArrayList<>();
    	carList.add(player1);
    	carList.add(player2);
    	
    	int max = OutputImpo.WinnerValue(carList);
    	assertThat(max).isEqualTo(5);
    }
    
    @Test
    void 우승자_리스트_생성() {
    	Car player1 = new Car("자동차1");
    	Car player2 = new Car("자동차2");
    	player1.setForword(5);
    	player2.setForword(4);
    	
    	List<Car> carList = new ArrayList<>();
    	carList.add(player1);
    	carList.add(player2);
    	
    	List<String> winnerList = new ArrayList<>();
		for(Car car : carList) {
			OutputImpo out = new OutputImpo(winnerList);
			winnerList = out.addWinner(car, 5);
		}
		
		assertThat(winnerList.get(0)).isEqualTo("자동차1");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
