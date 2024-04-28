package org.example;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.naming.InitialContext;
import jakarta.naming.NamingException;

public class MessageSender
{
    public static void main(String[] args)
    {
        try
        {
            InitialContext initialContext = new InitialContext();

            ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/jms/ConnectionFactory");
            Queue queue = (Queue) initialContext.lookup("java:/jms/queue/Messages");

            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(queue);

            for(int i = 0; i < 10; i++)
            {
                String messageText = "Message " + i;
                TextMessage message = session.createTextMessage(messageText);
                producer.send(message);
                System.out.println("Sent message: " + messageText);
            }

            producer.close();
            session.close();
            connection.close();
        }
        catch(NamingException | JMSException e)
        {
            e.printStackTrace();
        }
    }
}
