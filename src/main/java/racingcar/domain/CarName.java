package racingcar.domain;

import java.util.Objects;

public class CarName {
    private String name;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String SPACE_INCLUDED_ERROR_MESSAGE = "이름에 공백이 포함될 수 없습니다.";
    private static final String LENGTH_ERROR_INCLUDE = "이름은 1글자 이상, 5글자 이하를 입력해야 합니다.";

    public CarName(String name){
        validateLength(name);
        validateEmptySpaceInclude(name);
        this.name = name;
    }

    private void validateLength(String name){
        int nameLength = name.length();
        if(nameLength < MIN_LENGTH || nameLength > MAX_LENGTH){
            throw new IllegalArgumentException(LENGTH_ERROR_INCLUDE);
        }
    }

    private void validateEmptySpaceInclude(String name){
        if(name.contains(" ")){
            throw new IllegalArgumentException(SPACE_INCLUDED_ERROR_MESSAGE);
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

    @Override
    public String toString(){
        return this.name;
    }

    public String getName() {
        return name;
    }
}
