import differentiator.FileDifferentiator;

public class Main {
    public static void main(String[] args) {
        args = new String[]{"txt.txt","png.txt"};
        FileDifferentiator differentiator = new FileDifferentiator();
        differentiator.start(args);
    }
}
