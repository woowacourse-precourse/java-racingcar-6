package racingcar.util;

import racingcar.exception.ExceptionHandler;

import java.util.List;

public class ValidUtil {
    public void checkNames(String names){
        ExceptionHandler.blankNamesException(names);
        ExceptionHandler.duplicateNameException(names);
    }

    public void checkNameList(List<String> names){
        for(String name : names){
            ExceptionHandler.shortNameLengthException(name);
            ExceptionHandler.LongNameLengthException(name);
            ExceptionHandler.blankNameException(name);
        }
    }
    public boolean checkTryNumber(String tryNumberStr){
        ExceptionHandler.notDigitException(tryNumberStr);
        ExceptionHandler.tooBigDigitException(tryNumberStr);
        ExceptionHandler.zeroOrMinusTryNumberException(tryNumberStr);
        return true;
    }
}
