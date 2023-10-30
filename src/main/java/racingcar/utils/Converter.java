package racingcar.utils;

public class Converter {
    public String[] convertCarsName(String newCarsName){
        return newCarsName.split(",");
    }

    public int convertTurn(String newTurn){
        return Integer.parseInt(newTurn);
    }
}
