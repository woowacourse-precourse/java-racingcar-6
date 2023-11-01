package domain.InputView;

import java.util.Arrays;
import java.util.regex.Pattern;

import static message.ErrorMessages.*;

public class NameValidiator {
    public static final int NAME_MAX_SIZE = 5;
    public static final Pattern namesStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$");

    NameValidiator(String inputCarNames) {
        checkEmpty(inputCarNames);
        checkEndDelimiter(inputCarNames);
    }

    private void checkEndDelimiter(String inputCarNames) {
        if (inputCarNames.charAt(inputCarNames.length() - 1) == ',') {
            throw new IllegalArgumentException(END_DELIMITER_ERROR);
        }
    }

    private void checkEmpty(String inputCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException(NONE_INPUT_ERROR);
        }
    }

    public void checkDuplicate(String[] inputCarNamesArray) {
        if (inputCarNamesArray.length != Arrays.stream(inputCarNamesArray).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR);
        }
    }

    public void checkEmptyorLongNames(String[] inputCarNamesArray) {
        for (String carNames : inputCarNamesArray) {
            if (carNames.isEmpty() || carNames.length() > NAME_MAX_SIZE) {
                throw new IllegalArgumentException(WRONG_INPUT_ERROR);
            }
        }
    }

    public void checkRightName(String [] inputCarNamesArray)
    {
        for(String carName : inputCarNamesArray){
            try{
                matches(carName);
            }
            catch(IllegalArgumentException e)
            {
                e.getMessage();
            }

        }
    }

    private void matches(String carName)
    {
        if(!namesStringPattern.matcher(carName).matches())
        {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR);
        }

    }


}
