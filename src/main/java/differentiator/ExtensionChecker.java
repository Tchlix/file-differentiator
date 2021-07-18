package differentiator;

import differentiator.extensions.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ExtensionChecker {

    private final AbstractExtension[] extensions = {
            new SingleMagicExtension(".gif","474946383761", 0),
            new SingleMagicExtension(".gif","474946383961",  0),
            new SingleMagicExtension(".jpg","ffd8ff",  0),
            new SingleMagicExtension(".jpg","FFD8FFE000104A4649460001",  0),
            new SingleMagicExtension(".jpg","FFD8FFEE",  0),
            new DoubleMagicExtension(".jpg","FFD8FFE1","457869660000",2),
            new DoubleMagicExtension(".wav","52494646","57415645",4),
            new txtExtension(),
    };

    public Boolean isSupported(String fileExtension) {
        for (AbstractExtension extension : extensions) {
            if (extension.getExtensionName().equals(fileExtension))
                return true;
        }
        return false;
    }

    public String checkExtension(String filePath, String fileExtension) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath,"r");
        for (AbstractExtension extension : extensions){
            if(extension.check(file))
                return extension.getExtensionName();
        }

        if(isSupported(fileExtension)){
            throw new IllegalArgumentException("Extension lies, real file type isn't supported");
        }
        else {
            throw new IllegalArgumentException("Extension not supported");
        }
    }
}
