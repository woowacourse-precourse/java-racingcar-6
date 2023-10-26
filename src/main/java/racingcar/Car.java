package racingcar;

public class Car {
    private String carName;
    private Integer gameProgress = 0;

    public void forward(Integer randomNum) {
        if (randomNum >= 4) {
            gameProgress++;
        }
    }
    public Car(String carName) {
        this.carName = carName;
    }

    public String getGameProgressByHyphens() {
        StringBuilder hyphens = new StringBuilder();
        for (int i = 0; i < gameProgress; i++) {
            hyphens.append("-");
        }
        return hyphens.toString();
    }

    public Integer getGameProgress() {
        return gameProgress;
    }
}
