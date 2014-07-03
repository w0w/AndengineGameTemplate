package com.paxplay.numbered.scene;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.paxplay.numbered.GameActivity;
import com.paxplay.numbered.ResourceManager;

public abstract class BaseScene extends Scene {

  protected ResourceManager res = ResourceManager.getInstance();

  protected Engine engine;
  protected GameActivity activity;
  protected VertexBufferObjectManager vbom;
  protected Camera camera;
  
  public void initialize(GameActivity activity, ResourceManager res) {
    this.res = res;
    this.activity = activity;
    this.vbom = activity.getVertexBufferObjectManager();
    this.engine = activity.getEngine();
    this.camera = engine.getCamera();
  }
  
  public abstract void loadResources();
  public abstract void create();
  public abstract void unloadResources();
  public abstract void destroy();
  public void onBackKeyPressed() {
    Debug.d("Back key pressed");
  }
  public abstract void onPause();
  public abstract void onResume();
}