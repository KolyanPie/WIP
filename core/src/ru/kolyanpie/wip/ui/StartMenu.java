package ru.kolyanpie.wip.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisTable;
import ru.kolyanpie.wip.ui.components.WipBar;

public class StartMenu implements Screen {
    private final Stage stage;

    public StartMenu() {
        VisUI.load(VisUI.SkinScale.X2);
        stage = new Stage(new ScreenViewport());
        VisTable root = new VisTable();
        root.setFillParent(true);
        root.left().top();
        stage.addActor(root);
        root.add(new WipBar().getTable()).fillX().expandX().colspan(1).row();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.32f, 0, 0.64f, 1);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        //
    }

    @Override
    public void resume() {
        //
    }

    @Override
    public void hide() {
        //
    }

    @Override
    public void dispose() {
        VisUI.dispose();
        stage.dispose();
    }
}
