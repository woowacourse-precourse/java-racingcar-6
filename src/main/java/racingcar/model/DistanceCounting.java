package racingcar.model;


public class DistanceCounting {

    public Distance distance = new Distance();

    public boolean passCheck(int pass) {
        if(pass >= 4) {
            plusDistance("_");
            return true;
        }else {
            return false;
        }
    }

    public void plusDistance(String distance) {
        this.distance.setDistance(distance);
    }

    public String totalDistance() {
        return this.distance.getDistance();
    }
}
