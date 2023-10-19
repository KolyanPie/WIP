package ru.kolyanpie.wip;

import com.badlogic.gdx.Game;
import ru.kolyanpie.wip.ui.StartMenu;

public class Wip extends Game {
    @Override
    public void create() {
        setScreen(new StartMenu());
    }
}
