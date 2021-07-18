package differentiator.extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class AbstractExtension {
    private final String fileExtension;
    public AbstractExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    public abstract boolean check(RandomAccessFile file) throws IOException;

    public String getFileExtension() {
        return fileExtension;
    }
}
