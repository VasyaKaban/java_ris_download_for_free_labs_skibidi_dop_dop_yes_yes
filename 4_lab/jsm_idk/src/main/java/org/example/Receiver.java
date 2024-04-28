package org.example;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    }
)
public class Receiver implements MessageListener
{
    private List<String> messages = new ArrayList<>();

    @Override
    public void onMessage(Message message)
    {
        if(message instanceof TextMessage)
        {
            try
            {
                String text = ((TextMessage) message).getText();
                messages.add(text);

                if (messages.size() >= 10)
                    sortAndWriteMessagesToFile();
            }
            catch(JMSException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void sortAndWriteMessagesToFile()
    {
        Collections.sort(messages);

        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter("sorted_messages.txt");
            for(String message : messages)
                fileWriter.write(message + "\n");

            System.out.println("Messages sorted and written to file.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
