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
  // random background colour
  int intR = 0;
  int intG = 0;
  int intB = 0;

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

  // butterfly image
  PImage imgButterfly;
  // butterfly size
  int intFlyW = 55;
  int intFlyH = 43;

  // cloud image
  PImage imgCloud;
  // cloud size
  int intCloudW = 164;
  int intCloudH = 87;
  // cloud position
  float fltCloudX = 318;
  float fltCloudY = 257;
  // allows cloud movement
  boolean blnCloudUp = false;
  boolean blnCloudDown = false;
  boolean blnCloudLeft = false;
  boolean blnCloudRight = false;

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
    background(0, 0, 0);

    // flower images
    imgFlower1 = loadImage("flower1.png");
    imgFlower2 = loadImage("flower2.png");
    imgFlower3 = loadImage("flower3.png");

    // grass image
    imgGrass = loadImage("grass.png");
    imgGrass.resize(intGrassW, intGrassH);

    // butterfly image
    imgButterfly = loadImage("butterfly.png");
    imgButterfly.resize(intFlyW, intFlyH);

    // cloud image
    imgCloud = loadImage("cloud.png");
    imgCloud.resize(intCloudW, intCloudH);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // changes background colour and clears screen
    if (keyPressed) {
      background(0, 10, 100);
    }

    // changes back to original background colour
    if (key == ' ') {
      background(0, 0, 0);
    }

    // // changes background to another colour on click
    // intR = randomInt(255, 0);
    // intG = randomInt(255, 0);
    // intB = randomInt(255, 0);
    // if (mousePressed) {
    //   background(intR, intG, intB);
    // }

    // moves cloud
    if (blnCloudUp) {
      fltCloudY -= 3;
    }
    if (blnCloudDown) {
      fltCloudY += 3;
    }
    if (blnCloudLeft) {
      fltCloudX -= 3;
    }
    if (blnCloudRight) {
      fltCloudX += 3;
    }
    // prints cloud
    image(imgCloud, fltCloudX, fltCloudY);
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

  /**
   * prints grass on the cursor when dragged
   * 
   * @author NJudd
   */
  public void mouseDragged() {
    image(imgGrass, mouseX - 20, mouseY - 10);
  }

  /**
   * prints butterfly when mouse wheel is altered
   * 
   * @author NJudd
   */
  public void mouseWheel() {
    image(imgButterfly, mouseX - 28, mouseY - 21);
  }

  /**
   * allows the cloud to move when the arrow keys are pressed
   * 
   * @author NJudd
   */
  public void keyPressed() {
    if (keyCode == UP) {
      blnCloudUp = true;
    } else if (keyCode == DOWN) {
      blnCloudDown = true;
    } else if (keyCode == LEFT) {
      blnCloudLeft = true;
    } else if (keyCode == RIGHT) {
      blnCloudRight = true;
    }
  }

  /**
   * allows the cloud to stop moving when the arrow keys are released
   * 
   * @author NJudd
   */
  public void keyReleased() {
    if (keyCode == UP) {
      blnCloudUp = false;
    } else if (keyCode == DOWN) {
      blnCloudDown = false;
    } else if (keyCode == LEFT) {
      blnCloudLeft = false;
    } else if (keyCode == RIGHT) {
      blnCloudRight = false;
    }
  }
}