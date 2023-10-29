package service;

public class GameService {
    public List<String> splitName(String inputName) {
        List<String> names = inputName.split(",");
        return names;//공백 포함하는지 확인
        //공백 포함해서 , 없을 때 확인
    }
}
