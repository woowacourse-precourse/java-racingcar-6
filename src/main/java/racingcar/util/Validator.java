package racingcar.util;

import java.util.List;

//검증
public class Validator {

    private static final int CAR_NAME_RANGE_START = 1;
    private static final int CAR_NAME_RANGE_FINISH = 5;
    private static final String SPACE = " ";
    private final Parser parser = new Parser();



    public void checkCarNamesInput(String input)throws IllegalArgumentException{
        checkEmpty(input);
        checkIndex(input);
        List<String>carNameList = parser.parseCarNames(input);
        checkCarNameSpaceLength(carNameList);
        checkCarNameListDuplication(carNameList);


    }

    private void checkCarNameSpaceLength(List<String>carNameList){
        for (String carName: carNameList){
            checkLength(carName);
            checkSpace(carName);
        }
    }
    public void checkInputNumber(String input)throws IllegalArgumentException{
        checkEmpty(input);
        checkChar(input);
    }

    private void checkChar(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]시도할 횟수는 숫자여야 합니다");
        }
    }

    private void checkEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR]값을 입력해주세요.");
        }
    }

    private void checkCarNameListDuplication(List<String>carNameList){
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEquals(carNameList.get(i),carNameList.get(j));
;            }
        }
    }

    private void checkEquals(String carName1, String carName2) {
        if (carName1.equals(carName2)){
            throw new IllegalArgumentException("[ERROR]같은 이름을 가진 자동차가 있습니다.");
        }
    }

    private void checkIndex(String input){
        if(input.lastIndexOf(",") ==  input.length() -1){
            throwMinLength();
        }
    }



    private void checkLength(String carName) {
        if(CAR_NAME_RANGE_FINISH < carName.length()){
            throwMaxLength();
        }
        if(carName.length() < CAR_NAME_RANGE_START){
            throwMinLength();
        }
    }

    private void throwMaxLength() {
        throw new IllegalArgumentException("[ERROR]자동차 이름은" + CAR_NAME_RANGE_FINISH + "글자 이하여야 합니다.");
    }

    private void throwMinLength() {
        throw new IllegalArgumentException("[ERROR]자동차 이름은" + CAR_NAME_RANGE_START + "글자 이상이어야 합니다");
    }

    private void checkSpace(String carName) {
        if(carName.contains(SPACE)){
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("[ERROR]자동차 이름안에는 공백이 있어서는 안됩니다!");
    }

}
