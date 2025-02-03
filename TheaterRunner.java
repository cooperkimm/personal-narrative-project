import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
  /*
  * 2D arrays
  */
    String[][] score = {
      {"8 - 0 (Seahawks)"},
      {"22 - 0 (Seahawks)"},
      {"36 - 8 (Seahawks)"},
      {"43 - 8 (Seahawks)"},
    };
    String[][] quarter = {
      {"1st Quarter"},
      {"2nd Quarter"},
      {"3rd Quarter"},
      {"4th Quarter"},
    };
    ImageFilter[][] images = {
      {new ImageFilter("computer-science-1.jpg")},
      {new ImageFilter("seahawks-2.jpg")},
      {new ImageFilter("computer-science-3.jpg")},
      {new ImageFilter("computer-science-4.jpg")},
    };
    String[][] recap = {
      {"Early Safety 2 points(Seahawks)"},
      {"Pick-Six Interception(Seahawks)"},
      {"Return Touchdown(Seahawks)"},
      {"Passing Touchdown(Seahawks)"},
    };
  /*
  * initializing a myScene object and using our drawScene method
  */
    myStory myScene = new myStory(score, quarter, images, recap);
    myScene.drawScene();
    Theater.playScenes(myScene);
  }
}
