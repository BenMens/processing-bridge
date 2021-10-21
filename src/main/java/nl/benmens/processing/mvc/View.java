package nl.benmens.processing.mvc;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PVector;

import nl.benmens.processing.MouseEventsHandler;
import nl.benmens.processing.SharedPApplet;
import nl.benmens.processing.observer.Subject;
import nl.benmens.processing.observer.SubscriptionManager;

public class View {
  private View parentView = null;
  protected ArrayList<View> childViews = new ArrayList<View>();

  public Rectangle2D.Float frameRect; // View dimension in Parent coordinates
  public Rectangle2D.Float boundsRect; // View dimension

  public boolean shouldClip = false;
  public boolean isVisible = true;

  public boolean hasBackground = false;
  public int backgroundColor = SharedPApplet.color(255);

  public SubscriptionManager subscriptionManager = new SubscriptionManager();
  public Subject<MouseEventsHandler> mouseEvents = new Subject<MouseEventsHandler>(this);

  public View(View parentView) {
    if (parentView == null) {
      this.frameRect = new Rectangle2D.Float(0, 0, SharedPApplet.getSharedApplet().width,
          SharedPApplet.getSharedApplet().height);
      this.boundsRect = new Rectangle2D.Float(0, 0, SharedPApplet.getSharedApplet().width,
          SharedPApplet.getSharedApplet().height);
    } else {
      this.frameRect = new Rectangle2D.Float(0, 0, parentView.boundsRect.width, parentView.boundsRect.height);
      this.boundsRect = new Rectangle2D.Float(0, 0, parentView.boundsRect.width, parentView.boundsRect.height);
    }

    setParentView(parentView);
    if (parentView == null) {
      registerEventHandlers();
    }
  }

  final public View getParentView() {
    return parentView;
  }

  private void unregisterEventHandlers() {
    if (parentView == null) {
      this.subscriptionManager.unsubscribeAll(SharedPApplet.getSharedApplet());
    }
  }

  private void registerEventHandlers() {

    if (parentView == null) {
      SharedPApplet.mouseEvents.subscribe(new MouseEventsHandler(){
        @Override
        public void mousePressed(float mouseX, float mouseY, float pmouseX, float pmouseY) {
          View targetView = getViewAtPos(mouseX, mouseY);

          while (targetView != null) {
            PVector mousePos = targetView.screenPosToViewPos(new PVector(mouseX, mouseY));
            PVector pmousePos = targetView.screenPosToViewPos(new PVector(pmouseX, pmouseY));
    
            if (targetView.mousePressed(mousePos.x, mousePos.y, pmousePos.x, pmousePos.y)) {
              break;
            } else {
              targetView = targetView.parentView;
            }
          }
        }

        @Override
        public void mouseReleased(float mouseX, float mouseY, float pmouseX, float pmouseY) {
          View targetView = getViewAtPos(mouseX, mouseY);

          while (targetView != null) {
            PVector mousePos = targetView.screenPosToViewPos(new PVector(mouseX, mouseY));
            PVector pmousePos = targetView.screenPosToViewPos(new PVector(pmouseX, pmouseY));
    
            if (targetView.mouseReleased(mousePos.x, mousePos.y, pmousePos.x, pmousePos.y)) {
              break;
            } else {
              targetView = targetView.parentView;
            }
          }
        }

        @Override
        public void mouseMoved(float mouseX, float mouseY, float pmouseX, float pmouseY) {
          View targetView = getViewAtPos(mouseX, mouseY);

          while (targetView != null) {
            PVector mousePos = targetView.screenPosToViewPos(new PVector(mouseX, mouseY));
            PVector pmousePos = targetView.screenPosToViewPos(new PVector(pmouseX, pmouseY));
    
            if (targetView.mouseMoved(mousePos.x, mousePos.y, pmousePos.x, pmousePos.y)) {
              break;
            } else {
              targetView = targetView.parentView;
            }
          }
        }

        @Override
        public void mouseDragged(float mouseX, float mouseY, float pmouseX, float pmouseY) {
          View targetView = getViewAtPos(mouseX, mouseY);

          while (targetView != null) {
            PVector mousePos = targetView.screenPosToViewPos(new PVector(mouseX, mouseY));
            PVector pmousePos = targetView.screenPosToViewPos(new PVector(pmouseX, pmouseY));
    
            if (targetView.mouseDragged(mousePos.x, mousePos.y, pmousePos.x, pmousePos.y)) {
              break;
            } else {
              targetView = targetView.parentView;
            }
          }
        }

        @Override
        public void mouseWheel(float mouseX, float mouseY, int count) {
          View targetView = getViewAtPos(mouseX, mouseY);

          while (targetView != null) {
            PVector mousePos = targetView.screenPosToViewPos(new PVector(mouseX, mouseY));
    
            if (targetView.mouseWheel(mousePos.x, mousePos.y, count)) {
              break;
            } else {
              targetView = targetView.parentView;
            }
          }
        }
      }, subscriptionManager);
    }
  }

