# 기능 구현 목록

## ResultPrinter : 게임 결과를 출력
- [] 사용자에게 입력 받기 위한 질문을 출력할 함수
- [] 게임 회차 별 자동차 이름과 함께 결과 출력할 함수
- [] 최종 우승자 인원 수에 따른 결과 출력할 함수

## InputValue : 사용자의 입력 값 확인 후 저장하고 필요한 타입으로 변환을 수행
- [] inputName : 사용자에게 받은 이름들을 저장할 String 변수
- [] 사용자에게 받은 inputName을 리스트에 파싱
- [] count : 주어진 회수를 int로 변환해서 저장할 변수
    - [] inputCount : 주어진 회수를 저장할 String 변수
- [] 사용자에게 입력 받은 이름이 5자 이하인 지 확인할 함수
    - 5자 이상이면 IllegalArgumentException으로 예외 처리
- [] 사용자에게 입력 받은 이름이 중복이 있는지 확인할 함수
    - 중복이 있으면 IllegalArgumentException으로 예외 처리

## Car
- [] 자동차 이름, 위치
- [] 앞으로 가는 함수
- [] 멈추는 함수

## Race
- [] Car 객체 생성을 위한 Car List 변수
- [] Car 객체를 생성하고 그 객체를 List에 담는 함수

## Winner
- [] winner를 체크할 함수
  - Car.position가 가장 높은 값을 찾고 Car.carName은 GameManager.winner list에 add
  - 같은 Car.position를 가진 Car.carName이 존재하면 그 carName도 GameManager.winner에 add
  - winner 크기에 따라 ResultPrinter에 존재하는 우승자 출력 함수 호출

## GameManager  : 프로그램의 전반적인 실행, 종료 등을 수행
- Application에서 실행될 대상
- [] Car 객체 생성을 위한 Car List 생성
- [] 우승자를 저장할 winner list 생성
- [] Game을 실행시키기 위한 기본적인 셋팅을 하는 함수
- [] pickNumberInRange를 통해 Random값 생성하는 함수
- [] Random값을 이용해 car의 전진함수를 호출할지 멈춤 함수를 호출할지 확인하는 함수