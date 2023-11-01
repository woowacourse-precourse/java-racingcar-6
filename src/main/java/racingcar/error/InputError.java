package racingcar.error;

public class InputError {
    public static void checkInputCar(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        if(name.length()>5){
            throw new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }
}
