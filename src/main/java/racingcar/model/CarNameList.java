package racingcar.model;


public class CarNameList {
    private final String[] carNameList;

    public CarNameList(String[] carNameList) {
        this.carNameList = carNameList;
    }

    public int getCarCount(){
        return carNameList.length;
    }

    public String[] getCarNameList(){
        return carNameList;
    }

    public void NameExceptionCheck(){
        for(int i=0; i<carNameList.length; i++){
            System.out.println("carNameList[i] = " + carNameList[i]);
            if(carNameList[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }
}
