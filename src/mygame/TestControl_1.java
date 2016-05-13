/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Image;
import java.util.Random;

/**
 *
 * @author Daniel
 */
class TestControl_1 extends AbstractControl {

    private Node player;
    private Vector3f velocity;
    private Vector3f dist;
   // private Vector3f playerDirection;
    private TdMap map;
    private Spatial temp;
    private Vector3f[] sa;
    private int[] xn;
    private int[] yn;
    private float ratioxr;
    private float ratioyr;
    //private Vector3f tral;
    private Quad bgObject;
    private int counter = 0;
    private int nrCheckpoints = 0;

    public TestControl_1(Node player, Quad ver, Image mapImage) {
        this.player = player;

        map = new TdMap(mapImage, 15, 10);
        //   sa = new Vector3f[m.getVectors().length];
        velocity = new Vector3f(0, 0, 0);
        dist = new Vector3f(0, 0, 0);

        nrCheckpoints = map.getnodex().length;
        bgObject = ver;
        xn = map.getnodex();
        yn = map.getnodey();
        ratioxr = bgObject.getWidth() / map.getWidth();
        ratioyr = bgObject.getHeight() / map.getHeight();

    }

    @Override
    protected void controlUpdate(float tpf) {

      if(counter<nrCheckpoints){
           Vector3f tral = new Vector3f(-(bgObject.getWidth() / 2) + xn[counter] * ratioxr, -(bgObject.getHeight() / 2) + yn[counter] * ratioyr, spatial.getLocalTranslation().getZ());
           // while(tral.distance(spatial.getLocalTranslation()) > 0.3f) {
           Vector3f playerDirection = tral.subtract(spatial.getLocalTranslation());
                playerDirection.normalizeLocal();
            playerDirection.multLocal(10f);
            velocity.addLocal(playerDirection);

            velocity.multLocal(0.8f);
            spatial.move(velocity.mult(0.1f*tpf));
            

            if (tral.distance(spatial.getLocalTranslation()) < 1f) {

                velocity = Vector3f.ZERO;
                counter++;
            }
            
      }
      else{
               spatial.removeFromParent();
      }


   





        /*    //translate the seeker
         if (player.getQuantity() > 0 && temp == null) {
         Random r = new Random();
         int Low = 0;
         int High = player.getQuantity();
         int Result = r.nextInt(High - Low) + Low;
         temp = player.getChild(Result);
         temp.setUserData("target", true);

         playerDirection = temp.getLocalTranslation().subtract(spatial.getLocalTranslation());


             
         playerDirection.normalizeLocal();
         playerDirection.multLocal(1f);
         }

         if (temp != null && temp.getUserData("target").equals(false) && player.getQuantity() > 0) {
         Random r = new Random();
         int Low = 0;
         int High = player.getQuantity();
         int Result = r.nextInt(High - Low) + Low;
         temp = player.getChild(Result);
         temp.setUserData("target", true);

         playerDirection = temp.getLocalTranslation().subtract(spatial.getLocalTranslation());
         playerDirection.normalizeLocal();
         playerDirection.multLocal(1f);


         }
         if (temp != null && temp.getUserData("target").equals(true)) {
         velocity.addLocal(playerDirection);
         velocity.multLocal(0.8f);
         spatial.move(velocity.mult(tpf ));
         //player.getChild(i);

         // rotate the seeker
         // rotate the seeker
         if (velocity != Vector3f.ZERO) {
         spatial.rotateUpTo(velocity.normalize());
         spatial.rotate(0, 0, FastMath.PI / 2f);
         }
         if (temp.getLocalTranslation().distance(spatial.getLocalTranslation()) < 0.3f && player != null) {
         System.out.printf("Dist 0");
         Random r = new Random();
         int Low = 0;
         int High = 99;
         int Result = r.nextInt(High - Low) + Low;
         if (Result % 2 > 0) {
         temp.setUserData("target", false);
         temp.removeFromParent();
         } else {
         spatial.removeFromParent();
         }

         //velocity = Vector3f.ZERO;
         }
         }*/ {
        }

    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
