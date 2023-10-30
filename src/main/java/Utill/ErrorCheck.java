package Utill;

import static Utill.Define.*;
public class ErrorCheck {
    public static void checkIsValidAnswer(String[] answers) {
        checkStringListlength(answers);
    }
    private static void checkStringListlength(String[] answers){
        for(String answer : answers){
            checkStringlength(answer);
        }
    }

    private static void checkStringlength(String answers){
        if(answers.length() >= MaxLength) {
            throw new IllegalArgumentException();
        }
    }
}
