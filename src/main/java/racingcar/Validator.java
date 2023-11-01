package racingcar;

import java.util.List;

public class Validator {
	
	private static final String INVALID_CAR_NAME_LENGTH = "차 이름은 5자 미만입니다.";
	private static final String INVALID_ENGLISH_CAR_NAME = "차 이름은 영어로 작성해 주십시오.";
	private static final String INVALID_CAR_NAME_SIZE = "차 이름을 2개 이상 적어주세요.";
	private static final String INVALID_MOVING_NUMBER = "이동 횟수는 숫자로만 입력해주세";
	
	
	//자동차 이름 유효성 검
	public static void validateCarName(String carName) {
		validateCarNameLength(carName);
		validateEnglishCarName(carName);
		
	}
	
	//자동차 이름이 영어가 아닌 경우 예외 처리
	public static void validateEnglishCarName(String carName) {
		for(char a : carName.toLowerCase().toCharArray()) {
			if(a<97 || a>122) {
				throw new IllegalArgumentException(INVALID_ENGLISH_CAR_NAME);
			}
		}
	}
	
	//자동차 이름의 길이가 5를 초과했을 경우 예외 처리
	public static void validateCarNameLength(String carName) {
		if(carName.length() > 5) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
		}
	}
	
	//자동차 이름이 한 개만 적혔을 경우 예외 처리 
	public static void validateOnlyOneCarName(List<String> carList) {
		if(carList.size() == 1) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_SIZE);			
		}
	}
	
	//이동 입력 횟수가 숫자가 아닌 경우 예외 처리
	public static void validateMovingNumber(String movingNumberStr) {
		try {
			int movingNumber = Integer.parseInt(movingNumberStr);
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_MOVING_NUMBER);
		}
	}

}
