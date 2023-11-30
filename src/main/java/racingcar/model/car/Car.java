package racingcar.model.car;

import racingcar.service.ShiftGear;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import static racingcar.type.message.MessageType.MARK;

// TODO : 자동차 경주에 말이 들어 온다면?
public class Car {
//    private static final String MARK = "-";
    // TODO : 어떻게 선언 할까
//    private final Comparator<Car> comparator = new OrderByPosition();

    protected final String name;
    protected Long currentPosition;

    private Car(String name, Long currentPosition){
        validate(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car ofStartPoint(String name){
        return new Car(name, 0L);
    }

    public void move() {
        if (ShiftGear.moveForward()){
            currentPosition++;
        }
    }

    private void validate(String value){
        // TODO : 다른 방식으로 구현체 가져오기
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
//        Validator carValidator = new CarValidator();
//        if(carValidator.support(Car.class)) {
//            carValidator.validate(value);
//        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" : ");
        for (long i=0 ; i < this.currentPosition ; i++){
            stringBuilder.append(MARK);
        }
        return stringBuilder.toString();
//        return this.name + " : " + MARK.repeat(this.currentPosition);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if(!(obj instanceof Car car)){
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }

//    public int compareTo(Car car) {
//        return comparator.compare(this, car);
////        return this.currentPosition - car.currentPosition;
//    }

//    private void validateName(String name){
//        validateLength(name);
//    }
//
//    private void validateLength(String value){
//        if(MIN_LENGTH.getPlayValue() > value.length() || value.length() > MAX_LENGTH.getPlayValue()){
//            throw new IllegalArgumentException();
//        }
//    }
}
