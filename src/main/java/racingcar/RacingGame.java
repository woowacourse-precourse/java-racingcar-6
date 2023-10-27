package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        List<String> names=Arrays.stream(splitNames(view.inputConsole()))
                .map(this::removeWhiteSpace)
                .collect(Collectors.toList());

        checkHasDuplicates(names);

        return names.stream()
                .map(name->new Car(new Name(name),new Position()))
                .collect(Collectors.toList());
    }

    public int inputAttemptCount(String input){
        checkAttemptCountIsInteger(input);
        return toInt(input);
    }

    private int toInt(String input){
        return Integer.parseInt(input);
    }

    private String removeWhiteSpace(String name){
        return name.replace(" ","");
    }

    private void checkHasDuplicates(List<String> names){
        Set<String> uniqueName=new HashSet<>(names);

        if(names.size()!=uniqueName.size()){
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
