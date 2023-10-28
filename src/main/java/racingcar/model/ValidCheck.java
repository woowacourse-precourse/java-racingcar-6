package racingcar.model;

public class ValidCheck {
    public static void namesize_check(String[] car_list){
        for (String car_name : car_list){
            if (car_name.length() > 5){
                throw new IllegalArgumentException();
            }
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
