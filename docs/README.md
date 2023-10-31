## 📌 클래스 구현 구조도

    main
    ㄴ Application.java              // Main
        ㄴ Application Class
    ㄴ Racing.java                   // Controller
        ㄴ Racing Class
    ㄴ Car.java                      // Model
        ㄴ Car Class
    ㄴ Output.java                   // View
        ㄴ Output Class

## 📌 기능 구현 리스트

    - [ ] 게임에 참여할 유저 입력받기
        ㄴ [ ] 유저에게 Console.getline() 이용해서 String 입력받기
        ㄴ [ ] 유저에게 입력받은 문자열 ',' 단위로 분리하기
        ㄴ [ ] 분리한 Car 이름 Arraylist에 넣기
        ㄴ [ ] 입력받은 값의 오류 검증 
            ㄴ [ ] 입력받은 값에 공백이 있는지 검사

    - [ ] 게임을 몇 회 진행할 것인지 입력받기
        ㄴ [ ] 유저에게 Console.getlins() 이용해서 String 입력받기
        ㄴ [ ] 유저에게 입력받은 문자열 Integer.ParseInt로 정수 변환
        ㄴ [ ] 정수로 변환받은 값 정수형 클래스 변수에 입력하기
        ㄴ [ ] 입력받은 값의 오류 검증
            ㄴ [ ] 입력받은 값에 공백이 있는지 검사

    - [ ] 레이싱 게임 실행
        ㄴ [ ] 반복문 : 사용자가 입력한 라운드 수만큼 호출
            ㄴ [ ] 반복문 : 게임을 진행하는 유저의 수만큼 호출
        ㄴ [ ] 랜덤으로 값을 뽑아 이동할지 안이동할지 결정
            ㄴ [ ] 유저의 값을 랜덤으로 뽑음
            ㄴ [ ] 유저의 Index에 해당하는 ArrayList<int> 값 +1

    - [ ] 우승자 탐색하기
        ㄴ [ ] Car마다의 Index에 해당하는 Arraylist<int>의 값에 따라
            ㄴ [ ] 만일 최댓값이면 기존의 Arraylist를 초기화 후 이름 넣기
            ㄴ [ ] 만일 최댓값과 같으면 이름만 추가하기 - 공동 1등

    - [ ] 출력하기
        ㄴ [ ] 각 라운드 진행상황 출력하기
            ㄴ Index별로 이름 : 이동 거리만큼 "-" 출력하기
        ㄴ [ ] 우승자 출력하기
            ㄴ 게임 종료후 우승자 출력하기