import org.code.theater.*;
import org.code.media.*;
public class myStory extends Scene{
  /*
  * instance variables
  */
  private String[][] score;
  private String[][] quarter;
  private ImageFilter[][] images;
  private String[][] recap;
  /*
  * constructor
  */
  public myStory(String[][] score, String[][] quarter, ImageFilter[][] images, String[][] recap){
    this.score = score;
    this.quarter = quarter;
    this.images = images;
    this.recap = recap;
  }
  /*
  * using our drawIntro, drawImages, drawRecap, and drawLast methods
  */
  public void drawScene(){
    drawIntro();
    drawImages(score, quarter, images);
    drawRecap(quarter, recap);
    drawLast();
  }
  /*
  * drawing our intro scene by drawing a title, description, and image
  */
  public void drawIntro(){
    clear("navy");
    setTextHeight(40);
    setTextColor("white");

    drawText("Super Bowl 48", 75, 50);
    ImageFilter football = new ImageFilter("superbowl.jpg");
    drawImage(football, 25, 75, 350);

    setTextHeight(20);
    pause(0.5);
    drawText("One of the most highly anticipated matchups", 9,305);
    pause(0.5);
    drawText("The number 1 ranked Offense(Broncos)", 24, 335);
    pause(0.5);
    drawText("The number 1 ranked Defense(Seahawks)", 15, 365);
    pause(0.5); 
  }
  /*
  * initialize through a two dimensional array, using our image filters through if statements
  */
  public void drawImages(String[][] score, String[][] quarter, ImageFilter[][] images){
    for(int row = 0; row < score.length; row ++){
      for(int col = 0; col < score[0].length; col ++){
        clear("navy");
        setTextHeight(30);
        drawText(score[row][col], 80, 380);
        drawText(quarter[row][col], 135, 38);
        if(row == 0 && col == 0){
          images[row][col].makeNegative();
        } else if(row == 1 && col == 0){
          images[row][col].colorize();
        } else if(row == 2 && col == 0){
          images[row][col].adjustContrast();
        } else if(row == 3 && col == 0){
          images[row][col].keepColor();
        }
        drawImage(images[row][col], 0, 60, 400);
        pause(1.5);
      }
    }    
  }
  /*
  * initialize through a two dimensional array and draw text, using a string class method
  */
  public void drawRecap(String[][] quarter, String[][] recap){
    for(int row = 0; row < recap.length; row ++){
      for(int col = 0; col < recap[0].length; col ++){
        clear("navy");
        setTextHeight(30);
        drawText(quarter[row][col].toUpperCase(), 100, 50);
        drawText(score[row][col], 80, 350);
        setTextHeight(25);
        drawText(recap[row][col].toLowerCase(), 25, 180);
        pause(1.5);
      }
    }
  }
  /*
  * draw the last page and playing a trumpet sound
  */
  public void drawLast(){
    clear("navy");
    playSound("trumpet_x.wav");
    setTextHeight(40);
    drawText("Final Results", 95, 50);
    drawImage("celebration.jpg", 0, 75, 400);
    setTextHeight(25);
    drawText("Seattle Seahawks Win! 43 - 8", 25, 350);
  }
}
