package ru.kolyanpie.wip.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import ru.kolyanpie.wip.Wip;

public class HtmlLauncher extends GwtApplication {
    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(true);
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new Wip();
    }
}
