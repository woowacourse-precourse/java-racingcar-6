package racingcar.domain;

public class Exception {
    public void IllegalArgumentException(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    
}
