package racingcar;

public class HandleException {
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
