package view;

public class AttemptTimesValidator {
    private void validateInteger(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
