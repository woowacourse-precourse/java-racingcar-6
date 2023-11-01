package model;

public class utilityModel {
    public String[] splitByComma(String input){
        return input.split(",");
    }
    boolean isValidName(int maxLength, String name){
        if(name.length() <= maxLength){
            return true;
        }
        throw new IllegalArgumentException();
    }
}