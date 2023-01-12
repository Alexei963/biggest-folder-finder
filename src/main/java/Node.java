import java.io.File;
import java.util.ArrayList;

public class Node {

  private File folder;
  private ArrayList<Node> children;
  private long size;
  private int level;

  public Node(File folder) {
    this.folder = folder;
    children = new ArrayList<>();
  }

  public File getFolder() {
    return folder;
  }

  public void setFolder(File folder) {
    this.folder = folder;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public void addChild(Node node) {
    node.setLevel(level + 1);
    children.add(node);
  }

  public ArrayList<Node> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<Node> children) {
    this.children = children;
  }

  public int getLevel() {
    return level;
  }

  private void setLevel(int level) {
    this.level = level;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String size = SizeCalculator.getHumanReadableSize(getSize());
    builder
        .append(folder.getName())
        .append(" - ")
        .append(size)
        .append("\n");
    for (Node child : children) {
      builder
          .append("\t".repeat(child.getLevel()))
          .append(child);
    }
    return builder.toString();
  }
}
