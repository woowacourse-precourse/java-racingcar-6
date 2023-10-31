package domain;

import java.util.Objects;
import util.validator.StringLengthValidator;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        StringLengthValidator.validateMaxLength(carName,MAX_LENGTH);
        this.carName = carName;
    }

    public String getValue(){
        return carName;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        CarName name = (CarName) o;
        return Objects.equals(this.carName, name.carName);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(carName);
    }
}
