package racingcar;

public class Check {
    public boolean checkCarName(String carlist){
        boolean result = true;
        //이름 중간에 공백이 있는 입력값 체크하기 위해서 작성 ( 중간에 공백이 있다면 요구사항에 부합하지 않는 입력값이라 판단)
        String noBlank = carlist.replace(" ","");
        if(noBlank.length()!=carlist.trim().length()) result = false;

        String[] car_list = noBlank.split(",");
        int comma = countComma(noBlank);
        // 컴마 갯수 +1 == car_list.length() 인지 체크
        if(comma+1!=car_list.length) result = false;
        if(!measureNameLength(car_list)) result = false;
        return result;
    }
    public boolean measureNameLength(String[] car_list){
        boolean result = true;
        for(int i=0;i<car_list.length;i++){
            if(car_list[i].length()>5||car_list[i].length()<0){
                result = false;
                break;
            }
        }
        return result;
    }
    public int countComma(String carlist){
        int result=0;
        for(int i=0;i<carlist.length();i++){
            if(carlist.charAt(i)==',')result++;
        }
        return result;
    }
}
