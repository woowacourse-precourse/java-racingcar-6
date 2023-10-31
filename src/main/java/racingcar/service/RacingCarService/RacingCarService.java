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

	private StringBuffer playStateStringBuffer = new StringBuffer();

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

	public String playCarRacing() {
		playStateStringBuffer.setLength(0); // 초기화

		Map<String, RacingCar> racingCarMap = this.getRacingCarMap();
		for (int i = 0; i < this.inputCarRaceTimes; i++) {
			racingCarMap.forEach((key, val) -> val.movingForward());
			playRacingStatus();
		}
		return playStateStringBuffer.toString();
	}

	private void playRacingStatus() {
		Map<String, RacingCar> racingCarMap = this.getRacingCarMap();
		racingCarMap.forEach((key, val) -> this.playMoveForward(key, val.getCarPosition()));
		playStateStringBuffer.append(System.lineSeparator()); // OS에 맞는 개행 문자 추가
	}

	private void playMoveForward(String carName, Integer carPosition) {
		playStateStringBuffer.append(carName + " : ");
		for (int i = 0; i < carPosition; i++) {
			playStateStringBuffer.append("-");
		}
		playStateStringBuffer.append(System.lineSeparator()); // OS에 맞는 개행 문자 추가
	}


	public String printCarRacingResult() {
		StringBuffer printCarRacingResult = new StringBuffer();
		Map<String, RacingCar> racingCarMap = racingCarRepository.sortRacingCarMapByValueDesc(this.getRacingCarMap());
		StringJoiner stringJoiner = new StringJoiner(", ");
		Integer maxMoveForwardPosition = (racingCarMap.entrySet().iterator().next().getValue()).getCarPosition();
		racingCarMap.forEach((key, val) -> {
			if (val.getCarPosition() >= maxMoveForwardPosition) stringJoiner.add(key);
		});
		printCarRacingResult.append(InterfaceMsg.GAME_RESULT.getValue() + stringJoiner);

		return printCarRacingResult.toString();
	}
}
