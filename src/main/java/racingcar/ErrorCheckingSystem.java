package racingcar;

public class ErrorCheckingSystem {

    public void errorSystem(String[] insertedNameList) {
        try {
            nameErrorChecking(insertedNameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void nameErrorChecking(String[] insertedNameList) {
        for (String carName : insertedNameList) {
            if(nameSizeChecking(carName)) {
                throw new IllegalArgumentException("this is more than 5");
            }
        }
    }
    public boolean nameSizeChecking(String insertedName) {
        int letterCount = 0;
        for (char isCounted : insertedName.toCharArray()) {
            if (Character.isLetter(isCounted)) {
                letterCount++;
            }
        }
        return letterCount > 5;
    }
    

}
