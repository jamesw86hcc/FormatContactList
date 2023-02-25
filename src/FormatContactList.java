import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

/*James Williams
*2/24/2023
*
* The purpose of this project is to enhance skills with reading to, writing from, and formating files
* in Java. It takes a list of comma separated values from 'contacts.txt' and formats them into
* a more human-readable version in 'formatted-contacts.txt'.
* */

public class FormatContactList {

    public static void main(String[] args) throws IOException {
        Path outputFilePath = Paths.get("formatted-contacts.txt");
        File contactFile = new File("contacts.txt");

        try (Formatter formatter = new Formatter(outputFilePath.toFile())) {
            try (Scanner input = new Scanner(contactFile)) {

                while (input.hasNext()) {
                    String linex = input.nextLine();
                    //1,Norry,Killby,nkillby0@photobucket.com
                    //becomes
                    //Killby, Norry <nkillby0@photobucket.com>
                    String[] parameters = linex.split(",");
                    formatter.format("%s, %s <%s>\n", parameters[2], parameters[1], parameters[3]);
                }

                formatter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}