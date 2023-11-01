package model;

public class utilityModel {
    public static String[] splitByComma(String input){
        return input.split(",");
    }
    public static boolean isValidName(int maxLength, String name){
        if(name.length() <= maxLength){
            return true;
        }
        throw new IllegalArgumentException();
    }
}