package racingcar;

public class Discriminator {
    public static void validateCarNumber(int carNumber){
        if (carNumber <= 0 || carNumber > 8) {
            throw new IllegalArgumentException("The # cars should in range (1,8) ");
        }
    }

    public static void validateCarName(String carName){
        if (carName.length() > 5 || carName.isEmpty() || carName.matches(".*\\s+.*")||carName.contains("'")||carName.contains("\"")){
            throw new IllegalArgumentException("Invalid car name.");
        }
    }

    public static void validateTrialCount(String trialCount){
        try{
            int count = Integer.parseInt(trialCount);
            if (count <= 0){
                throw new IllegalArgumentException("The # trials should be a positive integer");
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid trial count. Please enter a valid Integer");
        }
    }
}
