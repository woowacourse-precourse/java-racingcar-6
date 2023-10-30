package racingcar.utils;

public class Converter {
    public static String[] convertCarsName(String newCarsName){
        return newCarsName.split(",");
    }

    public static int convertTurn(String newTurn){
        return Integer.parseInt(newTurn);
    }
}
