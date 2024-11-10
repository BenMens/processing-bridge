package nl.benmens.processing;

import processing.event.KeyEvent;

public interface KeyEventsHandler {
  default public void keyPressed(KeyEvent event) {
  }

  default public void keyReleased(KeyEvent event) {
  }
}