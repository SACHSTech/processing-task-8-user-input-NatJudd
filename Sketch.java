import processing.core.PApplet;
import processing.core.PImage;

/**
 * creates a drawing program to demonstrate various input capabilities
 * 
 * @author NJudd
 */
public class Sketch extends PApplet {
  // screen size variables
  int intScreenW = 800;
  int intScreenH = 600;

  // flower images
  PImage imgFlower1;
  PImage imgFlower2;
  PImage imgFlower3;

  // flower width to height scale
  double dblFlowerScale = 1.4;

  // grass image
  PImage imgGrass;

  // grass size
  int intGrassW = 40;
  int intGrassH = 20;

  /**
   * initializes background size
   * 
   * @author NJudd
   */
  public void settings() {
    size(intScreenW, intScreenH);
  }

  /**
   * initializes images and background
   * 
   * @auther NJudd
   */
  public void setup() {
    // background colour
    background(210, 255, 173);

    // flower images
    imgFlower1 = loadImage("flower1.png");
    imgFlower2 = loadImage("flower2.png");
    imgFlower3 = loadImage("flower3.png");

    // grass image
    imgGrass = loadImage("grass.png");
    imgGrass.resize(intGrassW, intGrassH);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
  }

  /**
   * generates a random integer from 1 to 3
   * 
   * @param intMax maximum return value of the integer
   * @param intMin minimum return value of the integer
   * @return the random integer
   * @author NJudd
   */
  private int randomInt(int intMax, int intMin) {
    return (int) (Math.random() * intMax) + intMin;
  }

  /**
   * draws different coloured flowers on click
   * 
   * @author NJudd
   */
  public void mouseClicked() {
    // declares variable to a random integer
    int intRand = randomInt(3, 1);

    // randomizes flower sizes
    int intFlowerW = randomInt(30, 15);
    int intFlowerH = (int) Math.round(intFlowerW * dblFlowerScale);

    // values to adjust printing coordinates
    int intHalfW = (int) Math.round(intFlowerW / 2);
    int intHalfH = (int) Math.round(intFlowerH / 2);

    // prints different image based on integer value
    if (intRand == 1) {
      imgFlower1.resize(intFlowerW, intFlowerH);
      image(imgFlower1, mouseX - intHalfW, mouseY - intHalfH);
    } else if (intRand == 2) {
      imgFlower2.resize(intFlowerW, intFlowerH);
      image(imgFlower2, mouseX - intHalfW, mouseY - intHalfH);
    } else {
      imgFlower3.resize(intFlowerW, intFlowerH);
      image(imgFlower3, mouseX - intHalfW, mouseY - intHalfH);
    }
  }

  public void mouseDragged() {
      image(imgGrass, mouseX - 20, mouseY - 10);
  }
}