  final public void setParentView(View newParentView) {
    if (parentView != newParentView) {

      unregisterEventHandlers();

      if (parentView != null) {
        parentView.childViews.remove(this);
      } else {
        this.subscriptionManager.unsubscribeAll(SharedPApplet.getSharedApplet());
      }

      parentView = newParentView;

      if (parentView != null) {

        if (!parentView.childViews.contains(this)) {
          parentView.childViews.add(this);

          parentView.onChildViewAdded(this);
        }
      } 

      registerEventHandlers();
    }
  }

  final public ArrayList<View> getChildViews() {
    return childViews;
  }

  public void makeChildsVisible() {
    for (View child : childViews) {
      child.isVisible = true;
    }
  }

  public void makeChildsInvisible() {
    for (View child : childViews) {
      child.isVisible = false;
    }
  }

  public final void draw() {
    if (!isVisible) {
      return;
    }

    Rectangle2D.Float clipBoundary = getClipBoundary();
    String renderer = SharedPApplet.sketchRenderer();
    if (clipBoundary != null && renderer.endsWith("PGraphicsJava2D")) {
      PVector clipBoundaryTopLeft = new PVector(clipBoundary.x, clipBoundary.y);
      PVector clipBoundaryBottomRight = new PVector(clipBoundary.x + clipBoundary.width, 
                                                    clipBoundary.y + clipBoundary.height);

      clipBoundaryTopLeft = screenPosToViewPos(clipBoundaryTopLeft);
      clipBoundaryBottomRight = screenPosToViewPos(clipBoundaryBottomRight);

      clipBoundary = new Rectangle2D.Float(
        clipBoundaryTopLeft.x,
        clipBoundaryTopLeft.y,
        clipBoundaryBottomRight.x - clipBoundaryTopLeft.x,
        clipBoundaryBottomRight.y - clipBoundaryTopLeft.y
      );
    }

    if (clipBoundary == null || (clipBoundary.width > 0 && clipBoundary.height > 0)) {
      SharedPApplet.push();

      SharedPApplet.translate(frameRect.x, frameRect.y);
      PVector scale = getScale();
      SharedPApplet.scale(scale.x, scale.y);
      SharedPApplet.translate(-boundsRect.x, -boundsRect.y);

      if (clipBoundary != null) {
        SharedPApplet.clip(
          Math.round(clipBoundary.x), 
          Math.round(clipBoundary.y), 
          Math.round(clipBoundary.width), 
          Math.round(clipBoundary.height));
      } else {
        SharedPApplet.noClip();
      }

      if (hasBackground) {
        SharedPApplet.background(backgroundColor);
      }

      beforeDrawChildren();

      for (View childView : childViews) {
        if (clipBoundary != null) {
          SharedPApplet.clip(
            Math.round(clipBoundary.x), 
            Math.round(clipBoundary.y), 
            Math.round(clipBoundary.width), 
            Math.round(clipBoundary.height));
        } else {
          SharedPApplet.noClip();
        }

        childView.draw();
      }

      if (clipBoundary != null) {
        SharedPApplet.clip(
          Math.round(clipBoundary.x), 
          Math.round(clipBoundary.y), 
          Math.round(clipBoundary.width), 
          Math.round(clipBoundary.height));
      } else {
        SharedPApplet.noClip();
      }

      afterDrawChildren();

      SharedPApplet.pop();
    }
  }

  public void beforeDrawChildren() {
  }

  public void afterDrawChildren() {
  }

  public PVector composedScale() {
    PVector result = getScale();

    if (this.parentView != null) {
      PVector parentScale = this.parentView.composedScale();

      result.x *= parentScale.x;
      result.y *= parentScale.y;
    }

    return result;
  }

  public PVector screenSizeToViewSize(PVector size) {
    PVector result = size.copy();

    if (parentView != null) {
      result = parentView.screenSizeToViewSize(result);
    }

    PVector scale = getScale();

    result.x /= scale.x;
    result.y /= scale.y;

    return result;
  }

  public PVector getScale() {
    return new PVector(frameRect.width / boundsRect.width, frameRect.height / boundsRect.height);
  }

  public void setScale(float scale) {
    boundsRect.width = frameRect.width / scale;
    boundsRect.height = frameRect.height / scale;
  }

  public void setScale(PVector scale) {
    boundsRect.width = frameRect.width / scale.x;
    boundsRect.height = frameRect.height / scale.y;
  }

