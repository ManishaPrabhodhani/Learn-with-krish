import { Kafka } from "kafkajs";
const kafka = new Kafka({
    broker: ['localhost:9092'],
    clientId: 'schedule-service',

});

const producer = kafka.producer();

const publish = async (ScheduleEvent) => {
    await producer.connect().catch((e) => console.error(' Error ', e));


    await producer.send({
        topic: 'order-response',
        message: [{ ScheduleEvent },
        ],
    });

};

publish().catch((e) => console.error(e));
export default publish;