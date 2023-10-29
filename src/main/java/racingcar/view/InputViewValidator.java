package racingcar.view;

public class InputViewValidator {

    private static final InputViewValidator inputViewValidator = new InputViewValidator();

    private InputViewValidator() {};

    public static InputViewValidator getInstance(){
        return inputViewValidator;
    }

    public boolean validateCarNames(String carNames){

        if(isCarNameEmpty(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름이 빈 값일 수 없습니다");
        }
        if(isCarNameCorrectLength(carNames)){
            throw new IllegalArgumentException("[ERROR] : 차 이름은 길이가 5이하여야 합니다.");
        }
    }

    public boolean isCarNameCorrectLength(String carNames) {
        String[] carNameList = carNames.split("");

        for (String carName : carNameList) {
            if(carName.length() > 5){
                return true;
            }
        }
        return false;
    }

    public boolean isCarNameEmpty(String carNames) {
        return carNames.equals("");
    }

}
