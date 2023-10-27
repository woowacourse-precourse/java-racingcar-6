package racingcar.exception.car_name;

import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

public class NotValidNameLengthException extends IllegalArgumentException {

    public NotValidNameLengthException(final String carName) {
        super("자동차 이름의 길이는 " + MAX_CAR_NAME_LENGTH.getValue() + "자리 이하여야 합니다. 다시 입력해주세요. 작성하신 자동차 이름: "
                + carName);
    }
}
