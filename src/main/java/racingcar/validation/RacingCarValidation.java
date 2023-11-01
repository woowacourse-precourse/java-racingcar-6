package racingcar.validation;

import racingcar.domain.CarList;

public class RacingCarValidation {

    private final int NAME_MAX_LENGTH = 5;
    private final int MIN_COUNT = 1;
    private final int MAX_COUNT = 10000;

    public void checkNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException("해당 이름은 크키가 5 초과입니다.");
    }

    public void checkNameBlank(String name){
        if(name.equals("") || name.startsWith(" "))
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
    }

    public int illegalValidation(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT)
            throw new IllegalArgumentException("해당 값은 범위 내에서 실행할 수 없는 값입니다. (1 ~ 10000)");

        return count;
    }

    public void checkCountDigit(String countString){
        if(!Character.isDigit(countString.charAt(0)))
            throw new IllegalArgumentException("해당 값은 숫자여야 합니다.");
    }

    public void checkDuplicateName(CarList carList, String name) {
        carList.getCarList().stream()
                .filter(car -> car.getName().equals(name))
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("중복된 이름입니다. : " + car.getName());
                });
    }
}
