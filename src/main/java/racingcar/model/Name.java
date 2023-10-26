package racingcar.model;

public class Name {
    private final String value;
    private static final int MAX_LENGTH = 5;

    public Name(String name){

        validate(name);
        this.value = name;
    }

    public String getName(){
        return value;
    }

    private void validate(String name){
        if(isEmpty(name)){
            throw new IllegalArgumentException();
        }

        if(isDigit(name)){
            throw new IllegalArgumentException();
        }

        if(isOverFiveLength(name)){
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

    private boolean isOverFiveLength(String name){
        return name.length() > MAX_LENGTH;
    }
}
