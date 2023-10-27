package racingcar;

public class Validator {
	
	private static final String INVALID_CAR_NAME_LENGTH = "차 이름은 5자 미만입니다.";
	private static final String INVALID_ENGLISH_CAR_NAME = "차 이름은 영어로 작성해 주십시오.";
	private static final String INVALID_MOVING_NUMBER = "이동 횟수는 숫자로만 입력해주세";
	
	public static void validateCarName(String carName) {
		validateCarNameLength(carName);
		validateEnglishCarName(carName);
		
	}
	
	public static void validateEnglishCarName(String carName) {
		for(char a : carName.toLowerCase().toCharArray()) {
			if(a<97 || a>122) {
				throw new IllegalArgumentException(INVALID_ENGLISH_CAR_NAME);
			}
		}
	}
	
	public static void validateCarNameLength(String carName) {
		if(carName.length()>5) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
		}
	}

	public static void valdateMovingNumber(String movingNumberStr) {
		try {
			int movingNumber = Integer.parseInt(movingNumberStr);
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_MOVING_NUMBER);
		}
	}

	
}
