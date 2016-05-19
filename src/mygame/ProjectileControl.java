/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author Daniel
 */
class ProjectileControl extends AbstractControl {
    private  Spatial target;
    private  Vector3f playerDirection;
    private Vector3f velocity;

    public ProjectileControl(Spatial target) {
        this.target = target;
        velocity = new Vector3f(0,0,0);
        playerDirection = new Vector3f(0,0,0);
    }

    @Override
    protected void controlUpdate(float tpf) {
        if(spatial.getLocalTranslation().distance(target.getLocalTranslation())< 1f){
        spatial.removeFromParent();
        int health = target.getUserData("Health");
        target.setUserData("Health", health -1);
        }
        if(spatial != null && target != null){
        playerDirection = target.getLocalTranslation().subtract(spatial.getLocalTranslation());
        playerDirection.normalizeLocal();
        playerDirection.multLocal(1f);        
         velocity.addLocal(playerDirection);
         velocity.multLocal(1.3f);
         spatial.move(velocity.mult(tpf ));
        }
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
