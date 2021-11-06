package nl.benmens.processing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class PApplet extends processing.core.PApplet {

  protected static final Logger evolutionGameLogger = LogManager.getLogger();

  private Logger logger = evolutionGameLogger;

  public PApplet() {
    SharedPApplet.setSharedApplet(this);
  }

  protected Logger getLogger() {
    return logger;
  }

  protected void setLogger(Logger logger) {
    this.logger = logger;
  }

  @Override
  public void keyPressed(KeyEvent event) {
    for (KeyEventsHandler observer: SharedPApplet.keyEvents.getObservers()) {
      observer.keyPressed(event);
    }
  }

  @Override
  public void keyReleased(KeyEvent event) {
    for (KeyEventsHandler observer: SharedPApplet.keyEvents.getObservers()) {
      observer.keyReleased(event);
    } 
  }

  @Override
  public void mousePressed(MouseEvent event) {
    if(key < SharedPApplet.keysPressed.length) {
      SharedPApplet.keysPressed[key] = true;
    }

    for (MouseEventsHandler observer: SharedPApplet.mouseEvents.getObservers()) {
      observer.mousePressed(mouseX, mouseY, pmouseX, pmouseY);
    } 
  }

  @Override
  public void mouseReleased(MouseEvent event) {
    if(key < SharedPApplet.keysPressed.length) {
      SharedPApplet.keysPressed[key] = false;
    }

    for (MouseEventsHandler observer: SharedPApplet.mouseEvents.getObservers()) {
      observer.mouseReleased(mouseX, mouseY, pmouseX, pmouseY);
    } 
  }

  @Override
  public void mouseMoved(MouseEvent event) {
    for (MouseEventsHandler observer: SharedPApplet.mouseEvents.getObservers()) {
      observer.mouseMoved(mouseX, mouseY, pmouseX, pmouseY);
    } 
  }

  @Override
  public void mouseDragged(MouseEvent event) {
    for (MouseEventsHandler observer: SharedPApplet.mouseEvents.getObservers()) {
      observer.mouseDragged(mouseX, mouseY, pmouseX, pmouseY);
    } 
  }

  @Override
  public void mouseWheel(MouseEvent event) {
    for (MouseEventsHandler observer: SharedPApplet.mouseEvents.getObservers()) {
      observer.mouseWheel(mouseX, mouseY, event.getCount());
    } 
  }
}