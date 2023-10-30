package racingcar.validator;

import java.util.ArrayList;

import static racingcar.validator.Constants.*;

public class NameValidator {
    //이름의 형식이 맞지 않는 경우 (앞뒤 문자 확인, 중간 문자 구분자 확인 )
    //이름의 길이가 맞지 않는 경우
    //공백을 입력한 경우
    public final String NAMESTRING;
    public static ArrayList<String> NAMES = null;

    public NameValidator(String namestring) {
        this.NAMESTRING = namestring;
        this.NAMES = Util.toArrayList(namestring);
        validate();
    }
    public void validate(){
        isRightNameString();
        isRightNameSize();
        isNotDuplicate();
    }

    public void isRightNameString(){
        if (!Constants.namesStringPattern.matcher(NAMESTRING).matches()) {
            throw new IllegalArgumentException(CARNAME_WRONG_ERROR);
        }
    }
    public void isRightNameSize(){
        if(NAMES.stream().anyMatch(name -> name.length()>5||name.isEmpty())){
            throw new IllegalArgumentException(CARNAME_SIZE_ERROR);
        }
    }
    public void isNotDuplicate(){
        if(NAMES.size()!=NAMES.stream().distinct().count()){
            throw new IllegalArgumentException(CARNAME_DUPLICATE_ERROR);
        }

    }
}
