package differentiator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDifferentiator {

    private final ExtensionChecker checker = new ExtensionChecker();

    public void start(String filePath){
        differentiate(filePath);
    }

    public void start(String[] filePaths){
        for(String filePath : filePaths)
            differentiate(filePath);
    }
    private void differentiate(String filePath){
        String fileExtension;
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filePath.length() -1){
            fileExtension = null;
        }
        else {
            fileExtension = filePath.substring(dotIndex);
        }
        try {
            String foundExtension = checker.checkExtension(filePath,fileExtension);
            if(fileExtension == null){
                System.out.println("File doesn't have an extension, but its a " + foundExtension);
            }
            else if(fileExtension.equals(foundExtension)){
                System.out.println(filePath + " correct extension");
            }
            else {
                System.out.printf("%s extension is %s while actually file is a %s%s",
                        filePath,fileExtension,foundExtension,System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Couldn't open " + filePath);
        }
        catch (IllegalArgumentException e){
            System.out.println(filePath + " " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
