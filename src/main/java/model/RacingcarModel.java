package model;

public class RacingcarModel {
    String[] car_names;
    int repeat;

    public RacingcarModel(String car_names, String repeat){
        ErrorCheck(car_names, repeat);
        this.car_names = SliceByComma(car_names);
        this.repeat = Integer.parseInt(repeat);
    }

    private void ErrorCheck(String car_names, String repeat){
        String[] car_name = SliceByComma(car_names);
        for(int i=0; i<car_name.length; i++){
            if(isCorrectLength(car_name[i])){
                throw new IllegalArgumentException("자동차 이름 입력 길이가 잘못됨.");
            }
        }

        if(!isNumeric(repeat)){
            throw new IllegalArgumentException("반복횟수가 숫자가 아님.");
        }
    }
    private boolean isCorrectLength(String car_name){
        return (car_name.length() == 0 || car_name.length() > 5);
    }

    private boolean isNumeric(String user_number) {
        return user_number.matches("\\d+");
    }

    private String[] SliceByComma(String car_names){
        car_names = car_names.replaceAll("\\s", "");
        return car_names.split(",");
    }

}