  public PVector viewSizeToScreenSize(PVector size) {
    PVector result = size.copy();

    PVector scale = getScale();
    result.x *= scale.x;
    result.y *= scale.y;

    if (parentView != null) {
      result = parentView.viewSizeToScreenSize(result);
    }

    return result;
  }

  public PVector screenPosToViewPos(PVector pos) {
    PVector result = pos.copy();

    if (parentView != null) {
      result = parentView.screenPosToViewPos(result);
    }

    result.sub(frameRect.x, frameRect.y);

    PVector scale = getScale();
    result.x /= scale.x;
    result.y /= scale.y;

    result.add(boundsRect.x, boundsRect.y);

    return result;
  }

  public PVector viewPosToScreenPos(PVector pos) {
    PVector result = pos.copy();

    result.sub(boundsRect.x, boundsRect.y);

    PVector scale = getScale();
    result.x *= scale.x;
    result.y *= scale.y;

    result.add(frameRect.x, frameRect.y);

    if (parentView != null) {
      result = parentView.viewPosToScreenPos(result);
    }

    return result;
  }

  public Rectangle2D.Float getClipBoundary() {
    Rectangle2D.Float viewClip = null;
    Rectangle2D.Float parentViewClip = null;

    if (shouldClip) {
      PVector upperLeft = viewPosToScreenPos(new PVector(boundsRect.x, boundsRect.y));
      PVector lowerRight = viewPosToScreenPos(new PVector(boundsRect.x + boundsRect.width, 
                                                          boundsRect.y + boundsRect.height));

      viewClip = new Rectangle2D.Float(
        upperLeft.x, 
        upperLeft.y, 
        lowerRight.x - upperLeft.x,
        lowerRight.y - upperLeft.y);
    }

    if (parentView != null) {
      parentViewClip = parentView.getClipBoundary();
    }

    if (viewClip != null && parentViewClip != null) {
      Rectangle2D intersection = parentViewClip.createIntersection(viewClip);

      return new Rectangle2D.Float(
          (float)intersection.getX(), 
          (float)intersection.getY(),
          (float)intersection.getWidth(), 
          (float)intersection.getHeight());
          
    } else if (viewClip != null) {
      return viewClip;
    } else if (parentViewClip != null) {
      return parentViewClip;
    }

    return null;
  }


  public View getViewAtPos(float x, float y) {
    Rectangle2D.Float boundary = getClipBoundary();
    View result = null;

    for (View childView : childViews) {
      result = childView.getViewAtPos(x, y);
      if (result != null) {
        break;
      }
    }

    if (result == null && (boundary == null || boundary.contains(x, y))) {
      result = this;
    }

    return result;
  }


  // ########################################################################
  // Mouse handling
  // ########################################################################
  public boolean mousePressed(float mouseX, float mouseY, float pmouseX, float pmouseY) {
    return false;
  }

  public boolean mouseReleased(float mouseX, float mouseY, float pmouseX, float pmouseY) {
    return false;
  }

  public boolean mouseMoved(float mouseX, float mouseY, float pmouseX, float pmouseY) {
    return false;
  }

  public boolean mouseDragged(float mouseX, float mouseY, float pmouseX, float pmouseY) {
    return false;
  }

  public boolean mouseWheel(float mouseX, float mouseY, int count) {
    return false;
  }


  public boolean onScroll(float mouseX, float mouseY, float mouseScroll) {
    return false;
  }


  // ########################################################################
  // FrameRect
  // ########################################################################

  public void setFrameRect(double x, double y, double width, double height) {
    Rectangle2D.Float oldRect = (Rectangle2D.Float) frameRect.clone();

    frameRect.setRect(x, y, width, height);

    onFrameRectChange(oldRect);
  }

  public Rectangle2D.Float getFrameRect() {
    return (Rectangle2D.Float) frameRect.clone();
  }

  public void onFrameRectChange(Rectangle2D.Float oldRect) {
  }

  // ########################################################################
  // BoundsRect
  // ########################################################################

  public void setBoundsRect(double x, double y, double width, double height) {
    boundsRect.setRect(x, y, width, height);
  }

  public Rectangle2D.Float getBoundsRect() {
    return (Rectangle2D.Float) boundsRect.clone();
  }

  // ########################################################################
  // View child events
  // ########################################################################

  public void onChildViewAdded(View clientView) {
  }

  // ########################################################################
  // Destruction
  // ########################################################################
  public final void destroy() {
    this.setParentView(null);

    for (Object childViewObject : (ArrayList<?>) childViews.clone()) {
      View childView = (View) childViewObject;
      childView.destroy();
    }

    this.mouseEvents.unsubscribeAll();

    onDestroy();
  }

  public void onDestroy() {
  }
}
