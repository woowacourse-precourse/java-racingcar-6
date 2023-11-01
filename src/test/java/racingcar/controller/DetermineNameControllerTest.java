package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DetermineNameControllerTest {

	@Test
	void testIsPossibleName_매서드_다섯_글자_초과된_이름_입력시_오류_발생() {
		DetermineNameController controller = new DetermineNameController();
		
		assertThrows(IllegalArgumentException.class, ()-> {
            controller.isPossibleName("abc,def,ghijkl");
        });
	}

}
