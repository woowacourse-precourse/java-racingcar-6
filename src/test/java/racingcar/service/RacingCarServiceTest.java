package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.racingcar.RacingCar;
import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingCarInitDto;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarServiceTest {
	private RacingCarDto racingCarDto;
	private RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();

	private Integer inputCarRaceTimes = 0;

	// start: Singleton Holder
	private RacingCarServiceTest() {
	}

	private static class RacingCarServiceTestHolder {
		private static final RacingCarServiceTest RACING_CAR_SERVICE_TEST = new RacingCarServiceTest();
	}

	public static RacingCarServiceTest getInstance() {
		return RacingCarServiceTestHolder.RACING_CAR_SERVICE_TEST;
	}
	// end: Singleton Holder


	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장()")
	@ParameterizedTest(name = "{index}. {displayName} - carName : parameter - {0}")
	@ValueSource(strings = {"pobi2", "pobi3"})
	void repository에_RacingCar_저장(String carName) {
		RacingCarDto racingCarDto = new RacingCarDto(carName);
		racingCarRepository.initSaveRacingCar(racingCarDto);
		assertEquals(racingCarDto.getCarName(), racingCarRepository.getRacingCarByName(carName).getCarName());
	}


	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장된_자동차_전진_또는_정지()")
	@Test
	void repository에_RacingCar_저장된_자동차_전진_또는_정지() {
		racingCarDto = RacingCarDto.builder().carName("pobi2").build();
		racingCarRepository.initSaveRacingCar(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
	}

	public void initSaveRacingCar(RacingCarInitDto racingCarInitDto) {
		this.inputCarRaceTimes = racingCarInitDto.getInputCarRaceTimes();
		for (String carName : racingCarInitDto.getCarNameList()) {
			racingCarRepository.initSaveRacingCar(carName);
		}
	}

	public Map<String, RacingCar> getRacingCarMap() {
		return racingCarRepository.getRacingCarMap();
	}
}
