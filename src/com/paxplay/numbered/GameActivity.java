package com.paxplay.numbered;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.IResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.view.KeyEvent;

public class GameActivity extends BaseGameActivity  {

	  public static final int CW = 480;
	  public static final int CH = 800;
	  Camera camera;
	  
	  
	  
	  
  @Override
  public synchronized void onResumeGame() {
    super.onResumeGame();
  }

  @Override
  public synchronized void onPauseGame() {
    super.onPauseGame();
  }
  

  @Override
  public EngineOptions onCreateEngineOptions() {
    camera = new Camera(0, 0, CW, CH);
    IResolutionPolicy resolutionPolicy = new RatioResolutionPolicy(CW, CH);
    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, resolutionPolicy, camera);
    engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
    return engineOptions;
  }

  public static final int FPS_LIMIT = 60;
  
  @Override
  public Engine onCreateEngine(EngineOptions pEngineOptions) {
    Engine engine = new LimitedFPSEngine(pEngineOptions, FPS_LIMIT);
    return engine;
  }
  
  @Override
  public void onCreateResources(
      OnCreateResourcesCallback pOnCreateResourcesCallback)
      throws IOException {
    ResourceManager.getInstance().init(this);
    pOnCreateResourcesCallback.onCreateResourcesFinished();
  }
  
  
  @Override
  public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
      throws IOException {
    pOnCreateSceneCallback.onCreateSceneFinished(null);
  }

  @Override
  public void onPopulateScene(Scene pScene,
      OnPopulateSceneCallback pOnPopulateSceneCallback)
      throws IOException {
    pOnPopulateSceneCallback.onPopulateSceneFinished();
  }
  
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    return super.onKeyDown(keyCode, event);
  }

}