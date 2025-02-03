import org.code.theater.*;
import org.code.media.*;
public class ImageFilter extends ImagePlus{
  /*
   * fileName
   */
  public ImageFilter(String filename){
    super(filename);
  }
  /*
   * Image filter that inverts the colors in the image
   */
    public void makeNegative() {
      Pixel[][] pixels = getPixelsFromImage();
      for(int row = 0; row < pixels.length; row++){
        for(int col = 0; col < pixels[0].length; col ++){
          Pixel currentPixel = pixels[row][col];
          currentPixel.setRed(255 - currentPixel.getRed());
          currentPixel.setBlue(255 - currentPixel.getBlue());
          currentPixel.setGreen(255 - currentPixel.getGreen());
        }
      } 
    }
  /*
   * Image filter that multiplies the currentPixel by 5
   */
     public void adjustContrast(){
      Pixel[][] pixels = getPixelsFromImage();
      for(int row = 0; row < pixels.length; row++){
        for(int col = 0; col < pixels[0].length; col ++){
            Pixel currentPixel = pixels[row][col];
            currentPixel.setRed(5 * currentPixel.getRed());
            currentPixel.setBlue(5 * currentPixel.getBlue());
            currentPixel.setGreen(5 * currentPixel.getGreen());
        }
       }
     }
  /*
   * Image filter that finds the average of the three pixels and uses if statements to display colors
   */
    public void colorize() {
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row ++){
      for(int col = 0; col < pixels[0].length; col ++){
        Pixel currentPixel = pixels[row][col];
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();
        int averagePixel = (currentRed + currentGreen + currentBlue)/3;
        if(averagePixel < 85){
          currentPixel.setRed(255);
          currentPixel.setBlue(0);
          currentPixel.setGreen(0);
        } else if(averagePixel < 170){
          currentPixel.setRed(0);
          currentPixel.setBlue(0);
          currentPixel.setGreen(255);
        } else{
          currentPixel.setRed(0);
          currentPixel.setBlue(255);
          currentPixel.setGreen(0);
        }
      }
    }
  }
  /*
   * Original Image filter that finds the max color and sets the other colors to 0
   */
  public void keepColor(){
    Pixel[][] pixels = getPixelsFromImage();
    for(int row = 0; row < pixels.length; row ++){
      for(int col = 0; col < pixels[0].length; col ++){
        Pixel currentPixel = pixels[row][col];
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int maxColor = currentRed;
        if(currentGreen > maxColor && currentGreen > currentBlue){
          maxColor = currentGreen;
        } else if(currentBlue > maxColor && currentBlue > currentGreen){
          maxColor = currentBlue;
        }
        if(maxColor == currentRed){
          currentPixel.setBlue(0);
          currentPixel.setGreen(0);
        } else if(maxColor == currentBlue){
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
        } else if(maxColor == currentGreen){
          currentPixel.setRed(0);
          currentPixel.setBlue(0);
        }
      }
    }
  }
} 
