# jms-mq-example
Basic Example to use MQ with Spring

# IMPORTANT
Artifact wmq.jmsra necessary for the specific classes for MQ

    <groupId>com.ibm.mq</groupId>
    <artifactId>wmq.jmsra</artifactId>
    <version>9.1.1.0</version>

If you want to receive messages, you must activate the 'Client' connection mode on the QueueManager or you will be have the error message:

IBM MQ call failed with compcode '2' ('MQCC_FAILED') reason '2035' ('MQRC_NOT_AUTHORIZED').
