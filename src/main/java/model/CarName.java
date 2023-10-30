package model;

public class CarName {
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String name;



    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }




}
