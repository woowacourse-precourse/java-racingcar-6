package racingcar.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.RacingStatus;
import racingcar.dto.request.CarNameReq;
import racingcar.dto.request.TryNumberReq;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarController {

	CarNameReq carNameReq = new CarNameReq();
	TryNumberReq tryNumberReq = new TryNumberReq();

	RacingCarView racingCarView = new RacingCarView();
	RacingCarService racingCarService = new RacingCarService();

	public void startGame() {
		racingCarView.printIntro();
		saveCarName();
		racingCarView.printTryNumber();
		saveTryNumber();
		racingCarView.printStatusIntro();
		RacingStatus racingStatus = racingCarService.saveRacingCarStatus(carNameReq.getCarName(),
			tryNumberReq.getTryNumber());
		for (int i = 0; i < racingStatus.getTryNumber(); i++) {
			roofGame(racingStatus);
		}
		racingCarView.printResult(racingStatus.findMaxValueFromCarStatus());

	}

	public void roofGame(RacingStatus racingStatus) {
		runStatusView(racingCarService.updateCarStatus(racingStatus).getCarStatus());
	}

	public void runStatusView(Map<String, Integer> carStatus) {
		racingCarView.printCarStatus(carStatus);
	}

	private void saveCarName() {
		carNameReq.setCarName(readLine());
		validateCarName(carNameReq.getCarName());
	}

	private void saveTryNumber() {
		tryNumberReq.setTryNumber(readLine());
		validateTryNumber(tryNumberReq.getTryNumber());
	}


	private static void validateTryNumber(String tryNumber) {
		if (tryNumber.isEmpty()) {
			throw new IllegalArgumentException("값을 입력하세요.");
		}
		checkTryNumberIsNumber(tryNumber);
	}

	private static void checkTryNumberIsNumber(String tryNumber) {
		if (tryNumber.matches("^\\d+$")) {
			int tryNumberInt = Integer.parseInt(tryNumber);

			checkTryNumberIsPositive(tryNumberInt);
		} else {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

	private static void checkTryNumberIsPositive(int tryNumberInt) {
		if (tryNumberInt <= 0) {
			throw new IllegalArgumentException("입력값은 0보다 커야 합니다.");
		}
	}

	public static void validateCarName(String carName) {
		validateEmpty(carName);

		String[] names = carName.split(",");
		Set<String> nameSet = new HashSet<>();
		for (String name : names) {
			checkLengthAndSpace(name);
			duplicateName(nameSet, name);
		}
	}

	private static void validateEmpty(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("입력이 비어 있습니다.");
		}
	}

	private static void duplicateName(Set<String> nameSet, String name) {
		if (!nameSet.add(name)) {
			throw new IllegalArgumentException("중복된 이름이 포함되어 있습니다.");
		}
	}

	private static void checkLengthAndSpace(String name) {
		if (name.isEmpty() || name.length() > 5 || containsWhitespace(name)) {
			throw new IllegalArgumentException("유효하지 않은 이름이 포함되어 있습니다.");
		}
	}

	public static boolean containsWhitespace(String s) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(s);
		return matcher.find();
	}

}
