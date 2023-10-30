package racingcar.model;


public class CarNameList {
    private static CarNameList instance;
    private final String[] carNameList;

    public CarNameList(String[] carNameList) {
        this.carNameList = carNameList;
    }

    public static CarNameList getinstance(String[] carNameList){
        if(instance == null){
            instance = new CarNameList(carNameList);
        }
        return instance;
    }

    public void PrintCarName(){
        for(String s : carNameList){
            System.out.println(s);
        }
    }
}
