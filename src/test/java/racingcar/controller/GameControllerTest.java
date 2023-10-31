package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.enums.ValidationMsg;
import racingcar.service.ValidatorServiceTest;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest;

	@BeforeEach
	void setup() {
		validatorServiceTest = ValidatorServiceTest.getInstance();
	}

	@DisplayName("자동차_이름_string_null_입력_체크")
	@ParameterizedTest(name = "{displayName}")
	@NullSource
	void 자동차_이름_string_null_입력_체크(final String userInput) {
		assertThrows(IllegalArgumentException.class,
				() -> validatorServiceTest.validationCarName(userInput)
		);
	}


	@DisplayName("자동차_이름_string_empty_입력_체크")
	@ParameterizedTest(name = "{displayName}")
	@EmptySource
	void 자동차_이름_string_empty_입력_체크(final String userInput) {
		assertThrows(IllegalArgumentException.class,
				() -> validatorServiceTest.validationCarName(userInput)
		);
	}

	@DisplayName("자동차_이름_길이_유효성_검증")
	@ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
	@ValueSource(strings = {"pobi,javaji", "6글자가넘음,aaa", "123456,bbbaa"})
	void 자동차_이름_길이_유효성_검증(final String userInput) {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run(userInput);
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.CAR_NAME_OVER_FIVE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}


	@DisplayName("자동차_이름_중복_검증")
	@ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
	@ValueSource(strings = {"pobi, pobi", "javaji,javaji", "abcde,abcde", "12345,12345", "woni,woni"})
	void 자동차_이름_중복_검증(final String userInput) {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run(userInput);
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.NOT_DUPLICATE_NAME) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@DisplayName("자동차_레이싱_시도_회수_string_NullAndEmptySource_입력_체크")
	@ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
	@NullAndEmptySource
	void 자동차_레이싱_시도_회수_string_null_empty_입력_체크(final String userInput) {
		assertThrows(IllegalArgumentException.class,
				() -> validatorServiceTest.validationCarRaceTimes(userInput)
		);
	}

	@DisplayName("자동차_레이싱_시도_회수_입력값_0_검증")
	@Test
	void 자동차_레이싱_시도_회수_입력값_0_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("0");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.ZERO_TYPE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}


	@Override
	protected void runMain() {

	}
}