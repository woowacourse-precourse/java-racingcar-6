package racingcar;

import java.util.List;

public class CheckExceptions {
	public void checkNotNull(List<String> carName) throws IllegalArgumentException {
		if(carName.size() <= 1 || carName.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름을 입력해주세요.");
		}
	}
	
	public void checkCarNameLength(List<String> carName) {
		for(String name : carName) {
			if(name.length() > 5) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 지정해야합니다.");
			}
		}
	}
	
	public void checkNumber(int attemptNumber) {
		try {
			if(attemptNumber <= 0) {
				throw new IllegalArgumentException("[ERROR] 올바른 수가 아닙니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
		}
	} 
}
