package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
//    자동차 이름 검증 메서드
    public static boolean carValid(String name) throws IllegalArgumentException{
        // 이름이 5자 초과이거나 입력하지 않는다면
        if ((name.length() > 5)){
            System.out.println("이름 길이가 5자 미만이 되도록 입력해주세요.");
            throw new IllegalArgumentException();
        } else if (name.equals(" ")| (name.isEmpty())) {
            System.out.println("이름을 공백으로 지정할 순 없습니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
//    중복 예외 처리.
    public static List carNameValid(List strList) throws IllegalArgumentException{
        Set<String> nameSet = new HashSet<>(strList);

        if (nameSet.size() != strList.size()){
            System.out.println("일부 이름이 중복되었습니다. 중복을 피해주세요");
            throw new IllegalArgumentException();
        }
        return strList;
    }

//    게임 횟수 검증 메서드
    public static int numValid(int inputNum) throws IllegalArgumentException{
        if(inputNum < 0){
            System.out.println("0 이상의 숫자만 입력해주세요");
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
