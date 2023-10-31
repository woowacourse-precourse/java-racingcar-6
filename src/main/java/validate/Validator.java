package validate;

public class Validator {
    public static String checkName(String name){
        if(name.contains(",")){
            System.out.printf("자동차 이름을 입력해 주십시오");
            throw new IllegalArgumentException();
        }
        if(name.length()>5){
            System.out.printf("자동차 이름이 5자 이상입니다.");
            throw new IllegalArgumentException();
        }
        if(name.contains(" ")){
            System.out.printf("자동차 이름에 공백이 들어가면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if(name.length() == 0){
            System.out.printf("자동차 이름을 입력해 주십시오");
            throw new IllegalArgumentException();
        }
        return name;
    }

    public static int checkNum(String num){
        try {
            return Integer.parseInt(num);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력해 주십시오");
        }
    }
}
