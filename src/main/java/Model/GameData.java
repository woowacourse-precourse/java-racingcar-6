package Model;

public class GameData {

    private String[] cars;
    private int[] carDistance;
    private int carCount;

    public GameData(String[] input) {
        this.cars = input;
        this.carCount = input.length;
        this.carDistance = new int[carCount];
    }

    public int[] getTotalDistance(int[] distance) {
        for(int i=0; i<carCount; i++) {
            this.carDistance[i] += distance[i];
        }
        return carDistance;
    }

    public int getCarCount() {
        return carCount;
    }

    public String[] getCars() {
        return cars;
    }

    public int[] getCarDistance() {
        return carDistance;
    }
}
