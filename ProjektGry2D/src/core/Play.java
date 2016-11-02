package core;

import core.ActionHandler;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
    
    private TiledMap map;
    private Image img;
    GameStatus gs = new GameStatus();
    int [] duration = {200,200,200,200}; 
    Animation hero, movingUp, movingDown, movingLeft, movingRight ;
    double  shiftX = gs.x + 550;
    double  shiftY = gs.y  + 400;;
    
        
        
        
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        map = new TiledMap("Resources/graphics/maps/mapTest.tmx");
        img = new Image("Resources/Graphics/Character/heroTest.png");
        
        gs.x = 400;
        gs.y = 400;
        
        Image [] walkDown =  {img.getSubImage(0, 0, 48, 48),img.getSubImage(48, 0, 48, 48)
                             ,img.getSubImage(96, 0, 48, 48),img.getSubImage(144, 0, 48, 48)};
        Image [] walkLeft =  {img.getSubImage(0, 48, 48, 48),img.getSubImage(48, 48, 48, 48)
                             ,img.getSubImage(96, 48, 48, 48),img.getSubImage(144, 48, 48, 48)};
        Image [] walkRight = {img.getSubImage(0, 96, 48, 48),img.getSubImage(48, 96, 48, 48)
                             ,img.getSubImage(96, 96, 48, 48),img.getSubImage(144, 96, 48, 48)};
        Image [] walkUp =    {img.getSubImage(0, 144, 48, 48),img.getSubImage(48, 144, 48, 48)
                             ,img.getSubImage(96, 144, 48, 48),img.getSubImage(144, 144, 48, 48)};
        
        movingDown = new Animation(walkDown, duration, false);
        movingLeft = new Animation(walkLeft, duration, false);
        movingRight = new Animation(walkRight, duration, false);
        movingUp = new Animation(walkUp, duration, false);
        
        hero = movingDown;
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //info: tutaj kalkulacje, movement itp
        
        Input input = gc.getInput(); 
        
        //ActionHandler.handlePlay(input, gc, gs, sbg, delta);
        
        if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
            hero = movingUp;
            gs.y -= gs.heroSpeed * 0.1f * delta;
        }
        if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
            hero = movingDown;
            gs.y += gs.heroSpeed * 0.1f * delta;
        }
        if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
            hero = movingLeft;
            gs.x -= gs.heroSpeed * 0.1f * delta;
        }
        if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
            hero = movingRight;
            gs.x += gs.heroSpeed * 0.1f * delta;
        }
        if(input.isKeyDown(Input.KEY_ESCAPE)) {
            sbg.enterState(2);
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(0, 0,(int)(gs.x / 32),(int)(gs.y / 32),32,23);
         // mapa skacze, wiem i poprawie to - kalvador :)
         
        hero.draw((float)shiftX,(float)shiftY);
        //img.draw(GameStatus.x, GameStatus.y, GameStatus.x + 48, GameStatus.y + 48, 0, 0, 48, 48);
        //(startXonWindow,startYonWindow,endXonWindow,endYonWindow,
        //  startXpartOfpicture,startYpartOfpicture,endXpartOfpicture,endYpartOfpicture)
    }
    
    Play(int mainLoop) {
    }
    public Play() {
    }
    @Override
    public int getID() {
        return 1;
    }

}
