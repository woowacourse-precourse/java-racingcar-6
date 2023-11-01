package racingcar.controller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarControllerTest {

	private static final String SUCCESS_CAR_NAME = "aaa,bbb,ccc";
	private static final String FAIL_LENGTH_CAR_NAME = "aaaaaa,bbb,cc";
	private static final String FAIL_SPACE_CAR_NAME = "aa aa,bb,cc";

	private InputStream originalIn;

//	@BeforeEach
//	void setUp() {
//		originalIn = System.in;
//		System.out.println("시작");
//	}
//
//	@AfterEach
//	void tearDown() {
//		System.setIn(originalIn);
//		System.out.println("끝");
//
//	}
//
//	@Test
//	void testInputCar(){
//		testSaveCarName_Success();
//		testSaveCarName_Fail_Length();
//
//		testSaveCarName_Fail_Whitespace();
//
//	}
//
//	void testSaveCarName_Success() {
//		System.out.println("1");
//		RacingCarController controller = new RacingCarController();
//
//		System.setIn(new ByteArrayInputStream(SUCCESS_CAR_NAME.getBytes()));
//
//
//
//		assertThatCode(() -> controller.saveCarName())
//			.doesNotThrowAnyException();
//	}
//
//	void testSaveCarName_Fail_Length() {
//		System.out.println("2");
//		RacingCarController controller = new RacingCarController();
//
//		System.setIn(new ByteArrayInputStream(FAIL_LENGTH_CAR_NAME.getBytes()));
//
//		assertThatThrownBy(() -> controller.saveCarName())
//			.isInstanceOf(IllegalArgumentException.class)
//			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
//	}
//
//	void testSaveCarName_Fail_Whitespace() {
//		System.out.println("3");
//		RacingCarController controller = new RacingCarController();
//
//		System.setIn(new ByteArrayInputStream(FAIL_SPACE_CAR_NAME.getBytes()));
//
//		assertThatThrownBy(() -> controller.saveCarName())
//			.isInstanceOf(IllegalArgumentException.class)
//			.hasMessage("유효하지 않은 이름이 포함되어 있습니다.");
//	}

}
