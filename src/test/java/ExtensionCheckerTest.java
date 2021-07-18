import differentiator.ExtensionChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtensionCheckerTest {
    ExtensionChecker checker = new ExtensionChecker();

    @Test
    public void missingFileTest(){
        Assertions.assertThrows(FileNotFoundException.class,() -> checker.checkExtension("nosuch.file",".file"));
    }
    @Test
    public void unsupportedExtensionTest(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> checker.checkExtension("ExampleFiles\\png.txt",".txt"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> checker.checkExtension("ExampleFiles\\png.gif",".gif"));
    }
    @Test
    public void txtTest() throws IOException {
        Assertions.assertEquals(".txt",checker.checkExtension("ExampleFiles\\txt.txt",".txt"));
        Assertions.assertEquals(".txt",checker.checkExtension("ExampleFiles\\txt.xor",".xor"));
        Assertions.assertNotEquals(".txt",checker.checkExtension("ExampleFiles\\jpg.txt",".txt"));
    }
    @Test
    public void singleMagicTest() throws IOException {
        Assertions.assertEquals(".gif",checker.checkExtension("ExampleFiles\\gif.gif",".gif"));
        Assertions.assertEquals(".gif",checker.checkExtension("ExampleFiles\\gif.png",".png"));
        Assertions.assertEquals(".jpg",checker.checkExtension("ExampleFiles\\jpg.txt",".txt"));
        Assertions.assertEquals(".jpg",checker.checkExtension("ExampleFiles\\jpg.avi",".avi"));

    }
    @Test
    public void doubleMagicTest() throws IOException{
        Assertions.assertEquals(".avi",checker.checkExtension("ExampleFiles\\avi.avi",".avi"));
        Assertions.assertEquals(".avi",checker.checkExtension("ExampleFiles\\avi.random",".random"));
    }
}
