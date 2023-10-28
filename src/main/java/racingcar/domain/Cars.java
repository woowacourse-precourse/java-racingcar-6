package racingcar.domain;

public class Cars {
    String[] CarNames;
    public Cars(String[] carNameList) {
        CarNames = carNameList;
    }
    public String[] getCarNames(){
        return CarNames;
    }

//    public String[] setCarNames(String[] carnames){
//        this.CarNames = carnames;
//    }
}
