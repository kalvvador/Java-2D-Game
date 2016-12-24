package states;

import gameUtils.Fonts;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PauseState extends BasicGameState {

    String mouse;
    String onScreenLoc;
    gameUtils.Fonts fonts;
    String actualScr;

    //Pole sterujące aktywną zakładką
    //-- 0 - GRA, -- 1 - OPCJE
    private static int actualSubWindow = 0;

    //Kolory zakładek
    Color cw = Color.white;
    Color co = Color.orange;
    Color c[] = {Color.orange, Color.white};

    //Kolory tekstu na przyciskach
    Color ctab[] = {cw, cw, cw, cw};

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mouse = "";
        onScreenLoc = " ";

        //Wytworzenie własnej czcionki
        fonts = new gameUtils.Fonts();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        //Tło sceny - rozmyty printscreen
        actualScr = screenBlur.ScreenClass.screenNumber();
        Image skrinGB = new Image(actualScr);
        g.drawImage(skrinGB, 0, 0);
        //Okno character info
        Image menuW = new Image("graphic/menu/PauseState.png");
        g.drawImage(menuW, 0, 0);

        Fonts.print18().drawString(607, 142, "PAUZA");

        Fonts.print18().drawString(10, 10, "wsp myszy: " + mouse);
        Fonts.print18().drawString(10, 30, onScreenLoc);
        Fonts.print18().drawString(10, 50, "Bieżąca zakładka: " + String.valueOf(actualSubWindow));

        Fonts.print18().drawString(521, 184, "Gra", c[0]);
        Fonts.print18().drawString(711, 184, "Opcje", c[1]);

        Image buttonMS = new Image("graphic/menu/ButtonMS.png");

        int bx = 560;
        int by = 177;
        for (int i = 0; i < 4; i++) {
            g.drawImage(buttonMS, bx, by += 65);
        }

        // wyświetlanie dla zakładki gra
        if (actualSubWindow == 0) {
            Fonts.print18().drawString(591, 257, "Zapisz grę", ctab[0]);
            Fonts.print18().drawString(591, 319, "Wczytaj grę", ctab[1]);
            Fonts.print18().drawString(591, 384, " --- ", ctab[2]);
            Fonts.print18().drawString(591, 449, "Powrót do menu", ctab[3]);
        }
        // wyświetlanie dla zakładki opcje
        if (actualSubWindow == 1) {
            Fonts.print18().drawString(591, 257, "Opcja 1", ctab[0]);
            Fonts.print18().drawString(591, 319, "Opcja 2", ctab[1]);
            Fonts.print18().drawString(591, 384, "Opcja 3", ctab[2]);
            Fonts.print18().drawString(591, 449, "Opcja 4", ctab[3]);
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "x= " + xpos + " y=" + ypos;
        onScreenLoc = "x= " + xpos + " y=" + Math.abs(720 - ypos);

        for (int j = 0; j < ctab.length; j++) {
            ctab[j] = Color.white;
        }

        //powrót do gry (X)
        if ((xpos > 799 && xpos < 826) && (ypos > 564 && ypos < 592)) {
            if (input.isMouseButtonDown(0)) {
                sbg.enterState(1);
            }
        }
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(1);
        }

        //Sterowanie zakładkami
        if ((xpos > 455 && xpos < 641) && (ypos > 509 && ypos < 542)) {
            if (input.isMouseButtonDown(0)) {
                actualSubWindow = 0;
                c[0] = co;
                c[1] = cw;
            }
        }
        if ((xpos > 642 && xpos < 828) && (ypos > 509 && ypos < 542)) {
            if (input.isMouseButtonDown(0)) {
                actualSubWindow = 1;
                c[0] = cw;
                c[1] = co;
            }
        }
        //--------------Sterowanie przyciskami-----------------
        //Przycisk 1 
        if ((xpos > 570 && xpos < 720) && (ypos > 434 && ypos < 477)) {
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    sbg.enterState(10);
                } else {

                }
            }
            ctab[0] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                ctab[0] = Color.gray;
            }
        }
        //Przycisk 2 
        if ((xpos > 570 && xpos < 720) && (ypos > 369 && ypos < 412)) {
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    sbg.enterState(11);
                } else {

                }
            }
            ctab[1] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                ctab[1] = Color.gray;
            }
        }
        //Przycisk 3 
        if ((xpos > 570 && xpos < 720) && (ypos > 306 && ypos < 347)) {
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {

                } else {

                }
            }
            ctab[2] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                ctab[2] = Color.gray;
            }
        }
        //Przycisk 4 
        if ((xpos > 570 && xpos < 720) && (ypos > 239 && ypos < 283)) {
            if (input.isMouseButtonDown(0)) {
                if (actualSubWindow == 0) {
                    sbg.enterState(0);
                } else {

                }
            }
            ctab[3] = Color.orange;
            if (input.isMouseButtonDown(0)) {
                ctab[3] = Color.gray;
            }
        }
    }

    public PauseState(int state) {
    }

    @Override
    public int getID() {
        return 9;
    }

}
