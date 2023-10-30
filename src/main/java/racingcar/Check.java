package racingcar;

public class Check {
    public boolean checkCarName(String carlist){
        boolean result = true;
        //이름 중간에 공백이 있는 입력값 체크하기 위해서 작성 ( 중간에 공백이 있다면 요구사항에 부합하지 않는 입력값이라 판단)
        String noBlank = carlist.replace(" ","");
        if(noBlank.length()!=carlist.trim().length()) result = false;

        String[] car_list = noBlank.split(",");
        // 컴마 갯수 세어주는 함수(컴마 한개 있으면 이름이 두개있어야 하기 때문입니다)
        // 컴마 갯수 +1 == car_list.length() 인지 체크
        // car_list 넣어주면 이름길이 0<이름<=5인지 체크해주는 함수
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
