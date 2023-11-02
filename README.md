# Notification Service

## Overview
There are two microservices in this github account, the Order Service and the Notification Service, which work together to implement an event-driven architecture using Apache Kafka. The Order Service is responsible for processing and generating orders, while the Notification Service consumes events from Kafka to send notifications to users based on the orders.

## Prerequisites
Before you can set up and run this system, ensure you have the kafka installed in your local system. You can use Docker Compose to define and run the necessary Docker containers for Confluent components, including Kafka, ZooKeeper.

Create a Docker Compose YAML file to define your Confluent Platform environment. You can create a file named docker-compose.yml with the following content:
~~~
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
~~~

**Steps to get started with Kafka**
1. Save the Docker Compose file in a location of your choice.
2. Open your terminal and navigate to the directory where you saved the Docker Compose file.
3. Run the following command to start the Confluent Platform containers:
~~~
docker-compose up -d
~~~
The -d flag runs the containers in the background.

**Stop Kafka**

When you're done, you can stop and remove the containers using the following command:
~~~
docker-compose down
~~~
