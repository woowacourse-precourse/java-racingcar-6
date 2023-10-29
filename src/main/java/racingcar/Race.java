package racingcar;

final class Race {
    String[] carArray;
    int tryNumber;
    int[]raceAccumulations;

    public Race(String[]carArray,int tryNumber,int[]raceAccumulations){
        this.carArray = carArray;
        this.tryNumber = tryNumber;
        this.raceAccumulations=raceAccumulations;
    }
}
