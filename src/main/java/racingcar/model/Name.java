package racingcar.model;

public class Name {
    private final String value;

    public Name(String name){

        validate(name);
        this.value = name;
    }

    private void validate(String name){
        if(isEmpty(name)){
            throw new IllegalArgumentException();
        }

        if(isDigit(name)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String name){
        return name.isBlank() || name == null;
    }

    private boolean isDigit(String name){
        for (int i = 0; i < name.length(); i++) {
            if(Character.isDigit(name.charAt(i))){
                return true;
            }
        }

        return false;
    }
}
