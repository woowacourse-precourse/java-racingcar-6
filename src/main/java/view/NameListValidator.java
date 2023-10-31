package view;

import constants.Constants;
import constants.ExceptionMessage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NameListValidator {
    public void validate(String nameListInput){
        validateNotEmpty(nameListInput);
        validateNotEndsWithComma(nameListInput);
        validateContainsRepeatingCommas(nameListInput);
        List<String> nameList = splitAndTrim(nameListInput, ",");
        validateNameLength(nameList, Constants.MAX_LENGTH);
        validateNameDuplication(nameList);
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT);
        }
    }

    private void validateNotEndsWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessage.ENDS_WITH_COMMA);
        }
    }

    private void validateContainsRepeatingCommas(String input) {
        String inputWithoutSpace = ignoreSpace(input);
        for (int i = 0; i < inputWithoutSpace.length() - 1; i++) {
            if (inputWithoutSpace.charAt(i) == ',' && inputWithoutSpace.charAt(i + 1) == ',') {
                throw new IllegalArgumentException(ExceptionMessage.CONTAINS_REPEATING_COMMAS);
            }
        }
    }

    private String ignoreSpace(String input) {
        return input.replace(" ", "");
    }

    private void validateNameLength(List<String> names, int maxLength) {
        for (String name : names) {
            if (name.length() > maxLength) {
                throw new IllegalArgumentException(ExceptionMessage.EXCEEDED_NAME_LENGTH);
            }
        }
    }

    private void validateNameDuplication(List<String> names){
        HashSet<String> nameSet = new HashSet<>();
        for(String name : names){
            if(!nameSet.add(name)){
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NAME);
            }
        }
    }

    public List<String> splitAndTrim(String input, String delimiter){
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
