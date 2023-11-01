package racingcar;

public class IntegrityCheck {
    public boolean originalNameIntegrityCheck(String originalName){
        return (originalName.isEmpty() || originalName.charAt(originalName.length() - 1) == ',');
    }
    public boolean nameIntegrityCheck(String name){
        if (name.length() > 5 || name.length() == 0){
            return true;
        }
        for (int i = 0; i < name.length(); i++){
            if ((name.charAt(i) <= 8) || (14 <= name.charAt(i) && name.charAt(i) <= 31)){
                return true;
            }
        }
        return false;
    }

    public boolean intIntegrityCheck(String str){
        if (str.isEmpty()){
            return true;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < '0' || '9' < str.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
