package racingcar.utils;

import java.util.List;

public class Checker {
    private static final int MIN_NAME_LENGTH=1;
    private static final int MAX_NAME_LENGTH=5;

    public void inputCarName(String playerInput, List<String> carList){
        checkLastElementException(playerInput);
        checkLengthandSpaceException(carList);
        checkDuplicationException(carList);
    }

    public void inputAttemptFinal(String inputAttemptFinal){
        wrongInputException(inputAttemptFinal);
    }

    private void checkLastElementException(String playerInput) {
        if(playerInput.lastIndexOf(",")==playerInput.length()-1){
            throw new IllegalArgumentException("ERROR : 마지막 자동차 이름값이 공백 문자입니다.");
        }
    }
    private void checkDuplicationException(List<String> carList){
        for(int count1=0;count1<carList.size()-1;count1++){
            for(int count2=count1+1;count2<carList.size();count2++){
                checkDuplicationName(carList.get(count1),carList.get(count2));
            }
        }
    }

    private void checkDuplicationName(String name1, String name2) {
        if(name1.equals(name2)){
            throw new IllegalArgumentException("ERROR : 자동차 이름 중 중복값이 존재합니다.");
        }
    }
    private void checkLengthandSpaceException(List<String> carList) {
        for(String carName:carList){
            maxLengthException(carName);
            minLengthException(carName);
            containsSpace(carName);
        }
    }

    private void maxLengthException(String carName){
        if(carName.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("ERROR : 자동차 이름 글자수 최대 제한 조건을 확인해주세요.");
        }
    }

    private void minLengthException(String carName){
        if(carName.length()<MIN_NAME_LENGTH){
            throw new IllegalArgumentException("ERROR : 자동차 이름 글자수 최소 제한 조건을 확인해주세요.");
        }
    }

    private void containsSpace(String carName){
        if(carName.contains(" ")){
            throw new IllegalArgumentException("ERROR : 자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    private void wrongInputException(String attemptNum){
        try{
            Integer.parseInt(attemptNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("ERROR : 입력값이 숫자가 아닙니다.");
        }
    }
}
