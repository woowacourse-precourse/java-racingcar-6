package racingcar.util;

public class Parser {
    public String[] parserCarInput(String input) throws IllegalArgumentException{
        String[] carNames = input.split(",");
        for(int i = 0; i < carNames.length; i++){
            if(carNames[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public int parserCountInput(String input) throws IllegalArgumentException{
        if(Integer.valueOf(input) == null){
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(input);
    }
}
