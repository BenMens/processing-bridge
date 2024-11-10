package nl.benmens.processing;

public interface MouseEventsHandler {
  default public void mousePressed(float mouseX, float mouseY, float pmouseX, float pmouseY) {
  }

  default public void mouseReleased(float mouseX, float mouseY, float pmouseX, float pmouseY) {
  }

  default public void mouseMoved(float mouseX, float mouseY, float pmouseX, float pmouseY) {
  }

  default public void mouseDragged(float mouseX, float mouseY, float pmouseX, float pmouseY) {
  }

  default public void mouseWheel(float mouseX, float mouseY, int count) {
  }
}