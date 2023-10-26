package model
  package constants
    class playConstants: 게임 진행에 필요한 상수 및 멘트
    class resultConstants: 게임 결과에 필요한 상수
    class exceptionConstant: 예외 출력에 필요한 상수
    
  package data
    class car
      string name
      int point
    
  
  class controller: 게임 진행
    playGame();
    startGame();// 자동차 이름, 횟수 입력
    endGame();// 결과 출력 및 우승자 발표
    
  class service
    createCar(); parameter Name 받아서 Car 객체 생성
    createCarList(); Car객체로 list 생성
    inputTryNumber(); 시도 횟수 입력받음

    makeRandomNumber(); random 숫자 받아서 리턴
    isFourOrMore(); 4이상의 숫자인지 판단
    forwardCarByName(); 해당 이름을 가진 차 전진
    sortCarListByPoint(); car들을 point 기준 정렬
    searchWinnerPoint();
    makeWinnerList(); 포인트 숫자와 같으면 리스트에 입력 아니면 stop 조건
    makeWinnerNameList(); winner에서 이름만 뽑아서 String 값 resturn

    checkName();
    checkNames();
    checkTryNumber();


  class Exception
    nameLengthException(); 이름 1-5자
    duplicateNameException(); 이름 중복
    nameDivisionSignException(); 이름 구분 기호 에러

    tryNumberFormException(); try 입력값이 숫자인지
    tryNumberSizeException(); try 입력값이 0보다 작을 때

    
    


