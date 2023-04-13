# kafka basic sample code

본 프로그램은 spring-kakfa 를 이용하여, 간단한 송/수신 기능만 만들어 본 것입니다.
localhost 에 kafka 가 실행되어 있어야 합니다. localhost:9092  와 같은 연결정보로 kafka 를 이용합니다. 


## test 방법
http client 툴을 이용해서 아래와 같이 전송하면 됩니다. 콘솔창에 수신한 메시지가 출력됩니다.
```
POST http://localhost:8080/kafka/send
Content-Type: text/plain

안녕하세요. kafka.
```