# 자동차 경주 게임

## 기능목록
[] 각 자동차 이름 입력(,로 구분 / 5자 이하)    메인에서 askCarNames()
[] 이동 횟수 입력 
    [] 0에서 9 사이에서 무작위 값을 구한 후    NumberGenerator#createRandomNumber()
    [] 전진 => 무작위 값 >= 4             TrafficLights#go()
    [] 정지 => 무작위 값 < 4              TrafficLights#stop()
    [] 과정 출력(ex. 이름 : --)               PrintProcess#onStreet()
[] 우승자 출력                           PickWineer#printWinner()
    [] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  


## 기능 요구 사항
[] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
[] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 예시
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 회수는 몇회인가요?
    5
    
    실행 결과
    pobi : -
    woni :
    jun : -
    
    pobi : --
    woni : -
    jun : --
    
    pobi : ---
    woni : --
    jun : ---
    
    pobi : ----
    woni : ---
    jun : ----
    
    pobi : -----
    woni : ----
    jun : -----
    
    최종 우승자 : pobi, jun