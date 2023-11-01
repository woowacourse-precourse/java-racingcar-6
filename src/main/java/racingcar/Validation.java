package racingcar;

public class Validation {
//    자동차 이름 검증 메서드
    public static boolean carValid(String name) throws IllegalArgumentException{
        // 이름이 5자 초과이거나 입력하지 않는다면
        if ((name.length() > 5) | (name.isEmpty())){
            System.out.println("이름 길이가 5자 미만이 되도록 입력해주세요.");
            throw new IllegalArgumentException();
        } else if (name.equals(" ")) {
            System.out.println("이름을 공백으로 지정할 순 없습니다.");
            throw new IllegalArgumentException();
        }
        return true;
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
