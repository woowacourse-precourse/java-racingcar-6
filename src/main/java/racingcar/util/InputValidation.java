package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    public List<String> checkNameInputValid(String names) {
        List<String> nameList = checkCarsName(names);
        checkCarsSize(nameList);
        checkDuplicateName(nameList);
        return nameList;
    }

    public int checkRoundInputValid(String round) {
        String regex = Constants.ROUND_REGEX.constant;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(round);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(Constants.IS_NOT_NUMBER.getConstant());
        }
        return Integer.parseInt(round);
    }

    private List<String> checkCarsName(String names) {
        List<String> nameList = List.of(names.split(Constants.NAME_SPLIT_REGEX.getConstant()));
        if (nameList.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(Constants.HAS_BLANK_IN_NAME.constant);
        }

        return nameList;
    }

    private void checkCarsSize(List<String> carName) {
        if (carName.size() < Integer.parseInt(Constants.MINIMUM_CAR_SIZE.constant)) {
            throw new IllegalArgumentException(Constants.NOT_MATCH_MINIMUM_CAR_SIZE.constant);
        }
    }

    private void checkDuplicateName(List<String> carName) {
        Set<String> set = new HashSet<>(carName);
        if (set.size() != carName.size()) {
            throw new IllegalArgumentException(Constants.HAS_DUPLICATE_NAME.constant);
        }
    }
}
