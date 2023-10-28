package Domain;

public class Cars {
    private final String[] carNames;

    public Cars(String[] carNames) {
        this.carNames = carNames;
    }

    public void move() {
        for (String carName : carNames) {
            System.out.println(carName + " : " + "-");
        }
    }

    public String getWinners() {
        return "최종 우승자 : ";
    }
}
