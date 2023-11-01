package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 클래스 이름 : ErrorCheck
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-11-01
 *
 * 내용 : 사용자의 Input 값의 오류를 처리하는 클래스
 *
 * 작성자 : 문재경
 */
public class ErrorCheck {
    private final String LENGTH_ERROR = "자동차 이름 입력 길이가 잘못됨";
    private final String NOT_NUMBER_ERROR  = "반복 횟수가 숫자가 아님.";
    private final String DUPLICATE_ERROR = "이름이 중복됐음.";

    public void ErrorChecking(List<String> car_names_list, String repeat){

        for(int i=0; i<car_names_list.size(); i++){
            if(isCorrectLength(car_names_list.get(i))){
                throw new IllegalArgumentException(LENGTH_ERROR);
            }
        }
        if(isNumeric(repeat)){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }

        if(isDuplicateName(car_names_list)){
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private boolean isDuplicateName(List<String> car_names_list){
        Set<String> carNameSet = new HashSet<>(car_names_list);
        return carNameSet.size() != car_names_list.size();
    }
    private boolean isCorrectLength(String car_name){
        return (car_name.length() == 0 || car_name.length() > 5);
    }

    private boolean isNumeric(String user_number) {
        return !user_number.matches("\\d+");
    }
}
