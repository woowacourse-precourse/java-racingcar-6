package racingcar.model;

public enum Distance {
    DISTANCE;
    private static int MAX_DIST = 0;

    public void update(int dist) {
        MAX_DIST = Math.max(dist, MAX_DIST);
    }

    public int getMaxDist() {
        return MAX_DIST;
    }
}
