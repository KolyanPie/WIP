package ru.kolyanpie.wip.ui.components;

import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuBar;
import com.kotcrab.vis.ui.widget.MenuItem;

public class WipBar extends MenuBar {
    public WipBar() {
        Menu aboba = new Menu("Aboba");
        aboba.addItem(new MenuItem("biba"));
        aboba.addItem(new MenuItem("boba"));
        addMenu(aboba);
    }
}
