import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Main {

  public static void main(String[] args) {
    String folderPath = "D:/Learning";
    File file = new File(folderPath);
    Node root = new Node(file);
    long start = System.currentTimeMillis();
    FolderSizeCalculator calculator = new FolderSizeCalculator(root);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(calculator);
    Path fileText = Paths.get("text.txt");
    try {
      Files.writeString(fileText, root.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    long duration = System.currentTimeMillis() - start;
    System.out.println("Время выполнения: " + duration);
  }
}
