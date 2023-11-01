package racingcar;

public class Rules {

    //이름 관련 입력 에러
    static String name_length_error="이름을 5자 이하로 작성하세요";
    public static void nameLengthErr(){
        throw new IllegalArgumentException(name_length_error);
    }

    static String name_not_overlap="자동차명은 중복될 수 없습니다.";
    public static void nameOverlapErr(){
        throw new IllegalArgumentException(name_not_overlap);
    }

    static String name_not_input="입력된 자동차명이 없습니다.";
    public static void nameNotInputErr(){
        throw new IllegalArgumentException(name_not_input);
    }

    static String name_is_Empty ="자동차명이 공백일 수 없습니다.";
    public static void nameIsEmpty(){
        throw new IllegalArgumentException(name_is_Empty);
    }


    //횟수 관련 입력 에러
    static String not_number="정수를 입력해야 합니다.";
    public static void NotNumberErr(){
        throw new IllegalArgumentException(not_number);
    }

    static String not_natural_number="자연수를 입력해야 합니다.";
    public static void NotNaturalNumberErr(){
        throw new IllegalArgumentException(not_natural_number);
    }

    static String number_not_input="입력된 수가 없습니다.";
    public static void numberNotInputErr(){
        throw new IllegalArgumentException(number_not_input);
    }
}
