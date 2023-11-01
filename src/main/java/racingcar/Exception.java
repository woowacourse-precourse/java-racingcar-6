package racingcar;

public class Exception {
    int checkNumberException(String number){
        try{
            int times = Integer.valueOf(number);
            if(times<0){
                throw new IllegalArgumentException();
            }
            return times;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    void checkStringLengthException(String name){
        if(name.length()>5){
            throw new IllegalArgumentException();
        }
    }
}
