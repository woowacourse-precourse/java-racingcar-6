package racingcar.service;

public class InputValidation {

    public InputValidation(){}
    public String[] splitNamesByComma(String InputCars) throws IllegalArgumentException{
        String[] splitCarNames = InputCars.split(",");

        if(!isLimitFiveString(splitCarNames)) {
            throw new IllegalArgumentException();
        }
        return splitCarNames;

    }

    public boolean isLimitFiveString(String[] CarNames)throws IllegalArgumentException {
        for(int i=0;i<CarNames.length;i++) {
            if (CarNames[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isInt(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
