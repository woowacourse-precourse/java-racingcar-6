package racingcar;

import racingcar.validator.NameValidator;

public class Name {
    private String name;

    public Name(String name){
        NameValidator validator=NameValidator.INSTANCE;
        this.name=validator.validateName(name);
    }

    public String getName(){
        return name;
    }
}
