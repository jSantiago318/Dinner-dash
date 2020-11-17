package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage[] restart;
    public static BufferedImage title;
    public static BufferedImage floor;
    public static BufferedImage welcome;
    public static BufferedImage Pause;
    public static BufferedImage Win;
    public static BufferedImage GameOver;
    public static BufferedImage dishCart;
    public static BufferedImage[] Resume;
    public static BufferedImage[] people;
    public static BufferedImage[] chef;
    public static BufferedImage[] link;
    public static BufferedImage[] kitchenChairTable;
    public static BufferedImage[] kitchenCounter;
    public static BufferedImage[] ingredients;
    public static BufferedImage[] ingredientsAdded;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
    public static ImageIcon icon;
    public static SpriteSheet kitchenSpriteSheet;
    public static SpriteSheet kitchenCounterSpriteSheet;
    public static SpriteSheet burgerSpriteSheet;
    public static SpriteSheet chefSpriteSheet;
    public static BufferedImage[] PickleCounter;


    public static SpriteSheet linkSpriteSheet;

    public Images() {

    	restart = new BufferedImage[3];
        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        kitchenChairTable = new BufferedImage[3];
        people = new BufferedImage[11];
        kitchenCounter = new BufferedImage[13];
        ingredients = new BufferedImage[12];
        ingredientsAdded = new BufferedImage[3];
        chef = new BufferedImage[4];
        link = new BufferedImage[10];
        try {

            kitchenSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/sprite.png")));
            kitchenCounterSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/kitchen_cabinets_by_ayene_chan.png")));
            burgerSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/burger.png")));
            chefSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/chef.png")));
            linkSpriteSheet =  new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/LinkSprites.png")));
            
            
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
            Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
            Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/title.jpg"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Sheets/Pause.png"));
            Win = ImageIO.read(getClass().getResourceAsStream("/Sheets/WinState.png"));
            GameOver = ImageIO.read(getClass().getResourceAsStream("/Sheets/GameOverLink.png"));
            welcome = ImageIO.read(getClass().getResourceAsStream("/Sheets/WelcomeMat.png"));
            floor = ImageIO.read(getClass().getResourceAsStream("/Sheets/DinerDashBG2.jpg"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));//clickbut
            dishCart =  ImageIO.read(getClass().getResourceAsStream("/Sheets/DishCart.png"));
            restart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/newGameButton.png"));
            restart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/hoverNewGameButton.png"));
            restart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/clickNewGameButton.png"));           
            
            kitchenChairTable[0] = kitchenSpriteSheet.crop(21,27,62,54);
            kitchenChairTable[1] = kitchenSpriteSheet.crop(108,14,30,35);
            kitchenChairTable[2] = kitchenSpriteSheet.crop(108,52,30,35);

            people[0] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Car_Designer3Female.png"));
            people[1] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Doctor2Female.png"));
            people[2] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Freedom_Fighter2Male.png"));
            people[3] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Hipster.png"));
            people[4] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Lawyer2Male.png"));
            people[5] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Mad_Scientist3Female.png"));
            people[6] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Programmer2Male.png"));
            people[7] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Songwriter3Male.png"));
            people[8] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Weather_Reporter2Female.png"));
            people[9] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Gandalf.png"));
            people[10] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Inspector.png"));


            kitchenCounter[0] = kitchenCounterSpriteSheet.crop(224,12,32,43);//stoveTop
            kitchenCounter[1] = kitchenCounterSpriteSheet.crop(96,76,32,43);//Vegetables
            kitchenCounter[2] = kitchenCounterSpriteSheet.crop(193,70,32,49);//teaPot
            kitchenCounter[3] = kitchenCounterSpriteSheet.crop(0,245,30,43);//Empty
            kitchenCounter[4] = kitchenCounterSpriteSheet.crop(96,200,32,48);//fruit basket
            kitchenCounter[5] = kitchenCounterSpriteSheet.crop(64,73,32,46);//cheese
            kitchenCounter[6] = kitchenCounterSpriteSheet.crop(0,133,32,50);//plates
            kitchenCounter[7] = kitchenCounterSpriteSheet.crop(0,63,34,56);//buns
//            ADDED
            kitchenCounter[8] = kitchenCounterSpriteSheet.crop(93,64,34,56); //pickle
            kitchenCounter[9] = kitchenCounterSpriteSheet.crop(123,128,34,56);    //ketchup
            kitchenCounter[10] = kitchenCounterSpriteSheet.crop(189,64,34,57); //ability

            ingredients[0] = burgerSpriteSheet.crop(25, 16, 112, 43); // top bun
            ingredients[1] = burgerSpriteSheet.crop(30, 134, 103, 48); // patty
            ingredients[2] = burgerSpriteSheet.crop(169, 213, 102, 39); // cheese
            ingredients[3] = burgerSpriteSheet.crop(169, 158, 110, 41); // tomato
            ingredients[4] = burgerSpriteSheet.crop(161, 62, 117, 34); // lettuce
            ingredients[5] = burgerSpriteSheet.crop(444, 270, 115, 39); // bottom bun
            ingredients[6] = burgerSpriteSheet.crop(575, 263, 131, 51); // plate

//            ADDED
            ingredients[7] = burgerSpriteSheet.crop(25,68,128,47); //pinneapple
            ingredients[8] = burgerSpriteSheet.crop(313,151,128,47); //onion
            ingredients[9] = burgerSpriteSheet.crop(20,197,128,56); //pickle
            ingredients[10] = burgerSpriteSheet.crop(304,258,134,56); //fried chicken

            chef[0] = chefSpriteSheet.crop(30,3,66,120);
            chef[1] = chefSpriteSheet.crop(159,3,66,120);
            chef[2] = chefSpriteSheet.crop(287,3,67,120);
            chef[3] = chefSpriteSheet.crop(31,129,66,120);

            link[0] = linkSpriteSheet.crop(930, 767, 90, 120);
            link[1] = linkSpriteSheet.crop(830, 767, 90, 120);
            link[2] = linkSpriteSheet.crop(730, 767, 90, 120);
            link[3] = linkSpriteSheet.crop(625, 767, 90, 120);
            link[4] = linkSpriteSheet.crop(525, 767, 90, 120);
            link[5] = linkSpriteSheet.crop(410, 767, 90, 120);
            link[6] = linkSpriteSheet.crop(310, 767, 90, 120);
            link[7] = linkSpriteSheet.crop(210, 767, 90, 120);
            link[8] = linkSpriteSheet.crop(110, 767, 90, 120);
            link[9] = linkSpriteSheet.crop(10, 767, 90, 120);
            
            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage tint(BufferedImage src, float r, float g, float b) {

        // Copy image ( who made that so complicated :< )
        BufferedImage newImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(src, 0, 0, null);
        graphics.dispose();

        // Color image
        for (int i = 0; i < newImage.getWidth(); i++) {
            for (int j = 0; j < newImage.getHeight(); j++) {
                int ax = newImage.getColorModel().getAlpha(newImage.getRaster().getDataElements(i, j, null));
                int rx = newImage.getColorModel().getRed(newImage.getRaster().getDataElements(i, j, null));
                int gx = newImage.getColorModel().getGreen(newImage.getRaster().getDataElements(i, j, null));
                int bx = newImage.getColorModel().getBlue(newImage.getRaster().getDataElements(i, j, null));
                rx *= r;
                gx *= g;
                bx *= b;
                newImage.setRGB(i, j, (ax << 24) | (rx << 16) | (gx << 8) | (bx << 0));
        
            }
        }
        return newImage;
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
