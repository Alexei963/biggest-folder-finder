import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

  public static void main(String[] args) {
    String folderPath = "D:/Learning";
    File file = new File(folderPath);
    long start = System.currentTimeMillis();
    FolderSizeCalculator calculator = new FolderSizeCalculator(file);
    ForkJoinPool pool = new ForkJoinPool();
    long folderSize = pool.invoke(calculator);
    System.out.printf("Размер папки %s = %s\n", folderPath, folderSize);
    long duration = System.currentTimeMillis() - start;
    System.out.println("Время выполнения: " + duration);

  }
  public static long getFolderSize(File folder) {
    if (folder.isFile()) {
      return folder.length();
    }
    long sum = 0;
    File[] files = folder.listFiles();
    assert files != null;
    for (File file : files) {
      sum += getFolderSize(file);
    }
    return sum;
  }
}
