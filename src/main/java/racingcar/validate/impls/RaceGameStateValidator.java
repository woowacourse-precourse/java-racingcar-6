package racingcar.validate.impls;

import java.util.List;
import racingcar.validate.Validator;

public class RaceGameStateValidator implements Validator {


    @Override
    public void validate(Object obj) {

    }

    private boolean checkValidateConditions(List<String> names) {
        return !isUniqueNames(names) || !isAllValidLength(names);
    }

    private boolean isValidNameLength(String name){
        return name.length() < 6 && name.length() != 0;
    }

    private boolean isAllValidLength(List<String> names){
        int originNamesLength = names.size();
        int validNamesLength = names.stream()
                .filter(this::isValidNameLength)
                .toList()
                .size();
        return originNamesLength == validNamesLength;
    }
    private boolean isUniqueNames(List<String> nameList){
        int originLength = nameList.size();
        int deleteDuplicateLength = nameList.stream().distinct().toList().size();
        return originLength == deleteDuplicateLength;
    }
}
