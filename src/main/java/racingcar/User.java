package racingcar;

public class User {
    private int playCount;
    private Car[] carList;
    private String[] splitCarNameList;
    protected static String carNameList;
    protected static String getPlayCount;

    public void splitCarNameAndVerify() {
        carNameList = carNameList.replaceAll(" ", "");
        splitCarNameList = carNameList.split(",", -1);

        Verify.checkDuplicateCarName(splitCarNameList);
        Verify.checkEmptyCarName(splitCarNameList);
        Verify.checkCorrectLengthCarName(splitCarNameList);
        generateCars(splitCarNameList);
    }

    public void generateCars(String[] splitCarNameList){
        int carCount = splitCarNameList.length;
        carList = new Car[carCount];
        for (int i = 0; i < carList.length; i++) {
            carList[i] = new Car(splitCarNameList[i]);
        }
        PrintView.printCreationCompelete();
    }

    public void parseIntPlayCountFromString() {
        Verify.checkIntegerInput(getPlayCount);
        playCount = Integer.parseInt(getPlayCount);
    }

    public int getPlayCount() {
        return playCount;
    }

    public Car[] getCarList() {
        return carList;
    }
}