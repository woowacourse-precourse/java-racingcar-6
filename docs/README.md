참여하는 차 이름을 저장하는 List, 라운드 횟수 round 필드, 예외 발생 유무 필드, 
그리고 차이름-전진횟수 Map을 전역변수로 생성하였습니다.

main함수에서 전역변수 객체를 생성하고, Map을 제외한 전역변수를 startGame()에서 초기화하였습니다.
startGame()에서 예외가 발생할 때 테스트코드에서 확인하기 위해 main에서 try-catch로 처리하지 않고 
boolean 전역변수로만 시스템 종료 여부를 다뤘습니다.

이후 round 만큼 반복할 while문과, 각각의 racing 진행, racingResult 결과로 횟수별 경기 현황을 
출력했습니다.

마지막에 whoWin()에서 Map의 Value 기준으로 max값을 찾기위해 
Collection 인터페이스로 변환해 우승자를 뽑아 출력하였습니다. 