package mx.itesm.Bugged.Niveles.Sprites.Enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import mx.itesm.Bugged.Niveles.Screens.PlayScreen;

public abstract class Enemy extends Sprite {
    protected World world;
    public Body b2body;
    Vector2 velocity;
    public PlayScreen screen;
    protected MapObject object;
    int damaged;
    boolean flip;


    Enemy(PlayScreen screen, float x, float y, MapObject object){
        this.object = object;
        this.screen = screen;
        this.world = screen.getWorld();
        TiledMap map = screen.getMap();
        setPosition(x,y);
        defineEnemy();
        velocity = new Vector2(0,0.5f);
        b2body.setActive(false);

    }

    protected abstract void defineEnemy();
    public abstract void update(float dt);
    public abstract void onHeadHit();
    public abstract void setShot(boolean shot);

    public void destroy() {
        damaged = 3;
    }

    //protected abstract TextureRegion getFrame(float dt);

    boolean toFlip(){
        return this.screen.getPlayer().b2body.getPosition().x > this.b2body.getPosition().x;
    }

    void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;

        if(y)
            velocity.y = -velocity.y;
    }

    public Enemy getEnemy(){
        return this;
    }

}
