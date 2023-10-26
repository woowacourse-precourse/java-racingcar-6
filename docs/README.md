
## Car
- Car(String) : String형 값을 입력으로 받아 name 멤버변수에 저장함. 입력값의 길이가 5 초과면 IllegalArgumentException 발생함
- add() : track 멤버변수에 "-"를 추가
- getName() : name 반환
- getTrackLength() : 현재 track의 길이 반환
- toString : "Car이름 : ------"의 형식으로 String 데이터 반환
- compareTo : 각 Car 객체의 track 길이 대소 비교함

## RacingCarGame
- run() : RacingCar 전체 프로세스 동작
- inputNames() : String값을 받아서 , 를 기준으로 분할한 뒤, 각각의 이름을 가진 Car 인스턴스를 cars 리스트에 추가함
- inputTryLimit : 시도 횟수 입력후 tryLimit 멤버변수에 저장
- raceForOneTry() : 1번의 시도의 결과값을 String형 변수로 반환
- race() : 시도횟수의 결과값을 String형 변수로 반환
- setMax() : 가장 멀리 간 car의 거리 반환
- setWinnerCars : track길이가 max와 같은 car객체를 winnerCars 리스트에 추가
- getWinnerNames : winnerCars 리스트의 각 car 객체의 이름에 ","를 붙여 출력용 String 반환

- comment : 내부 데이터가 name과 track뿐이므로 map도 고려할만한 자료구조 후보이다. 