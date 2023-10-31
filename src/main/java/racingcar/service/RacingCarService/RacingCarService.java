package racingcar.service.RacingCarService;

import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.racingcar.RacingCar;
import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarInitDto;

import java.util.Map;
import java.util.StringJoiner;

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

	public void playCarRacing() {
		Map<String, RacingCar> racingCarMap = this.getRacingCarMap();
		for (int i = 0; i < this.inputCarRaceTimes; i++) {
			racingCarMap.forEach((key, val) -> val.movingForward());
			printRacingStatus();
		}
	}

	private void printRacingStatus() {
		Map<String, RacingCar> racingCarMap = this.getRacingCarMap();
		racingCarMap.forEach((key, val) -> this.printMoveForward(key, val.getCarPosition()));
		System.out.println();
	}

	private void printMoveForward(String carName, Integer carPosition) {
		System.out.print(carName + " : ");
		for (int i = 0; i < carPosition; i++) {
			System.out.print("-");
		}
		System.out.println();
	}


	public void printCarRacingResult() {
		Map<String, RacingCar> racingCarMap = racingCarRepository.sortRacingCarMapByValueDesc(this.getRacingCarMap());
		StringJoiner stringJoiner = new StringJoiner(", ");
		Integer maxMoveForwardPosition = (racingCarMap.entrySet().iterator().next().getValue()).getCarPosition();
		racingCarMap.forEach((key, val) -> {
			if (val.getCarPosition() >= maxMoveForwardPosition) stringJoiner.add(key);
			// this.printMoveForward(key, val.getCarPosition());
		});
		System.out.print(InterfaceMsg.GAME_RESULT.getValue() + stringJoiner);
	}
}
