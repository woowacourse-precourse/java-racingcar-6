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
import racingcar.domain.racingcar.RacingCar;
import racingcar.dto.RacingCarInitDto;
import racingcar.service.RacingCarService.RacingCarService;
import racingcar.service.RacingCarServiceTest;
import racingcar.service.ValidatorServiceTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest;
	private List<String> carNameList;
	private RacingCarServiceTest racingCarServiceTest;

	@BeforeEach
	void setup() {
		validatorServiceTest = ValidatorServiceTest.getInstance();
		carNameList = new ArrayList<>(Arrays.asList("pobi", "woni", "crong"));
		racingCarServiceTest = RacingCarServiceTest.getInstance();
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

	@Test
	void RacingCarServiceTest를_통해_RacingCarRepository에_여러_자동차_저장() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(1).build();

		racingCarServiceTest.initSaveRacingCar(racingCarInitDto);

		Map<String, RacingCar> racingCarMap = racingCarServiceTest.getRacingCarMap();
		racingCarMap.forEach((key, val) -> assertThat(carNameList).contains(key));
	}

	@Test
	void RacingCarService를_통해_RacingCarRepository에_여러_자동차_저장() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(1).build();

		RacingCarService.getInstance().initSaveRacingCar(racingCarInitDto);

		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> assertThat(carNameList).contains(key));
		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> val.movingForward());
		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> System.out.println(key + " : " + val.getCarPosition()));
	}

	@Override
	protected void runMain() {

	}
}