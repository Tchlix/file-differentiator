package differentiator.extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class AbstractExtension {
    private final String extensionName;
    public AbstractExtension(String extensionName) {
        this.extensionName = extensionName;
    }
    public abstract boolean check(RandomAccessFile file) throws IOException;

    public String getExtensionName() {
        return extensionName;
    }
}
