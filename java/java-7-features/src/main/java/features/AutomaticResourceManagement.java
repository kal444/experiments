package features;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

/**
 * @author kal
 */
public class AutomaticResourceManagement {
    public static void main(String[] args) throws IOException {
        try (
                // resource section
                // these resources need to be AutoClosable
                // any exception here will be suppressed if an exception happens in the actual block below
                // use Throwable.getSuppressed() to find them
                BufferedReader reader = new BufferedReader(new StringReader("HELLO!\nAND AGAIN!"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String line;
            while (reader.ready() && (line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
