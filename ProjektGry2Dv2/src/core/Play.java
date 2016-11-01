/*
    pętla główna, możliwe że zostanie podzielona na poszczególne metody, zobaczy się
 */
package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
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
    static int x, y;

    Play(int mainLoop) {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //info: tutaj inicjalizujemy wszystkie obiekty które się pojawią
        map = new TiledMap("Resources/graphics/maps/mapTest.tmx");
        img = new Image("Resources/Graphics/Character/heroTest.png");

        x = 400;
        y = 400;

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //info: tutaj kalkulacje, movement itp
        int objectLayer = map.getLayerIndex("Objects");

        map.getTileId(0, 0, objectLayer);

        Input input = gc.getInput(); //input czyli nacisniety klawisz, mysz itp
        ActionHandler.handle(input, delta);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //info: tutaj wyświtlamy to co wyliczyliśmy w update
        map.render(0, 0);
        img.draw(x, y, x + 48, y + 48, 0, 0, 48, 48);
        //(startXonWindow,startYonWindow,endXonWindow,endYonWindow,
        //  startXpartOfpicture,startYpartOfpicture,endXpartOfpicture,endYpartOfpicture)
    }

    public Play() {
        //super("Projekt Gry 2D RPG");
    }

    @Override
    public int getID() {
        return 1;
    }

}
