package mx.itesm.Bugged.Niveles.Sprites.TileObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import mx.itesm.Bugged.Niveles.LevelManager;
import mx.itesm.Bugged.Niveles.Screens.PlayScreen;

public class Obstacules extends InteractiveTiledObject {
    public Obstacules(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(LevelManager.OBSTACULE_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Obstacules", "Collision");
    }

    @Override
    public void update() {
        if(setToDesrtoy){
            world.destroyBody(body);
        }
    }

    @Override
    public void destroy() {
        setToDesrtoy = true;
    }
}
