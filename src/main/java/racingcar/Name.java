package racingcar;

import racingcar.validator.NameValidator;

public class Name {
    private String name;

    public Name(String name){
        NameValidator validator=NameValidator.INSTANCE;
        validator.validateName(name);

        this.name=name;
    }

    public String getName(){
        return name;
    }
}
