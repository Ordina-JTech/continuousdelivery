import java.util.Properties;

/**
 * Hello user! TODO Remove this class.....
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello user!");
  }

  public String getEnviromentValues() {
    
    Properties props = System.getProperties();
    return props.values().toString();
  }

}
