package racingcar.domain;

public record CarName(String name) {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public CarName {
        isCarNameLengthValidate(name);
    }

    private void isCarNameLengthValidate(final String carName){
        if (carName.isEmpty() || carName.length() > CAR_NAME_LENGTH_MAX){
            throw new IllegalArgumentException("자동차이름은 1자리이상 5자 이하만 가능합니다.");
        }
    }

}