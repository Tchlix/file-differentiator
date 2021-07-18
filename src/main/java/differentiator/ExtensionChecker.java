package differentiator;

import differentiator.extensions.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ExtensionChecker {

    private AbstractExtension[] extensions = {
            new txtExtension(),
    };

    public Boolean isSupported(String fileExtension) {
        for (AbstractExtension extension : extensions) {
            if (extension.getFileExtension().equals(fileExtension))
                return true;
        }
        return false;
    }

    public String checkExtension(String filePath, String fileExtension) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath,"r");
        for (AbstractExtension extension : extensions){
            if(extension.check(file))
                return extension.getFileExtension();
        }

        if(isSupported(fileExtension)){
            throw new IllegalArgumentException("Extension lies, real file type isn't supported");
        }
        else {
            throw new IllegalArgumentException("Extension not supported");
        }
    }
}
