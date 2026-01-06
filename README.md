# Spring Boot Kafka Integration 

This project demonstrates **Apache Kafka publish–subscribe messaging** using **Spring Boot**, without Docker.

It shows how a REST API produces messages to Kafka and how a consumer processes them asynchronously.

---

## Project Contains

- Kafka Producer & Consumer using Spring Boot
- Asynchronous communication
- Decoupled microservice-style design
- JSON message serialization
- Local Kafka + ZooKeeper setup


## Architecture Flow

1. Client sends HTTP request to `/kafka/orders` , `kafka/notifications`
2. Controller publishes order message to Kafka topic
3. Kafka broker stores the message
4. Kafka consumer reads and processes the message
5. Output is logged in console


---

## Prerequisites

Ensure the following are installed:

- Java 17+
- Maven
- Apache Kafka (binary distribution)

---

## Kafka Setup (Local – Without Docker)

### Start ZooKeeper
`bin/zookeeper-server-start.sh config/zookeeper.properties`

### Start Kafka Broker
`bin/kafka-server-start.sh config/server.properties`

### Create Topics

```bash
bin/kafka-topics.sh --create --topic orders \
  --bootstrap-server localhost:9092 \
  --partitions 3 \
  --replication-factor 1

bin/kafka-topics.sh --create --topic notifications \
  --bootstrap-server localhost:9092 \
  --partitions 2 \
  --replication-factor 1

