package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Judge {
    private Integer maxNameLength;
    private Integer forwardCriterion;
    private Integer lowerBoundRandomNumber;
    private Integer upperBoundRandomNumber;

    public Judge(Integer maxNameLength, Integer forwardCriterion, Integer lowerBoundRandomNumber, Integer upperBoundRandomNumber) {
        this.maxNameLength = maxNameLength;
        this.forwardCriterion = forwardCriterion;
        this.lowerBoundRandomNumber = lowerBoundRandomNumber;
        this.upperBoundRandomNumber = upperBoundRandomNumber;
    }

    public boolean canMove(){
        boolean move = false;
        if(pickRandomNumber() >= forwardCriterion){
            move = true;
        };
        return move;
    }

    private Integer pickRandomNumber(){
        return Randoms.pickNumberInRange(lowerBoundRandomNumber, upperBoundRandomNumber);
    }

    public boolean isEffectiveInputNames(Optional<String> input){
        List<String> names = Arrays.stream(input.orElse("nullable").split(",")).toList();
        return checkLengthOfStringIfExceedLimitLength(names);
    }

    private boolean checkLengthOfStringIfExceedLimitLength(List<String> names) {
        for (String name : names) {
            if(name.length() > maxNameLength) {
                throw new IllegalArgumentException("이름은 5자 이하입니다.");
            }
        }
        return true;
    }

    private boolean isEffectiveInputTurn(Optional<String> input){
        String inputTurn = input.orElse("null");
        checkTypeIsInteger(inputTurn);
        return checkExistBetweenLowerBoundAndUpperBound(inputTurn);
    }


    private void checkTypeIsInteger(String inputTurn) {
        try{
            Integer.parseInt(inputTurn);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야합니다.");
        }
    }

    private boolean checkExistBetweenLowerBoundAndUpperBound(String inputTurn) {
        boolean between = false;
        Integer input = Integer.parseInt(inputTurn);

        if(lowerBoundRandomNumber <= input && upperBoundRandomNumber >= input){
            between = true;
        }
        return between;
    }
}
