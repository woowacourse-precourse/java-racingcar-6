## 기능 구현 목록
### 기능목록 전체 VIEW MAP
![VIEW MAP](Function_Implementation_Map(RacingCar_Main).jpg)

1. RacingCar 클래스 구현
   - 속성 : 이름(name),  현재위치(loc)
   - 함수
       - 생성자 : name을 입력받아서 객체를 생성할 수 있게함
       - getLoc : 현재 위치를 반환하는 함수 구현
       - reset : 현재의 위치를 0으로 리셋하는 함수 구현
       - accel : 확률을 통해 랜덤으로 이동하는 함수 구현

2. RacingCenter클래스 구현
   - 속성 : List<RacingCar> Cars
   - 함수
       - all_accel : 카센터 등록 차 모두 악셀(1회 시도)
       - print_locs : 카센터 등록차로 부터 현재 위치를 받아 실행결과처럼 출력
       - compare : 위치 비교 후 우승자 List<RacingCar> 반환

3. Main 클래스
    - RacingCenter 객체 생성
    - 이름 입력
        - 5글자초과 및 잘못된 입력 예외처리
        - n개의 RacingCar 객체 생성 → RacingCenter 등록
    - 횟수 입력 :
        - 양의 정수가 아니거나 잘못된 입력 시 예외처리(0도 잘못된 입력이라고 봄)
        - n회 반복(카센터 all_accel → 각각의 객체 accel → print_locs 실행 이동결과 출력)
    - compare 후 최종 우승자 반환
        - 동점자가 있을 수 있으므로 List<>를 통해 반환 받아 출력