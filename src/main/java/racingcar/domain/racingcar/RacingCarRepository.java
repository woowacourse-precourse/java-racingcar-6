package racingcar.domain.racingcar;

import racingcar.dto.RacingCarDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarRepository {
	private Map<String, RacingCar> racingCarMap = new LinkedHashMap<>();

	// start: Singleton Holder
	private RacingCarRepository() {
	}

	private static class RacingCarRepositoryHoler {
		private static final RacingCarRepository RACING_CAR_REPOSITORY = new RacingCarRepository();
	}

	public static RacingCarRepository getInstance() {
		return RacingCarRepositoryHoler.RACING_CAR_REPOSITORY;
	}

	public void saveRacingCar(String carName) {
		racingCarMap.put(carName, new RacingCar(carName));
	}

	public void initSaveRacingCar(RacingCarDto racingCarDto) {
		racingCarMap.put(racingCarDto.getCarName(), new RacingCar(racingCarDto.getCarName()));
	}

	public void initSaveRacingCar(String carName) {
		racingCarMap.put(carName, new RacingCar(carName));
	}

	public RacingCar getRacingCarByName(String carName) {
		return racingCarMap.get(carName);
	}

	public void movingForwardByName(RacingCarDto racingCarDto) {
		racingCarMap.get(racingCarDto.getCarName()).movingForward();
	}

	public Map<String, RacingCar> getRacingCarMap() {
		return racingCarMap;
	}
}
