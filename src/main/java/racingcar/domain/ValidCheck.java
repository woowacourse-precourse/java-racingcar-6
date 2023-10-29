package racingcar.domain;

public class ValidCheck {
    public static void nameSize_check(String car_name){
        if (car_name.length() > 5){
            throw new IllegalArgumentException();
        }
    }
    public static int moveTypeCheck(String move){
        try{
            return Integer.parseInt(move);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
