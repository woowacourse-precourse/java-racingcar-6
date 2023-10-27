package racingcar.domain;

import java.util.Objects;
import javax.naming.Name;

public class CarName {
    private final String name;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public CarName(String name){
        validateLength();
        validateEmptySpaceInclude();
    }

    private void validateLength(String name){
        int nameLength = name.length();
        if(nameLength < MIN_LENGTH || nameLength > MAX_LENGTH){
            throw new IllegalArgumentException("이름은 1글자 이상, 5글자 이하를 입력해야 합니다.");
        }
    }

    private void validateEmptySpaceInclude(String name){
        if(name.contains()){
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        CarName otherName = (CarName) o;
        return this.name.equals(otherName.name);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.name);
    }
}
