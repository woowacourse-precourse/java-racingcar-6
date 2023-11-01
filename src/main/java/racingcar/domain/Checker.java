package racingcar.domain;

public class Checker{
    public void checkNumber(String inputAttempts){
        try{
            Integer.parseInt(inputAttempts);
        }catch (Exception e){
            throw new IllegalArgumentException(e.toString());
        }
    }
}
