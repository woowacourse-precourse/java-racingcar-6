package racingcar;

public class ResultChecker {
    public String checkResult(int count){
        String result = "";
        for(int i =0; i<count;i++){
            result += "-";
        }
        return result;
    }
}
