package differentiator.extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SingleMagicExtension extends AbstractExtension{
    private final String magicNumber;
    private final int offset;
    private final int magicLength;

    public SingleMagicExtension(String extensionName,String magicNumber,int offset) {
        super(extensionName);
        this.magicNumber = magicNumber.toLowerCase();
        this.offset = offset;
        this.magicLength = magicNumber.length() / 2;
    }

    @Override
    public boolean check(RandomAccessFile file) throws IOException {
        file.seek(offset);
        byte[] data = new byte[magicLength];
        file.read(data,0, magicLength);
        StringBuilder builder = new StringBuilder();
        for(byte x : data){
            builder.append(String.format("%02x",x));
        }
        return builder.toString().equals(magicNumber);
    }
}
