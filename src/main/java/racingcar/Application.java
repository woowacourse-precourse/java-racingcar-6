package racingcar;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Service.getCarNamesFromUser();
        int tryCount = Service.getTryCountFromUser();
    }


}
