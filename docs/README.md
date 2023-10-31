# Racing Game 🚘

## 📌 기능 설계

1. Car에 대한 정보를 담고있을 Car class
    1. car의 정보를 string으로 반환해주는 carInfo 메소드
2. 게임에 참가하는 Car들을 담아둘 cars class
   Car의 집합인 cars라는 attributes를 갖는다.   
   생성자에서 게임에 참가하는 여러 Car 들을 생성하여 cars에 넣어준다.   
   게임에 참가한 Car 중에서 거리 카운트가 최대인 Car의 거리 카운트를 반환해준다.
3. 숫자 범위를 담고있는 enum 타입의 Range class
   MAX_VALUE와 MIN_VALUE를 지정해준다.
4. 여러 문자열들을 상수처리하여 담고있는 enum타입의 Texts class
   대표적으로는 게임시작시 안내문구, 입력 안내문구 등이 있다.
5. 각 round의 진행을 위한 Round class   
   pickNumberInRange method를 보다 간편하게 가다듬고, 게임에 출전한 각 Car 별로
   random 숫자를 뽑고 조건에 따라 거리 카운트를 그대로 두거나, 증가시켜주는 기능을 가지고 있다.
   Car class의 carInfo method를 통해 라운드 진행 상황을 출력해주는 기능도 있다.
6. 우승자 정보를 담은 Winner class
   공동 우승이 있을 수 있기에, 우승자들의 정보를 담을 집합인 winners를 attributes로 가진다.   
   모든 라운드가 끝난 후, maxCount와 같은 count 값을 가지는 Car들을 winners에 담아준다.   
   winners에 담겨있는 우승자들을 출력해주는 기능도 가진다.
7. 실제 게임을 진행하는 PlayRacingGame class
   게임에 참가하는 Car들을 담는 cars, 총 몇회의 round가 진행될 것인지를 확인할 roundCount,
   그리고 가장 많이 이동한 거리가 몇인지를 담기위한 maxCount를 attributes로 가진다.  
   게임을 시작하기 위해 입력을 받는 기능, 입력받은 roundCount 만큼 round를 실행해주는 play기능,
   게임 진행 후 경기 결과를 출력해주는 기능 등을 가진다.  
   또한 입력을 받을때, 게임 조건에 맞춰 오류가 있는지 판별해주는 method도 가지고 있다.
