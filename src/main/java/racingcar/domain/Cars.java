package racingcar.domain;

public class Cars {
    String[] CarNames;
    int CarCount;
    int RaceCount;

    public Cars() {
    }

    public void setRaceCount(int raceCount){
        this.RaceCount = raceCount;
    }

    public int getRaceCount(){
        return RaceCount;
    }

    public int[] initNumber(int[] carRandomnumbers, int carCount){
        carRandomnumbers = new int[carCount];
        return carRandomnumbers;
    }

    public String[] getCarNames(){
        return CarNames;
    }

    public void setCarNames(String[] carnames){
        this.CarNames = carnames;
    }


}
