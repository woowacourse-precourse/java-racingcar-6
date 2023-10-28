package racingcar.validator;

import org.mockito.internal.matchers.Null;

import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;
import java.util.Arrays;

public class CarNameValidator {

    private final String NAME;
    public final ArrayList<String> NAMES;
    private final static String ERROR = "[ERROR]";
    private final static String NAME_ERROR_MESSAGE = "차 이름은 문자로만 구성되어야 합니다.";
    private final static String NAME_NULL_ERROR_MESSAGE = "차 이름을 적어주세요.";
    private final static String NAME_RANGE_ERROR_MESSAGE = "차 이름은 1자 이상 5자 이하로 적어주세요.";
    private final static String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름을 적으면 안 됩니다.";

    public CarNameValidator(String name){
        NAME = name;
        NAMES = new ArrayList<>(Arrays.asList(name.split(",")));
        isNull();
        isRangeOut();
        isNameError();
        isDuplicate();
    }

    public void isNameError(){
        if (NAME.contains(" ")){
            throw new IllegalArgumentException(ERROR+NAME_ERROR_MESSAGE);
        }
    }

    public void isNull(){
        if (NAMES.size() == 1){
            throw new IllegalArgumentException(ERROR+NAME_NULL_ERROR_MESSAGE);
        }
    }

    public void isRangeOut(){
        for (String name : NAMES) {
            if (name.length() > 5 || name.length() < 1){
                throw new IllegalArgumentException(ERROR+NAME_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public void isDuplicate(){
        if (NAMES.stream().distinct().count() != NAMES.size()){
            throw new IllegalArgumentException(ERROR+NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}