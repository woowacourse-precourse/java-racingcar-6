## Racing을 위한 클래스는 두 가지가 존재하며,
## 다음과 같은 기능들을 구현했습니다.

- CarController: CarService에 존재하는 메소드를 호출하기 위한 클래스입니다.
  - void race(): CarService의 race를 호출하여 주요 비즈니스 로직을 수행합니다.
 
- CarService: 주요 비즈니스을 수행하기 위한 메소드가 모인 클래스입니다.
  - 내부 클래스로 Car 클래스가 존재하며, 클래스는 다음과 같은 변수를 가지고 있습니다.
      - String name: Car의 이름을 저장합니다.
      - int length: 해당 Car의 전체 거리를 저장합니다.
      - int curLength: 무작위 숫자에 따라 전진 혹은 정지를 구분합니다.
  - void race(): 다른 메소드를 호출하면서 레이싱을 하기 위한 절차를 수행하는 메소드입니다.
  - String[] getInput(): 옳바른 입력값을 받아 String 배열형으로 반환합니다.
  - void checkLength(String s): 길이가 5이상, 0이하인 이름을 가진 Car가 존재할 경우 IllegalArgumentException이 발생합니다.
  - String[] splitInput(String input): 입력받은 String을 쉼표를 기준으로 구분하여 String[]로 반환합니다.
  - void runOrStop(Car[] cars): 무작위 값을 만들어 전진 혹은 정지를 구분하여 해당 Car에 값을 저장합니다.
  - void printCar(Car[] cars, StringBuilder sb): 전진 혹은 정지 여부에 따라 현재 누적된 거리와 합해 총 거리를 출력합니다.
  - void printRunCar(Car car, StringBuilder sb): 전진이 가능할 경우 StringBuilder에 "-"를 추가합니다.
  - void carStateInit(Car[] cars): 전진 혹은 정지 여부에 따라 누적 거리를 계산합니다.
  - String checkMaxCar(Car car, int maxLength): 가장 긴 거리를 가진 max값과 같을 경우 값을 Car의 name을 반환합니다. 그 외는 ""를 반환합니다.
  - List<String> getMaxCarWithOutNotNull(List<String> list): list에 ""를 제외한 모든 요소를 List<String> 으로 감싸 반환합니다.
  - void printResult(Car[] cars, StringBuilder sb): 가장 긴 거리를 가진 Car를 List로 만들어 결과를 출력합니다.
