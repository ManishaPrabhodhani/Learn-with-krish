import { Kafka } from "kafkajs";
import logger from "./logger/logger.js";


const kafka = new Kafka({
    brokers: ['localhost:9092'],
    clientId: 'order-service'
});

const topic = 'new-order'
const consumer = kafka.consumer({ groupId: 'order-group' });


await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {

        let value = JSON.parse(message.value)
        let from = value["orderid"];
        if (value["serviceName"] === "Allocation Service" & value["type"] === "Complete Allocation" & value["outcome"] === "SUCcESSFULL") {

            // get next five days date
            var currentDate = new Date();
            var futureDate = new Date(currentDate);
            futureDate.setDate(futureDate.getDate() + 5)
            // futureDate.format("yyyy/mm/dd");
            const formatDate = `${day}-${month}-${year}`;

            const day = ('0' + futureDate.getDate()).slice(-2);
            const month = ('0' + (futureDate.getMonth() + 1)).slice(-2);
            const year = futureDate.getFullYear();


            const ScheduleEvent = {
                serviceName: 'shedule-service',
                Type: 'Complete-shedule',
                uniueId: value["uniueId"],
                fuelQty: value["fuelQty"],
                orderid: value["orderId"],
                stockid: value["stockid"],
                outcome: "SUCESSFULL",
                Date: formatDate
            }
            const event = JSON.stringify(ScheduleEvent);
            console.log(event);
            console.log(ScheduleEvent);

            const producer = kafka.producer();
            const publish = async () => {
                await producer.connect().catch((e) => console.error(' Error', e));
                await producer.send({
                    topic: 'schedule-response', messages: [{ value: event },],
                })
            };
            publish().catch((e) => console.error(e));
        } 
    },
});