Steps for creating kafka setup ,producer and consumer

Refer https://medium.com/@amberkakkar01/getting-started-with-apache-kafka-on-docker-a-step-by-step-guide-48e71e241cf2 for starting kafka and zoopker

Run Spring boot app

http://localhost:8080/api/kafka/send?message=HelloKafka

Console logs

Produced message: HelloKafka Consumed message: HelloKafka

Create a topic

C:\MyDrive\Study\docker>docker exec -it 778a030f1381 /opt/kafka/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my-topic Created topic my-topic.

Produce a Message C:\MyDrive\Study\docker>docker exec -it 778a030f1381 /opt/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my-topic

Hello from Docker! ^C

Consume a Message C:\MyDrive\Study\docker>docker exec -it 778a030f1381 /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning Hello from Docker!


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

======================================================
