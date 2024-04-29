package Services;

import java.io.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AuditService implements IAuditService{


    private static AuditService instance = null;

    private AuditService(){}

    public static IAuditService getInstance() {
        if(instance == null)
            instance = new AuditService();
        return instance;
    }

    @Override
    public void writeMessage(String msg) {
        try{
            File file = new File("./StoreApp/src/CSV/audit.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The CSV file was created!");
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/audit.csv", true));

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = time.format(timeFormat);

            writer.write(msg + ", " + formattedTime + "\n");
            writer.close();

        }
        catch(IOException m){
            System.out.println("Audit Error!" + m);
        }

    }
}
