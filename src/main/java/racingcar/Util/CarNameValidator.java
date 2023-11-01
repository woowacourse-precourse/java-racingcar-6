package racingcar.Util;

import java.util.ArrayList;

public class CarNameValidator {
    private final String NAMES_STRING;
    public final ArrayList<String> NAMES;


    public CarNameValidator(String namesString) {
        this.NAMES_STRING = namesString;
        this.NAMES = Util.toArrayList(namesString);
        validate();
    }

    public void validate() {
        isRightNamesString();
        isNotNumber();
        isNotDuplicate();
        isRightNameSize();
    }

    public void isRightNamesString() {

        if (!Rule.namesStringPattern.matcher(NAMES_STRING).matches()) {
            throw new IllegalArgumentException(Rule.CAR_NAME_WRONG_ERROR);
        }

        String[] names = NAMES_STRING.split(Rule.DELIMETER);
        for ( String name : names) {
            if(name.length() > Rule.MAX_CARNAMESIZE) {
                throw new IllegalArgumentException(Rule.CAR_NAME_SIZE_ERROR);
            }
            else {
                System.out.println(name);
            }
        }
    }

    public void isRightNameSize() {
        if (NAMES.size() > Rule.MAX_CARNAMESIZE || NAMES.isEmpty()){
            throw new IllegalArgumentException(Rule.CAR_NAME_SIZE_ERROR);
        }
    }

    public void isNotDuplicate() {
        if (NAMES.size() != NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException(Rule.CAR_NAME_DUPLICATE_ERROR);
        }
    }

    public void isNotNumber() {
        if (Rule.roundNumPattern.matcher(NAMES_STRING).find()) {
            throw new IllegalArgumentException(Rule.CAR_NAME_NUMBER_ERROR);
        }
    }
}