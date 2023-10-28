package racingcar.model.car;

import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import java.util.Comparator;

//TODO: 허무맹랑할 수 있는 이야기이지만, 자동차 경주에 말이 들어온다면?? 해당 경우도 한번 고민해보기
public class Car {

    private static final String MARK = "-";
    //TODO: 어떻게 선언할까
    private final Comparator<Car> comparator = new OrderByPosition();

    protected final String name;
    protected Integer currentPosition;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move() {
        if (Accelerator.canMoveForward()) {
            currentPosition++;
        }
    }

    private void validate(String value) {
        //TODO: 다른 방식으로 구현체 가져오기
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    public int compareTo(Car car) {
        return comparator.compare(this, car);
    }

    //TODO: 게터 지양
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " : " + MARK.repeat(this.currentPosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }
}
