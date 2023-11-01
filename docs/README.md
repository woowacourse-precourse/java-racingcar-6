셀프 피드백 
1. Conventional Commit 이라는 것을 알았다. 배우는 단계지만, 이것을 활용해 볼 생각이다
2. Print class를 만들고, Enum을 활용하여 console에 프린트 해야할 것들을 정리하고자 한다
3. 적절한 곳에 constant를 넣어 magic number를 안쓰도록 노력 할 생각이다
4. 꼭 필요하다고 느낄 때만 새로운 class를 만들고 싶어서, 고차원적 클래스 디자인을 배운다면
   깔끔하고 간단하게 코드를 정리하고자 하는 욕구가 있으나, 지금은 내가 제일 잘 이해할 수 있게 만들고 있다

Racecar
1. Game Constants 들을 모아서 클래스로 정리
2. Game input, output logic 구현
3. Game input validation, input error handling 구현
4. Builder pattern 으로 input을 구해와서 class object 구현 생각
   Car class는 만들면 좋겠고, CarBuilder도 있으면 나쁘지 않을지도
5. Car object들을 가지고 있으며, racecar game logic을 진행할 RacingGame 클래스가 있어야할듯
   NumOfCar x NumOfTrial 만큼 게임을 진행해야 될 것으로 예상
   Winning logic은 게임 진행 완료 후 단 한번만 확인 하면 되기 때문에 각 car object에
   위치를 저장하고, 우승자 계산 때 한번만 계산하게 설계
6. RNG 계산기가 따로 있어야할 것
7. Application은 게임 시작만 알리고 나머지는 다른 클래스에서 관리하기 위한 refactoring
