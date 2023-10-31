package racingcar.service.RacingCarService;

import racingcar.domain.racingcar.RacingCar;
import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarInitDto;

import java.util.Map;

public class RacingCarService {
	private final RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();

	private Integer inputCarRaceTimes = 0;

	private RacingCarService() {
	}

	private static class RacingCarServiceHolder {
		private static final RacingCarService RACING_CAR_SERVICE = new RacingCarService();
	}

	public static RacingCarService getInstance() {
		return RacingCarServiceHolder.RACING_CAR_SERVICE;
	}

	public void saveRacingCar(RacingCarInitDto racingCarInitDto) {
		this.inputCarRaceTimes = racingCarInitDto.getInputCarRaceTimes();
		for (String carName : racingCarInitDto.getCarNameList()) {
			racingCarRepository.saveRacingCar(carName);
		}
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
