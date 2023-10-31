package racingcar.model;

public class Name {
    private final String value;
    private static final int MAX_LENGTH = 5;

    public Name(String name){
        name = removeSpace(name);
        validate(name);
        this.value = removeSpace(name);
    }

    public String getName(){
        return value;
    }

    private String removeSpace(final String name){
        return name.replaceAll(" ","");
    }

    private void validate(final String name){
        if(isEmpty(name) || isDigit(name) || isOverFiveLength(name)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(final String name){
        return name.isBlank() || name == null;
    }

    private boolean isDigit(final String name){
        for (int i = 0; i < name.length(); i++) {
            if(Character.isDigit(name.charAt(i))) return true;
        }

        return false;
    }

    private boolean isOverFiveLength(final String name){
        return name.length() > MAX_LENGTH;
    }
}
