package Elevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ElevatorLogger
{
    public static void Info(String message) throws IOException
    {

        final String pathname = "elevatorlogs_" + LocalDate.now().getYear() + "_" + LocalDate.now().getMonth() + "_" + LocalDate.now().getDayOfMonth() + ".txt";
        final File file = new File("../logs/",pathname);
        file.mkdirs();
        try
        {
            file.createNewFile();
            FileWriter myWriter = new FileWriter(pathname,true);
            final String time = LocalTime.now().toString();
            myWriter.write(time + ": " + message+"\r\n");
            myWriter.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
