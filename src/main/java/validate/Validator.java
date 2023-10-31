package validate;

public class Validator {
    public static String checkName(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("이름이 5자 이상입니다.");
        }
        if(name.contains(" ")){
            throw new IllegalArgumentException("이름에 공백이 들어가면 안됩니다.");
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
