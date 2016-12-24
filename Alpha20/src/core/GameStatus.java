package core;

import model.Hero;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import model.Item;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GameStatus extends core.LoadEntity {

    /**
     * levelID ID obszaru na którym znajduje się obecnie gracz
     */
    public static int levelID;
    public TiledMap map;
    public String mapPath;
    public int x, y;

    /**
     * Dane o bohaterze, jego statystyki, wygląd, rasa itd
     */
    public Sprite sprite;
    public static model.Hero hero;

    /**
     * status postaci
     */
    public HashMap<Integer, model.Item> itemsInBag;
    public HashMap<Integer, model.Equip> equipInBag;
    public static ArrayList<model.Skill> skills;
    public static ArrayList<model.Quest> quest;

    /**
     * dane o entity
     */
    LoadEntity loadEntity;

    /**
     * Cząsteczki/Entities na mapie
     */
    public ArrayList<model.Npc> npc;
    public ArrayList<model.Enemy> enemy;
    public ArrayList<model.Item> loot;
    public ArrayList<model.Portal> portalMapList;

    /**
     *
     */
    public HashMap<Integer, model.Item> itemsInGame;
    public HashMap<Integer, model.Equip> equipInGame;
    public HashMap<Integer, model.Skill> skillsInGame;

    //wykania się tylko przy utworzeniu nowej gry
    //wykania się tylko przy utworzeniu nowej gry
    public GameStatus() throws SlickException {

        //ustawianie pozycji startu gry
        this.levelID = 101;
        mapPath = "graphic/map/" + Integer.toString(levelID) + ".tmx";
        map = new TiledMap(mapPath);

        this.sprite = new Sprite();

        this.x = (91 * 32) + 1;
        this.y = (84 * 32) + 1;

        //czysty bohater
        this.hero = new Hero();
        this.itemsInGame = new HashMap<>();
        this.equipInGame = new HashMap<>();
        this.quest = new ArrayList<>();
        this.skills = new ArrayList<>();

        //na pierwszej mapie nie ma mobów czy npc - więc kolekcje puste
        this.npc = new ArrayList<model.Npc>();
        this.enemy = new ArrayList<model.Enemy>();
        this.loot = new ArrayList<model.Item>();
        this.portalMapList = new ArrayList<model.Portal>();

        //wczytanie danych o mapie
        updateEntityFieldList(map);
        updatePortalMapList(portalMapList);
        loadAllItemsInGame(itemsInGame);
        loadAllEquipInGame(equipInGame);

    }

    /**
     * wykania się tylko przy utworzeniu nowej gry
     */
    public void NewGame() {
        //ustawianie pozycji startu gry
        this.levelID = 101;
        mapPath = "graphic/map/" + Integer.toString(levelID) + ".tmx";
        try {

            map = new TiledMap(mapPath);
            this.sprite = new Sprite();

            this.x = (91 * 32) + 1;
            this.y = (84 * 32) + 1;

            //czysty bohater
            this.hero = new Hero();
            this.itemsInBag = new HashMap<>();
            this.equipInBag = new HashMap<>();
            this.quest = new ArrayList<>();
            this.skills = new ArrayList<>();

            //na pierwszej mapie nie ma mobów czy npc - więc kolekcje puste
            this.npc = new ArrayList<model.Npc>();
            this.enemy = new ArrayList<model.Enemy>();
            this.loot = new ArrayList<model.Item>();
            this.portalMapList = new ArrayList<model.Portal>();

            //wczytanie danych o mapie
            updateEntityFieldList(map);
            updatePortalMapList(portalMapList);
        loadAllItemsInGame(itemsInGame);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
