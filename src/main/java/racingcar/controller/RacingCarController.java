package racingcar.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.dto.request.CarNameReq;
import racingcar.dto.request.TryNumberReq;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarController {

	CarNameReq carNameReq = new CarNameReq();
	TryNumberReq tryNumberReq = new TryNumberReq();

	public void saveCarName() {
		System.out.println("입력 테스트");
		String carName = readLine();
		validateCarName(carName);
		System.out.println(carName+"성공");
	}

	public static void validateCarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("입력이 비어 있습니다.");
		}

		String[] names = carName.split(",");
		for (String name : names) {
			checkLengthAndSpace(name);
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

	private void getCarName(String carName) {
		carNameReq.setCarName(carName);
	}

	private void getTryNumber(int tryNumber) {
		tryNumberReq.setTryNumber(tryNumber);
	}
}
