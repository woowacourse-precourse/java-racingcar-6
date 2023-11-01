package racingcarFPMVC;

public class racingcarFPMVC {
    public static void main(String[] args) {
        try {
            new Controller().startRacing();
        } catch (Exception e) {
            throw new IllegalArgumentException("Exception occur");
        }
    }
}