package racingcar.validator;

import racingcar.NameConstant;

public enum NameValidator {
    INSTANCE;

    public String validateName(String name){
        String nameWithoutWhiteSpace=removeWhiteSpace(name);
        checkNameIsEmpty(nameWithoutWhiteSpace);
        checkNameCorrectRange(nameWithoutWhiteSpace);

        return nameWithoutWhiteSpace;
    }

    private String removeWhiteSpace(String name){
        return name.replace(" ","");
    }

    private void checkNameIsEmpty(String name){
        if(name.length()== NameConstant.NAME_EMPTY_SIZE){
            throw new IllegalArgumentException("비어있는 이름이 들어왔습니다.");
        }
    }

    private void checkNameCorrectRange(String name){
        if(name.length()>NameConstant.NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름이 5자를 초과했습니다. 초과이름: "+name);
        }
    }
}
