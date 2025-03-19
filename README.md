# MongoDB 로깅을 사용하는 Kafka Consumer

이 프로젝트는 Spring Boot로 구축된 간단한 Kafka Consumer 애플리케이션입니다. Kafka 토픽에서 메시지를 수신하고, 이러한 메시지를 MongoDB 데이터베이스에 로그로 저장합니다.

## 사전 준비 사항

- Java 17 이상
- Docker Desktop
- MongoDB
- Kafka

## 설정

1. **저장소 클론**
   ```bash
   git clone https://github.com/wowDongHyeon/kafka-consumer.git
   ```

2. kafka-docker의 readme 참고
   https://github.com/wowDongHyeon/kafka-broker

   - kafka-docker가 기본 포트(9092)에서 로컬로 실행 중인지 확인합니다.

3. **MongoDB 구성**
   - MongoDB가 기본 포트(27017)에서 로컬로 실행 중인지 확인합니다.

4. **애플리케이션 속성 구성**
   - 필요에 따라 `src/main/resources/application.properties` 파일에서 MongoDB URI 및 Kafka 설정을 업데이트합니다.

## 애플리케이션 실행

- 다음 명령어를 사용하여 애플리케이션을 실행합니다:
  ```bash
  ./gradlew bootRun
  ```

## 애플리케이션 테스트

- Kafka Producer를 사용하여 `test-topic`에 메시지를 전송합니다.
 ``` 
curl -X POST "http://localhost:8080/send?topic=test-topic&message=bye"
```

- Consumer 어플리케이션에서 message를 수신하고, MongoDB에 로그메세지를 저장합니다.

- MongoDB에서 메시지가 `logs` 컬렉션에 consumer로 기록되었는지 확인합니다.

## 데모 캡처본

![image](https://github.com/user-attachments/assets/b11d0bb3-5ef6-4c2d-ba4c-329b1259d107)
![image](https://github.com/user-attachments/assets/0f9fae00-189d-42bc-84dd-231ff494e96f)

## 라이선스

이 프로젝트는 MIT 라이선스에 따라 라이선스가 부여됩니다. 
