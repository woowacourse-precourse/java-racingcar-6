package racingcar.constant;

public enum Error {
    DUPLICATED_NAME("Car names cannot be duplicated."),
    NUMERICINPUT("Input must be numeric."),
    BLANKINPUT("Input value cannot be blank."),
    EXCEEDNAME("The car name cannot be longer than 5 characters.");

    Error(String message) {

    }


}
