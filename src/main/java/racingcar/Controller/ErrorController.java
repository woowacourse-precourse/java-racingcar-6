package racingcar.Controller;

public class ErrorController {

    public void carNamesException(String names){
        if(!names.matches("^([\\w]{1,5},)*[\\w]{1,5}$")){
            throw new IllegalArgumentException();
        }
    }

    public void gameTimesException(String times){
        if(!times.matches("^[0-9]*$"))
            throw new IllegalArgumentException();
    }
}
