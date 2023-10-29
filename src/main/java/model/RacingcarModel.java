package model;

public class RacingcarModel {
    String car_names;
    int repeat;

    public RacingcarModel(String car_names, String repeat){
        ErrorCheck(car_names, repeat);
        this.car_names = car_names;
        this.repeat = Integer.parseInt(repeat);
    }

    private void ErrorCheck(String car_names, String repeat){
        car_names = car_names.replaceAll("\\s",""); // 문자열 공백 제거
        String[] car_name = car_names.split(","); // ',' 을 기준으로 문자열 자르기
        for(int i=0; i<car_name.length; i++){
            if(isCorrectLength(car_name[i])){
                throw new IllegalArgumentException();
            }
        }

        if(!isNumeric(repeat)){
            throw new IllegalArgumentException();
        }
    }
    private boolean isCorrectLength(String car_name){
        return (car_name.length() == 0 || car_name.length() > 5);
    }

    private boolean isNumeric(String user_number) {
        return user_number.matches("\\d+");
    }

}
