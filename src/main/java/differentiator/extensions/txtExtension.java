package differentiator.extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class txtExtension extends AbstractExtension{
    public txtExtension() {
        super(".txt");
    }
    @Override
    public boolean check(RandomAccessFile file) throws IOException {
        int length = (int) Long.min(file.length(),8000);
        byte[] data = new byte[length];
        file.read(data,0,length);
        for (byte x : data) {
            if (x == '\0')
                return false;
        }
        return true;
    }
}
