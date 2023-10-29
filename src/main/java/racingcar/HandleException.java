package racingcar;

public class HandleException {
    static void carName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("차의 이름의 길이는 5자 이하여야 합니다.");
        }
    }
    
    static int times(String times) {
        boolean check = times.matches("^[^0]\\d*");
        //System.out.println(check);
        if(!check) {
            throw new IllegalArgumentException("횟수에 해당하는 입력이 아닙니다.");
        }
        int number = Integer.parseInt(times);
        if(number < 1) {
            throw new IllegalArgumentException("횟수에 해당하는 입력이 아닙니다.");
        }
        return number;
    }
}
