package differentiator.extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DoubleMagicExtension extends AbstractExtension{
    private final String magicNumberHead;
    private final String magicNumberTail;
    private final int distanceBetween;
    private final int magicLengthHead;
    private final int magicLengthTail;

    public DoubleMagicExtension(String extensionName,String magicNumberHead,String magicNumberTail,int distanceBetween) {
        super(extensionName);
        this.magicNumberHead = magicNumberHead.toLowerCase();
        this.magicNumberTail = magicNumberTail.toLowerCase();
        this.distanceBetween = distanceBetween;
        this.magicLengthHead = magicNumberHead.length() / 2;
        this.magicLengthTail = magicNumberTail.length() / 2;
    }

    @Override
    public boolean check(RandomAccessFile file) throws IOException {
        file.seek(0);
        int maxLength = Integer.max(magicLengthHead, magicLengthTail);
        byte[] data = new byte[maxLength];
        file.read(data,0, magicLengthHead);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < magicLengthHead; i++){
            builder.append(String.format("%02x",data[i]));
        }
        if(!builder.toString().equals(magicNumberHead))
            return false;

        builder.setLength(0);
        file.seek(magicLengthHead + distanceBetween);
        file.read(data, 0, magicLengthTail);
        for(int i = 0; i < magicLengthTail; i++){
            builder.append(String.format("%02x",data[i]));
        }
        return builder.toString().equals(magicNumberTail);
    }
}
