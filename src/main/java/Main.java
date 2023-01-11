import java.io.File;

public class Main {

  public static void main(String[] args) {
    String folderPath = "D:/Programs/Java";
    File file = new File(folderPath);
    System.out.printf("Размер папки %s = %s", folderPath, getFolderSize(file));

  }
  public static long getFolderSize(File folder) {
    if (folder.isFile()) {
      return folder.length();
    }
    long sum = 0;
    File[] files = folder.listFiles();
    for (File file : files) {
      sum += getFolderSize(file);
    }
    return sum;
  }
}
