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

    public Judge(int maxNameLength, int forwardCriterion, int lowerBoundRandomNumber, int upperBoundRandomNumber) {
        this.maxNameLength = maxNameLength;
        this.forwardCriterion = forwardCriterion;
        this.lowerBoundRandomNumber = lowerBoundRandomNumber;
        this.upperBoundRandomNumber = upperBoundRandomNumber;
    }

    /**
     * 랜덤으로 입력된 수가 판정 기준보다 높은지 아닌지를 확인
     * @param randomNumber 각 자동차마다 무작위로 생성된 숫자
     * @return 기준치보다 높으면 true, 그렇지 아않으면 false
     */
    public boolean canMove(int randomNumber){
        boolean move = false;
        if(randomNumber >= forwardCriterion){
            move = true;
        };
        return move;
    }

    /**
     * 랜덤한 숫자를 범위 내에서 선택
     * @return 범위 내의 랜덤 숫자
     */
    public Integer pickRandomNumber(){
        return Randoms.pickNumberInRange(lowerBoundRandomNumber, upperBoundRandomNumber);
    }

    /**
     * 자동차 이름들의 입력이 유효한지 판단
     * @param input 사용자의 입력의 Optional
     * @return 유효하면 true
     */
    public boolean isEffectiveInputNames(Optional<String> input){
        List<String> names = Arrays.stream(input.orElse("nullable").split(",")).toList();
        return checkLengthOfStringIfExceedLimitLength(names);
    }

    /**
     * 입력된 자동차의 이름이 최대길이를 넘는지 확인
     * @param names 입력된 자동차 이름 리스트
     * @throws IllegalArgumentException 자동차 이름이 최대 길이를 넘길 때
     * @return 자동차 이름들이 최대 길이를 넘지 않을 때
     */
    private boolean checkLengthOfStringIfExceedLimitLength(List<String> names) {
        for (String name : names) {
            if(name.length() > maxNameLength || name.equals("")) {
                throw new IllegalArgumentException("이름은 5자 이하입니다.");
            }
        }
        return true;
    }

    /**
     * 시도 횟수 입력이 유효한지 판단
     * @param input 시도횟수의 Optional
     */
    public void isEffectiveInputTurn(Optional<String> input){
        String inputTurn = input.orElse("null");
        checkTypeIsInteger(inputTurn);
        checkRangeIfIsNegative(inputTurn);
    }

    /**
     * 입력된 값이 Integer로 변환 가능한지 확인
     * @param inputTurn 사용자가 입력한 시도횟수
     * @throws IllegalArgumentException 정수로 변환할 수 없을 때
     */
    private void checkTypeIsInteger(String inputTurn) {
        try{
            Integer.parseInt(inputTurn);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야합니다.");
        }
    }

    /**
     * 입력된 시도횟수가 음수인지 확인
     * @throws IllegalArgumentException 입력값이 음수일 때
     * @param inputTurn 입력값이 0 이상일 때
     */
    private void checkRangeIfIsNegative(String inputTurn) {
        Integer inputNumber = Integer.parseInt(inputTurn);
        if(inputNumber<= 0){
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야합니다.");
        }
    }
}
