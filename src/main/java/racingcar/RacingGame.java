package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String COMMA=",";

    private static final Pattern INTEGER=Pattern.compile("[0-9]+");

    private final View view;

    public RacingGame(){
        view=new View();
    }

    public String[] splitNames(String names){
        return names.split(COMMA);
    }

    public void checkAttemptCountIsInteger(String input){
        if(!INTEGER.matcher(input).matches()){
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
    }

    public List<Car> inputCarNames(){
        return Arrays.stream(splitNames(view.inputNames()))
                .map(name->new Car(new Name(name),new Position()))
                .collect(Collectors.toList());
    }
}
