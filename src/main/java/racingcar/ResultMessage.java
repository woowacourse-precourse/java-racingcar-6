package racingcar;

import java.util.List;

public class ResultMessage {
    private final String resultMessage;

    public ResultMessage(List<Car> cars){
        StringBuilder result = new StringBuilder();

        cars.stream().map(Car::getNameValue)
                .forEach((name)->addResult(result,name));


        trim(result);

        resultMessage=result.toString();
    }

    private void addResult(StringBuilder result,String name){
        result.append(Constants.WHITESPACE).append(name).append(Constants.COMMA);
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
    }

    public String getResultMessage(){
        return resultMessage;
    }
}
