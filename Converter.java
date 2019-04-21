/**
 *
 * @author Ny Antso
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Converter{

private static final Logger LOG = Logger.getLogger(Converter.class.getName());

    public static void main(String[] args) {
        
        try {
            String line;
            String mp4File = "/home/nyantso/Bureau/video.mp4";
            String mp3File = "/home/nyantso/Bureau/audio.mp3";

            String cmd = "ffmpeg -i " + mp4File + " " + mp3File;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("Video converted successfully!");
            in.close();
        } catch (IOException | InterruptedException e) {
            LOG.log(Level.SEVERE, null, e);
        }

    }
}