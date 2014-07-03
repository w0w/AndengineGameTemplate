package com.paxplay.numbered;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class ResourceManager {
  private static final ResourceManager INSTANCE = new ResourceManager();
  
  //common objects
  public GameActivity activity;
  public Engine engine;
  public Camera camera;
  public VertexBufferObjectManager vbom;
  
  private ResourceManager() {}
  
  public static ResourceManager getInstance() {
    return INSTANCE;
  }
  
  public void init(GameActivity activity) {
    this.activity = activity;
    this.engine = activity.getEngine();
    this.camera = engine.getCamera();
    this.vbom = engine.getVertexBufferObjectManager();
  }
}