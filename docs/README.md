## 기능 구현 목록
1. 레이싱 카 입력 기능 구현
   1. racing car input validator 구현 
      1. 잘못된 값이 입력된 경우 IllegalArgumentException을 발생
         1. 이름이 5자 초과할 경우
         2. 이름이 중복된 경우
2. 몇 번의 전진을 시도할 것인 지 입력 받는 기능 구현
    1. game try number input validator 구현
       1. 잘못된 값이 입력된 경우 IllegalArgumentException을 발생
          1. Integer으로 파싱이 안되는 경우 
          2. 0이하의 값을 가진 경우
3. 게임 전진 구현
   1. 자동차 별로 0부터 9 사이의 난수 생성
   2. 난수가 4 이상인 경우 한 칸 전진
   3. 난수가 4 미만인 경우 제자리
4. 게임 프린터 구현
    1. 게임 진행 상황 프린트 기능 구현
    2. 게임 결과 프린트 기능 구현

