package racingcar.model;


public class DistanceCounting {

    public Distance distance = new Distance();

    public String passCheck(int pass) {
        if(pass >= 4) {
            plusDistance("-");
            return totalDistance();
        }else {
            return totalDistance();
        }
    }

    public void plusDistance(String distance) {
        this.distance.setDistance(distance);
    }

    public String totalDistance() {
        return this.distance.getDistance();
    }
}