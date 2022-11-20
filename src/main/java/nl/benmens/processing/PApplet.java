package nl.benmens.processing;

import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class PApplet extends processing.core.PApplet {

  public PApplet() {
    PAppletProxy.setSharedApplet(this);
  }

  @Override
  public void handleDraw() {
    super.handleDraw();
  }

  @Override
  protected void handleKeyEvent(KeyEvent event) {
    super.handleKeyEvent(event);
    PAppletProxy.keyEvents().onNext(event);
  }

  @Override
  protected void handleMouseEvent(MouseEvent event) {
    super.handleMouseEvent(event);
    PAppletProxy.mouseEvents().onNext(event);
  }  
}