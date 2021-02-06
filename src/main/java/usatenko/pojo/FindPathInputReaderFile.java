package usatenko.pojo;

import usatenko.constants.ConsoleConstants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{

    public String readFileAsString() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Path path = Paths.get(classLoader.getResource(ConsoleConstants.FILE_PATH).toURI());
            return new String(Files.readAllBytes(path));
        } catch (URISyntaxException | IOException e) {
          throw new IllegalStateException("Cannot read data from file");
        }
    }
}
