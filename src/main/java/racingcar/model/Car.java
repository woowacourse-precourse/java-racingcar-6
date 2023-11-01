package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position;
	
	private static final int MAX_CARNAME_LENGTH = 5;
	private static final int MIN_CARNAME_LENGTH = 1;
	private static final String NAME_FORMAT = "^[a-zA-Z0-9]*$";
		
	public Car(String name) {
		vallidateNameLength(name);
		validateNameCharacter(name);
		this.name = name;
		this.position = 0;
	}

	private void vallidateNameLength(String name) {
		if(name.length() > MAX_CARNAME_LENGTH || 
				name.length() < MIN_CARNAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
		}
	}
	
	private void validateNameCharacter(String name) {
		if (!name.matches(NAME_FORMAT)) {
            throw new IllegalArgumentException("자동차 이름에는 알파벳과 숫자만 사용할 수 있습니다.");
        }
	}
	
	
	public void move() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			position++;
		}
	}
	
}
