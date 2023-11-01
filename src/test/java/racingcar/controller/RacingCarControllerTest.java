package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RacingCarControllerTest {

	private static final String SUCCESS_CAR_NAME = "aaa,bbb,ccc" + "\n" + "6" +"\n";
	private static final String FAIL_LENGTH_CAR_NAME = "aaaaaa,bbb,cc" +"\n";
	private static final String FAIL_SPACE_CAR_NAME = "aa aa,bb,cc" + "\n";
	private static final String FAIL_DUPLICATE_CAR_NAME = "aa,aa,cc" + "\n";

	@BeforeAll
	static void setUp() {
		String testText = SUCCESS_CAR_NAME + FAIL_LENGTH_CAR_NAME + FAIL_SPACE_CAR_NAME +
			FAIL_DUPLICATE_CAR_NAME;
		System.setIn(new ByteArrayInputStream(testText.getBytes()));
	}
	@org.junit.jupiter.api.Order(1)
	@Test
	void testSaveCarName_Success() {
		RacingCarController controller = new RacingCarController();
		assertThatCode(() -> controller.startGame())
			.doesNotThrowAnyException();
	}

	@org.junit.jupiter.api.Order(2)
	@Test
	void testSaveCarName_Fail_Length() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
	}

	@org.junit.jupiter.api.Order(3)
	@Test
	void testSaveCarName_Fail_Whitespace() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
	}

	@org.junit.jupiter.api.Order(4)
	@Test
	void testSaveCarName_Fail_Duplicate_Name() {
		RacingCarController controller = new RacingCarController();
		assertThatThrownBy(() -> controller.startGame())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 이름이 포함되어 있습니다.");
	}




}