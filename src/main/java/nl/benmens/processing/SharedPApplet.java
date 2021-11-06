package nl.benmens.processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import nl.benmens.processing.observer.Subject;
import nl.benmens.processing.observer.Subscription;
import nl.benmens.processing.observer.SubscriptionManager;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PMatrix;
import processing.core.PMatrix2D;
import processing.core.PMatrix3D;
import processing.core.PShape;
import processing.core.PStyle;
import processing.core.PSurface;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.data.Table;
import processing.data.XML;
import processing.event.Event;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
import processing.opengl.PGL;
import processing.opengl.PShader;

public class SharedPApplet {
  private static PApplet sharedApplet;

  public static Subject<KeyEventsHandler> keyEvents;
  public static Subject<MouseEventsHandler> mouseEvents;

  public static boolean[] keysPressed = new boolean[128];

  private SharedPApplet() {}

  static public void rect(float a, float b, float c, float d) {
    sharedApplet.rect(a, b, c, d);
  }

  static public final float alpha(int rgb) {
    return sharedApplet.alpha(rgb);
  }

  static public void ambient(int rgb) {
    sharedApplet.ambient(rgb);
  }

  static public void ambient(float gray) {
    sharedApplet.ambient(gray);
  }

  static public void ambient(float v1, float v2, float v3) {
    sharedApplet.ambient(v1, v2, v3);
  }

  static public void ambientLight(float v1, float v2, float v3) {
    sharedApplet.ambientLight(v1, v2, v3);
  }

  static public void ambientLight(float v1, float v2, float v3, float x, float y, float z) {
    sharedApplet.ambientLight(v1, v2, v3, x, y, z);
  }

  static public void applyMatrix(PMatrix source) {
    sharedApplet.applyMatrix(source);
  }

  static public void applyMatrix(PMatrix2D source) {
    sharedApplet.applyMatrix(source);
  }

  static public void applyMatrix(PMatrix3D source) {
    sharedApplet.applyMatrix(source);
  }

  static public void applyMatrix(float n00, float n01, float n02, float n10, float n11, float n12) {
    sharedApplet.applyMatrix(n00, n01, n02, n10, n11, n12);
  }

  static public void applyMatrix(float n00, float n01, float n02, float n03, float n10, float n11, float n12, float n13,
      float n20, float n21, float n22, float n23, float n30, float n31, float n32, float n33) {
    sharedApplet.applyMatrix(n00, n01, n02, n03, n10, n11, n12, n13, n20, n21, n22, n23, n30, n31, n32, n33);
  }

  static public void arc(float a, float b, float c, float d, float start, float stop) {
    sharedApplet.arc(a, b, c, d, start, stop);
  }

  static public void arc(float a, float b, float c, float d, float start, float stop, int mode) {
    sharedApplet.arc(a, b, c, d, start, stop, mode);
  }

  static public void attrib(String name, float... values) {
    sharedApplet.attrib(name, values);
  }

  static public void attrib(String name, int... values) {
    sharedApplet.attrib(name, values);
  }

  static public void attrib(String name, boolean... values) {
    sharedApplet.attrib(name, values);
  }

  static public void attribColor(String name, int color) {
    sharedApplet.attribColor(name, color);
  }

  static public void attribNormal(String name, float nx, float ny, float nz) {
    sharedApplet.attribNormal(name, nx, ny, nz);
  }

  static public void attribPosition(String name, float x, float y, float z) {
    sharedApplet.attribPosition(name, x, y, z);
  }

  static public void background(int rgb) {
    sharedApplet.background(rgb);
  }

  static public void background(float gray) {
    sharedApplet.background(gray);
  }

  static public void background(PImage image) {
    sharedApplet.background(image);
  }

  static public void background(int rgb, float alpha) {
    sharedApplet.background(rgb, alpha);
  }

  static public void background(float gray, float alpha) {
    sharedApplet.background(gray, alpha);
  }

  static public void background(float v1, float v2, float v3) {
    sharedApplet.background(v1, v2, v3);
  }

  static public void background(float v1, float v2, float v3, float alpha) {
    sharedApplet.background(v1, v2, v3, alpha);
  }

  static public void beginCamera() {
    sharedApplet.beginCamera();
  }

  static public void beginContour() {
    sharedApplet.beginContour();
  }

  static public PGL beginPGL() {
    return sharedApplet.beginPGL();
  }

  static public void beginRaw(PGraphics rawGraphics) {
    sharedApplet.beginRaw(rawGraphics);
  }

  static public PGraphics beginRaw(String renderer, String filename) {
    return sharedApplet.beginRaw(renderer, filename);
  }

  static public void beginRecord(PGraphics recorder) {
    sharedApplet.beginRecord(recorder);
  }

  static public PGraphics beginRecord(String renderer, String filename) {
    return sharedApplet.beginRecord(renderer, filename);
  }

  static public void beginShape() {
    sharedApplet.beginShape();
  }

  static public void beginShape(int kind) {
    sharedApplet.beginShape(kind);
  }

  static public void bezier(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.bezier(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  static public void bezier(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
      float x4, float y4, float z4) {
    sharedApplet.bezier(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  static public void bezierDetail(int detail) {
    sharedApplet.bezierDetail(detail);
  }

  static public float bezierPoint(float a, float b, float c, float d, float t) {
    return sharedApplet.bezierPoint(a, b, c, d, t);
  }

  static public float bezierTangent(float a, float b, float c, float d, float t) {
    return sharedApplet.bezierTangent(a, b, c, d, t);
  }

  static public void bezierVertex(float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.bezierVertex(x2, y2, x3, y3, x4, y4);
  }

  static public void bezierVertex(float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4,
      float z4) {
    sharedApplet.bezierVertex(x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  static public void blend(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
    sharedApplet.blend(sx, sy, sw, sh, dx, dy, dw, dh, mode);
  }

  static public void blend(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
    sharedApplet.blend(src, sx, sy, sw, sh, dx, dy, dw, dh, mode);
  }

  static public void blendMode(int mode) {
    sharedApplet.blendMode(mode);
  }

  static public final float blue(int rgb) {
    return sharedApplet.blue(rgb);
  }

  static public void box(float size) {
    sharedApplet.box(size);
  }

  static public void box(float w, float h, float d) {
    sharedApplet.box(w, h, d);
  }

  static public final float brightness(int rgb) {
    return sharedApplet.brightness(rgb);
  }

  static public void camera() {
    sharedApplet.camera();
  }

  static public void camera(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX,
      float upY, float upZ) {
    sharedApplet.camera(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
  }

  static public void circle(float x, float y, float extent) {
    sharedApplet.circle(x, y, extent);
  }

  static public void clear() {
    sharedApplet.clear();
  }

  static public void clip(float a, float b, float c, float d) {
    sharedApplet.clip(a, b, c, d);
  }

  static public final int color(int gray) {
    return sharedApplet.color(gray);
  }

  static public final int color(float fgray) {
    return sharedApplet.color(fgray);
  }

  static public final int color(int gray, int alpha) {
    return sharedApplet.color(gray, alpha);
  }

  static public final int color(float fgray, float falpha) {
    return sharedApplet.color(fgray, falpha);
  }

  static public final int color(int v1, int v2, int v3) {
    return sharedApplet.color(v1, v2, v3);
  }

  static public final int color(float v1, float v2, float v3) {
    return sharedApplet.color(v1, v2, v3);
  }

  static public final int color(int v1, int v2, int v3, int alpha) {
    return sharedApplet.color(v1, v2, v3, alpha);
  }

  static public final int color(float v1, float v2, float v3, float alpha) {
    return sharedApplet.color(v1, v2, v3, alpha);
  }

  static public void colorMode(int mode) {
    sharedApplet.colorMode(mode);
  }

  static public void colorMode(int mode, float max) {
    sharedApplet.colorMode(mode, max);
  }

  static public void colorMode(int mode, float max1, float max2, float max3) {
    sharedApplet.colorMode(mode, max1, max2, max3);
  }

  static public void colorMode(int mode, float max1, float max2, float max3, float maxA) {
    sharedApplet.colorMode(mode, max1, max2, max3, maxA);
  }

  static public PImage copy() {
    return sharedApplet.copy();
  }

  static public void copy(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
    sharedApplet.copy(sx, sy, sw, sh, dx, dy, dw, dh);
  }

  static public void copy(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
    sharedApplet.copy(src, sx, sy, sw, sh, dx, dy, dw, dh);
  }

  static public PFont createFont(String name, float size) {
    return sharedApplet.createFont(name, size);
  }

  static public PFont createFont(String name, float size, boolean smooth) {
    return sharedApplet.createFont(name, size, smooth);
  }

  static public PFont createFont(String name, float size, boolean smooth, char[] charset) {
    return sharedApplet.createFont(name, size, smooth, charset);
  }

  static public PGraphics createGraphics(int w, int h) {
    return sharedApplet.createGraphics(w, h);
  }

  static public PGraphics createGraphics(int w, int h, String renderer) {
    return sharedApplet.createGraphics(w, h, renderer);
  }

  static public PGraphics createGraphics(int w, int h, String renderer, String path) {
    return sharedApplet.createGraphics(w, h, renderer, path);
  }

  static public PImage createImage(int w, int h, int format) {
    return sharedApplet.createImage(w, h, format);
  }

  static public InputStream createInput(String filename) {
    return sharedApplet.createInput(filename);
  }

  static public InputStream createInputRaw(String filename) {
    return sharedApplet.createInputRaw(filename);
  }

  static public OutputStream createOutput(String filename) {
    return sharedApplet.createOutput(filename);
  }

  static public BufferedReader createReader(String filename) {
    return sharedApplet.createReader(filename);
  }

  static public PShape createShape() {
    return sharedApplet.createShape();
  }

  static public PShape createShape(int type) {
    return sharedApplet.createShape(type);
  }

  static public PShape createShape(int kind, float... p) {
    return sharedApplet.createShape(kind, p);
  }

  static public PrintWriter createWriter(String filename) {
    return sharedApplet.createWriter(filename);
  }

  static public void cursor() {
    sharedApplet.cursor();
  }

  static public void cursor(int kind) {
    sharedApplet.cursor(kind);
  }

  static public void cursor(PImage img) {
    sharedApplet.cursor(img);
  }

  static public void cursor(PImage img, int x, int y) {
    sharedApplet.cursor(img, x, y);
  }

  static public void curve(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.curve(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  static public void curve(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
      float x4, float y4, float z4) {
    sharedApplet.curve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  static public void curveDetail(int detail) {
    sharedApplet.curveDetail(detail);
  }

  static public float curvePoint(float a, float b, float c, float d, float t) {
    return sharedApplet.curvePoint(a, b, c, d, t);
  }

  static public float curveTangent(float a, float b, float c, float d, float t) {
    return sharedApplet.curveTangent(a, b, c, d, t);
  }

  static public void curveTightness(float tightness) {
    sharedApplet.curveTightness(tightness);
  }

  static public void curveVertex(float x, float y) {
    sharedApplet.curveVertex(x, y);
  }

  static public void curveVertex(float x, float y, float z) {
    sharedApplet.curveVertex(x, y, z);
  }

  static public File dataFile(String where) {
    return sharedApplet.dataFile(where);
  }

  static public String dataPath(String where) {
    return sharedApplet.dataPath(where);
  }

  static public void delay(int napTime) {
    sharedApplet.delay(napTime);
  }

  static public void die(String what) {
    sharedApplet.die(what);
  }

  static public void die(String what, Exception e) {
    sharedApplet.die(what, e);
  }

  static public void directionalLight(float v1, float v2, float v3, float nx, float ny, float nz) {
    sharedApplet.directionalLight(v1, v2, v3, nx, ny, nz);
  }

  static public int displayDensity() {
    return sharedApplet.displayDensity();
  }

  static public int displayDensity(int display) {
    return sharedApplet.displayDensity(display);
  }

  static public void dispose() {
    sharedApplet.dispose();
  }

  static public void draw() {
    sharedApplet.draw();
  }

  static public void edge(boolean edge) {
    sharedApplet.edge(edge);
  }

  static public void ellipse(float a, float b, float c, float d) {
    sharedApplet.ellipse(a, b, c, d);
  }

  static public void ellipseMode(int mode) {
    sharedApplet.ellipseMode(mode);
  }

  static public void emissive(int rgb) {
    sharedApplet.emissive(rgb);
  }

  static public void emissive(float gray) {
    sharedApplet.emissive(gray);
  }

  static public void emissive(float v1, float v2, float v3) {
    sharedApplet.emissive(v1, v2, v3);
  }

  static public void endCamera() {
    sharedApplet.endCamera();
  }

  static public void endContour() {
    sharedApplet.endContour();
  }

  static public void endPGL() {
    sharedApplet.endPGL();
  }

  static public void endRaw() {
    sharedApplet.endRaw();
  }

  static public void endRecord() {
    sharedApplet.endRecord();
  }

  static public void endShape() {
    sharedApplet.endShape();
  }

  static public void endShape(int mode) {
    sharedApplet.endShape(mode);
  }

  static public void exit() {
    sharedApplet.exit();
  }

  static public void exitActual() {
    sharedApplet.exitActual();
  }

  static public boolean exitCalled() {
    return sharedApplet.exitCalled();
  }

  static public void fill(int rgb) {
    sharedApplet.fill(rgb);
  }

  static public void fill(float gray) {
    sharedApplet.fill(gray);
  }

  static public void fill(int rgb, float alpha) {
    sharedApplet.fill(rgb, alpha);
  }

  static public void fill(float gray, float alpha) {
    sharedApplet.fill(gray, alpha);
  }

  static public void fill(float v1, float v2, float v3) {
    sharedApplet.fill(v1, v2, v3);
  }

  static public void fill(float v1, float v2, float v3, float alpha) {
    sharedApplet.fill(v1, v2, v3, alpha);
  }

  static public void filter(PShader shader) {
    sharedApplet.filter(shader);
  }

  static public void filter(int kind) {
    sharedApplet.filter(kind);
  }

  static public void filter(int kind, float param) {
    sharedApplet.filter(kind, param);
  }

  static public void flush() {
    sharedApplet.flush();
  }

  static public void focusGained() {
    sharedApplet.focusGained();
  }

  static public void focusLost() {
    sharedApplet.focusLost();
  }

  static public void frameMoved(int x, int y) {
    sharedApplet.frameMoved(x, y);
  }

  static public void frameRate(float fps) {
    sharedApplet.frameRate(fps);
  }

  static public void frameResized(int w, int h) {
    sharedApplet.frameResized(w, h);
  }

  static public void frustum(float left, float right, float bottom, float top, float near, float far) {
    sharedApplet.frustum(left, right, bottom, top, near, far);
  }

  static public void fullScreen() {
    sharedApplet.fullScreen();
  }

  static public void fullScreen(int display) {
    sharedApplet.fullScreen(display);
  }

  static public void fullScreen(String renderer) {
    sharedApplet.fullScreen(renderer);
  }

  static public void fullScreen(String renderer, int display) {
    sharedApplet.fullScreen(renderer, display);
  }

  static public PImage get() {
    return sharedApplet.get();
  }

  static public int get(int x, int y) {
    return sharedApplet.get(x, y);
  }

  static public PImage get(int x, int y, int w, int h) {
    return sharedApplet.get(x, y, w, h);
  }

  static public PGraphics getGraphics() {
    return sharedApplet.getGraphics();
  }

  static public PMatrix getMatrix() {
    return sharedApplet.getMatrix();
  }

  static public PMatrix2D getMatrix(PMatrix2D target) {
    return sharedApplet.getMatrix(target);
  }

  static public PMatrix3D getMatrix(PMatrix3D target) {
    return sharedApplet.getMatrix(target);
  }

  static public PSurface getSurface() {
    return sharedApplet.getSurface();
  }

  static public final float green(int rgb) {
    return sharedApplet.green(rgb);
  }

  static public void handleDraw() {
    sharedApplet.handleDraw();
  }

  static public void hint(int which) {
    sharedApplet.hint(which);
  }

  static public final float hue(int rgb) {
    return sharedApplet.hue(rgb);
  }

  static public void image(PImage img, float a, float b) {
    sharedApplet.image(img, a, b);
  }

  static public void image(PImage img, float a, float b, float c, float d) {
    sharedApplet.image(img, a, b, c, d);
  }

  static public void image(PImage img, float a, float b, float c, float d, int u1, int v1, int u2, int v2) {
    sharedApplet.image(img, a, b, c, d, u1, v1, u2, v2);
  }

  static public void imageMode(int mode) {
    sharedApplet.imageMode(mode);
  }

  static public String insertFrame(String what) {
    return sharedApplet.insertFrame(what);
  }

  static public boolean isLooping() {
    return sharedApplet.isLooping();
  }

  static public String join(String[] list, char separator) {
    return SharedPApplet.join(list, separator);
  }

  static public String join(String[] list, String separator) {
    return SharedPApplet.join(list, separator);
  }

  static public void keyPressed() {
    sharedApplet.keyPressed();
  }

  static public void keyPressed(KeyEvent event) {
    sharedApplet.keyPressed(event);
  }

  static public void keyReleased() {
    sharedApplet.keyReleased();
  }

  static public void keyReleased(KeyEvent event) {
    sharedApplet.keyReleased(event);
  }

  static public void keyTyped() {
    sharedApplet.keyTyped();
  }

  static public void keyTyped(KeyEvent event) {
    sharedApplet.keyTyped(event);
  }

  static public int lerpColor(int c1, int c2, float amt) {
    return sharedApplet.lerpColor(c1, c2, amt);
  }

  static public void lightFalloff(float constant, float linear, float quadratic) {
    sharedApplet.lightFalloff(constant, linear, quadratic);
  }

  static public void lightSpecular(float v1, float v2, float v3) {
    sharedApplet.lightSpecular(v1, v2, v3);
  }

  static public void lights() {
    sharedApplet.lights();
  }

  static public void line(float x1, float y1, float x2, float y2) {
    sharedApplet.line(x1, y1, x2, y2);
  }

  static public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
    sharedApplet.line(x1, y1, z1, x2, y2, z2);
  }

  static public void link(String url) {
    sharedApplet.link(url);
  }

  static public File[] listFiles(String path, String... options) {
    return sharedApplet.listFiles(path, options);
  }

  static public String[] listPaths(String path, String... options) {
    return sharedApplet.listPaths(path, options);
  }

  static public byte[] loadBytes(String filename) {
    return sharedApplet.loadBytes(filename);
  }

  static public PFont loadFont(String filename) {
    return sharedApplet.loadFont(filename);
  }

  static public PImage loadImage(String filename) {
    return sharedApplet.loadImage(filename);
  }

  static public PImage loadImage(String filename, String extension) {
    return sharedApplet.loadImage(filename, extension);
  }

  static public JSONArray loadJSONArray(String filename) {
    return sharedApplet.loadJSONArray(filename);
  }

  static public JSONObject loadJSONObject(String filename) {
    return sharedApplet.loadJSONObject(filename);
  }

  static public void loadPixels() {
    sharedApplet.loadPixels();
  }

  static public PShader loadShader(String fragFilename) {
    return sharedApplet.loadShader(fragFilename);
  }

  static public PShader loadShader(String fragFilename, String vertFilename) {
    return sharedApplet.loadShader(fragFilename, vertFilename);
  }

  static public PShape loadShape(String filename) {
    return sharedApplet.loadShape(filename);
  }

  static public PShape loadShape(String filename, String options) {
    return sharedApplet.loadShape(filename, options);
  }

  static public String[] loadStrings(String filename) {
    return sharedApplet.loadStrings(filename);
  }

  static public Table loadTable(String filename) {
    return sharedApplet.loadTable(filename);
  }

  static public Table loadTable(String filename, String options) {
    return sharedApplet.loadTable(filename, options);
  }

  static public XML loadXML(String filename) {
    return sharedApplet.loadXML(filename);
  }

  static public XML loadXML(String filename, String options) {
    return sharedApplet.loadXML(filename, options);
  }

  static public void loop() {
    sharedApplet.loop();
  }

  static public void mask(PImage img) {
    sharedApplet.mask(img);
  }

  static public void method(String name) {
    sharedApplet.method(name);
  }

  static public int millis() {
    return sharedApplet.millis();
  }

  static public float modelX(float x, float y, float z) {
    return sharedApplet.modelX(x, y, z);
  }

  static public float modelY(float x, float y, float z) {
    return sharedApplet.modelY(x, y, z);
  }

  static public float modelZ(float x, float y, float z) {
    return sharedApplet.modelZ(x, y, z);
  }

  static public void mouseClicked() {
    sharedApplet.mouseClicked();
  }

  static public void mouseClicked(MouseEvent event) {
    sharedApplet.mouseClicked(event);
  }

  static public void mouseDragged() {
    sharedApplet.mouseDragged();
  }

  static public void mouseDragged(MouseEvent event) {
    sharedApplet.mouseDragged(event);
  }

  static public void mouseEntered() {
    sharedApplet.mouseEntered();
  }

  static public void mouseEntered(MouseEvent event) {
    sharedApplet.mouseEntered(event);
  }

  static public void mouseExited() {
    sharedApplet.mouseExited();
  }

  static public void mouseExited(MouseEvent event) {
    sharedApplet.mouseExited(event);
  }

  static public void mouseMoved() {
    sharedApplet.mouseMoved();
  }

  static public void mouseMoved(MouseEvent event) {
    sharedApplet.mouseMoved(event);
  }

  static public void mousePressed() {
    sharedApplet.mousePressed();
  }

  static public void mousePressed(MouseEvent event) {
    sharedApplet.mousePressed(event);
  }

  static public void mouseReleased() {
    sharedApplet.mouseReleased();
  }

  static public void mouseReleased(MouseEvent event) {
    sharedApplet.mouseReleased(event);
  }

  static public void mouseWheel() {
    sharedApplet.mouseWheel();
  }

  static public void mouseWheel(MouseEvent event) {
    sharedApplet.mouseWheel(event);
  }

  static public void noClip() {
    sharedApplet.noClip();
  }

  static public void noCursor() {
    sharedApplet.noCursor();
  }

  static public void noFill() {
    sharedApplet.noFill();
  }

  static public void noLights() {
    sharedApplet.noLights();
  }

  static public void noLoop() {
    sharedApplet.noLoop();
  }

  static public void noSmooth() {
    sharedApplet.noSmooth();
  }

  static public void noStroke() {
    sharedApplet.noStroke();
  }

  static public void noTexture() {
    sharedApplet.noTexture();
  }

  static public void noTint() {
    sharedApplet.noTint();
  }

  static public float noise(float x) {
    return sharedApplet.noise(x);
  }

  static public float noise(float x, float y) {
    return sharedApplet.noise(x, y);
  }

  static public float noise(float x, float y, float z) {
    return sharedApplet.noise(x, y, z);
  }

  static public void noiseDetail(int lod) {
    sharedApplet.noiseDetail(lod);
  }

  static public void noiseDetail(int lod, float falloff) {
    sharedApplet.noiseDetail(lod, falloff);
  }

  static public void noiseSeed(long seed) {
    sharedApplet.noiseSeed(seed);
  }

  static public void normal(float nx, float ny, float nz) {
    sharedApplet.normal(nx, ny, nz);
  }

  static public void orientation(int which) {
    sharedApplet.orientation(which);
  }

  static public void ortho() {
    sharedApplet.ortho();
  }

  static public void ortho(float left, float right, float bottom, float top) {
    sharedApplet.ortho(left, right, bottom, top);
  }

  static public void ortho(float left, float right, float bottom, float top, float near, float far) {
    sharedApplet.ortho(left, right, bottom, top, near, far);
  }

  static public JSONArray parseJSONArray(String input) {
    return sharedApplet.parseJSONArray(input);
  }

  static public JSONObject parseJSONObject(String input) {
    return sharedApplet.parseJSONObject(input);
  }

  static public XML parseXML(String xmlString) {
    return sharedApplet.parseXML(xmlString);
  }

  static public XML parseXML(String xmlString, String options) {
    return sharedApplet.parseXML(xmlString, options);
  }

  static public void pause() {
    sharedApplet.pause();
  }

  static public void perspective() {
    sharedApplet.perspective();
  }

  static public void perspective(float fovy, float aspect, float zNear, float zFar) {
    sharedApplet.perspective(fovy, aspect, zNear, zFar);
  }

  static public void pixelDensity(int density) {
    sharedApplet.pixelDensity(density);
  }

  static public void point(float x, float y) {
    sharedApplet.point(x, y);
  }

  static public void point(float x, float y, float z) {
    sharedApplet.point(x, y, z);
  }

  static public void pointLight(float v1, float v2, float v3, float x, float y, float z) {
    sharedApplet.pointLight(v1, v2, v3, x, y, z);
  }

  static public void pop() {
    sharedApplet.pop();
  }

  static public void popMatrix() {
    sharedApplet.popMatrix();
  }

  static public void popStyle() {
    sharedApplet.popStyle();
  }

  static public void postEvent(Event pe) {
    sharedApplet.postEvent(pe);
  }

  static public void printCamera() {
    sharedApplet.printCamera();
  }

  static public void printMatrix() {
    sharedApplet.printMatrix();
  }

  static public void printProjection() {
    sharedApplet.printProjection();
  }

  static public void push() {
    sharedApplet.push();
  }

  static public void pushMatrix() {
    sharedApplet.pushMatrix();
  }

  static public void pushStyle() {
    sharedApplet.pushStyle();
  }

  static public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.quad(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  static public void quadraticVertex(float cx, float cy, float x3, float y3) {
    sharedApplet.quadraticVertex(cx, cy, x3, y3);
  }

  static public void quadraticVertex(float cx, float cy, float cz, float x3, float y3, float z3) {
    sharedApplet.quadraticVertex(cx, cy, cz, x3, y3, z3);
  }

  static public final float random(float high) {
    return sharedApplet.random(high);
  }

  static public final float random(float low, float high) {
    return sharedApplet.random(low, high);
  }

  static public final float randomGaussian() {
    return sharedApplet.randomGaussian();
  }

  static public final void randomSeed(long seed) {
    sharedApplet.randomSeed(seed);
  }

  static public void rect(float a, float b, float c, float d, float r) {
    sharedApplet.rect(a, b, c, d, r);
  }

  static public void rect(float a, float b, float c, float d, float tl, float tr, float br, float bl) {
    sharedApplet.rect(a, b, c, d, tl, tr, br, bl);
  }

  static public void rectMode(int mode) {
    sharedApplet.rectMode(mode);
  }

  static public final float red(int rgb) {
    return sharedApplet.red(rgb);
  }

  static public void redraw() {
    sharedApplet.redraw();
  }

  static public void registerMethod(String methodName, Object target) {
    sharedApplet.registerMethod(methodName, target);
  }

  static public PImage requestImage(String filename) {
    return sharedApplet.requestImage(filename);
  }

  static public PImage requestImage(String filename, String extension) {
    return sharedApplet.requestImage(filename, extension);
  }

  static public void resetMatrix() {
    sharedApplet.resetMatrix();
  }

  static public void resetShader() {
    sharedApplet.resetShader();
  }

  static public void resetShader(int kind) {
    sharedApplet.resetShader(kind);
  }

  static public void resume() {
    sharedApplet.resume();
  }

  static public void rotate(float angle) {
    sharedApplet.rotate(angle);
  }

  static public void rotate(float angle, float x, float y, float z) {
    sharedApplet.rotate(angle, x, y, z);
  }

  static public void rotateX(float angle) {
    sharedApplet.rotateX(angle);
  }

  static public void rotateY(float angle) {
    sharedApplet.rotateY(angle);
  }

  static public void rotateZ(float angle) {
    sharedApplet.rotateZ(angle);
  }

  static public final float saturation(int rgb) {
    return sharedApplet.saturation(rgb);
  }

  static public void save(String filename) {
    sharedApplet.save(filename);
  }

  static public void saveBytes(String filename, byte[] data) {
    sharedApplet.saveBytes(filename, data);
  }

  static public File saveFile(String where) {
    return sharedApplet.saveFile(where);
  }

  static public void saveFrame() {
    sharedApplet.saveFrame();
  }

  static public void saveFrame(String filename) {
    sharedApplet.saveFrame(filename);
  }

  static public boolean saveJSONArray(JSONArray json, String filename) {
    return sharedApplet.saveJSONArray(json, filename);
  }

  static public boolean saveJSONArray(JSONArray json, String filename, String options) {
    return sharedApplet.saveJSONArray(json, filename, options);
  }

  static public boolean saveJSONObject(JSONObject json, String filename) {
    return sharedApplet.saveJSONObject(json, filename);
  }

  static public boolean saveJSONObject(JSONObject json, String filename, String options) {
    return sharedApplet.saveJSONObject(json, filename, options);
  }

  static public String savePath(String where) {
    return sharedApplet.savePath(where);
  }

  static public boolean saveStream(String target, String source) {
    return sharedApplet.saveStream(target, source);
  }

  static public boolean saveStream(File target, String source) {
    return sharedApplet.saveStream(target, source);
  }

  static public boolean saveStream(String target, InputStream source) {
    return sharedApplet.saveStream(target, source);
  }

  static public void saveStrings(String filename, String[] data) {
    sharedApplet.saveStrings(filename, data);
  }

  static public boolean saveTable(Table table, String filename) {
    return sharedApplet.saveTable(table, filename);
  }

  static public boolean saveTable(Table table, String filename, String options) {
    return sharedApplet.saveTable(table, filename, options);
  }

  static public boolean saveXML(XML xml, String filename) {
    return sharedApplet.saveXML(xml, filename);
  }

  static public boolean saveXML(XML xml, String filename, String options) {
    return sharedApplet.saveXML(xml, filename, options);
  }

  static public void scale(float s) {
    sharedApplet.scale(s);
  }

  static public void scale(float x, float y) {
    sharedApplet.scale(x, y);
  }

  static public void scale(float x, float y, float z) {
    sharedApplet.scale(x, y, z);
  }

  static public float screenX(float x, float y) {
    return sharedApplet.screenX(x, y);
  }

  static public float screenX(float x, float y, float z) {
    return sharedApplet.screenX(x, y, z);
  }

  static public float screenY(float x, float y) {
    return sharedApplet.screenY(x, y);
  }

  static public float screenY(float x, float y, float z) {
    return sharedApplet.screenY(x, y, z);
  }

  static public float screenZ(float x, float y, float z) {
    return sharedApplet.screenZ(x, y, z);
  }

  static public void selectFolder(String prompt, String callback) {
    sharedApplet.selectFolder(prompt, callback);
  }

  static public void selectFolder(String prompt, String callback, File file) {
    sharedApplet.selectFolder(prompt, callback, file);
  }

  static public void selectFolder(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectFolder(prompt, callback, file, callbackObject);
  }

  static public void selectInput(String prompt, String callback) {
    sharedApplet.selectInput(prompt, callback);
  }

  static public void selectInput(String prompt, String callback, File file) {
    sharedApplet.selectInput(prompt, callback, file);
  }

  static public void selectInput(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectInput(prompt, callback, file, callbackObject);
  }

  static public void selectOutput(String prompt, String callback) {
    sharedApplet.selectOutput(prompt, callback);
  }

  static public void selectOutput(String prompt, String callback, File file) {
    sharedApplet.selectOutput(prompt, callback, file);
  }

  static public void selectOutput(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectOutput(prompt, callback, file, callbackObject);
  }

  static public void set(int x, int y, int c) {
    sharedApplet.set(x, y, c);
  }

  static public void set(int x, int y, PImage img) {
    sharedApplet.set(x, y, img);
  }

  static public void setMatrix(PMatrix source) {
    sharedApplet.setMatrix(source);
  }

  static public void setMatrix(PMatrix2D source) {
    sharedApplet.setMatrix(source);
  }

  static public void setMatrix(PMatrix3D source) {
    sharedApplet.setMatrix(source);
  }

  static public void setSize(int width, int height) {
    sharedApplet.setSize(width, height);
  }

  static public void settings() {
    sharedApplet.settings();
  }

  static public void setup() {
    sharedApplet.setup();
  }

  static public void shader(PShader shader) {
    sharedApplet.shader(shader);
  }

  static public void shader(PShader shader, int kind) {
    sharedApplet.shader(shader, kind);
  }

  static public void shape(PShape shape) {
    sharedApplet.shape(shape);
  }

  static public void shape(PShape shape, float x, float y) {
    sharedApplet.shape(shape, x, y);
  }

  static public void shape(PShape shape, float a, float b, float c, float d) {
    sharedApplet.shape(shape, a, b, c, d);
  }

  static public void shapeMode(int mode) {
    sharedApplet.shapeMode(mode);
  }

  static public void shearX(float angle) {
    sharedApplet.shearX(angle);
  }

  static public void shearY(float angle) {
    sharedApplet.shearY(angle);
  }

  static public void shininess(float shine) {
    sharedApplet.shininess(shine);
  }

  static public void size(int width, int height) {
    sharedApplet.size(width, height);
  }

  static public void size(int width, int height, String renderer) {
    sharedApplet.size(width, height, renderer);
  }

  static public void size(int width, int height, String renderer, String path) {
    sharedApplet.size(width, height, renderer, path);
  }

  static public final int sketchDisplay() {
    return sharedApplet.sketchDisplay();
  }

  static public File sketchFile(String where) {
    return sharedApplet.sketchFile(where);
  }

  static public final boolean sketchFullScreen() {
    return sharedApplet.sketchFullScreen();
  }

  static public final int sketchHeight() {
    return sharedApplet.sketchHeight();
  }

  static public final String sketchOutputPath() {
    return sharedApplet.sketchOutputPath();
  }

  static public final OutputStream sketchOutputStream() {
    return sharedApplet.sketchOutputStream();
  }

  static public String sketchPath() {
    return sharedApplet.sketchPath();
  }

  static public String sketchPath(String where) {
    return sharedApplet.sketchPath(where);
  }

  static public final int sketchPixelDensity() {
    return sharedApplet.sketchPixelDensity();
  }

  static public final String sketchRenderer() {
    return sharedApplet.sketchRenderer();
  }

  static public final int sketchSmooth() {
    return sharedApplet.sketchSmooth();
  }

  static public final int sketchWidth() {
    return sharedApplet.sketchWidth();
  }

  static public final int sketchWindowColor() {
    return sharedApplet.sketchWindowColor();
  }

  static public void smooth() {
    sharedApplet.smooth();
  }

  static public void smooth(int level) {
    sharedApplet.smooth(level);
  }

  static public void specular(int rgb) {
    sharedApplet.specular(rgb);
  }

  static public void specular(float gray) {
    sharedApplet.specular(gray);
  }

  static public void specular(float v1, float v2, float v3) {
    sharedApplet.specular(v1, v2, v3);
  }

  static public void sphere(float r) {
    sharedApplet.sphere(r);
  }

  static public void sphereDetail(int res) {
    sharedApplet.sphereDetail(res);
  }

  static public void sphereDetail(int ures, int vres) {
    sharedApplet.sphereDetail(ures, vres);
  }

  static public void spotLight(float v1, float v2, float v3, float x, float y, float z, float nx, float ny, float nz,
      float angle, float concentration) {
    sharedApplet.spotLight(v1, v2, v3, x, y, z, nx, ny, nz, angle, concentration);
  }

  static public void square(float x, float y, float extent) {
    sharedApplet.square(x, y, extent);
  }

  static public void start() {
    sharedApplet.start();
  }

  static public void stop() {
    sharedApplet.stop();
  }

  static public void stroke(int rgb) {
    sharedApplet.stroke(rgb);
  }

  static public void stroke(float gray) {
    sharedApplet.stroke(gray);
  }

  static public void stroke(int rgb, float alpha) {
    sharedApplet.stroke(rgb, alpha);
  }

  static public void stroke(float gray, float alpha) {
    sharedApplet.stroke(gray, alpha);
  }

  static public void stroke(float v1, float v2, float v3) {
    sharedApplet.stroke(v1, v2, v3);
  }

  static public void stroke(float v1, float v2, float v3, float alpha) {
    sharedApplet.stroke(v1, v2, v3, alpha);
  }

  static public void strokeCap(int cap) {
    sharedApplet.strokeCap(cap);
  }

  static public void strokeJoin(int join) {
    sharedApplet.strokeJoin(join);
  }

  static public void strokeWeight(float weight) {
    sharedApplet.strokeWeight(weight);
  }

  static public void style(PStyle s) {
    sharedApplet.style(s);
  }

  static public void text(char c, float x, float y) {
    sharedApplet.text(c, x, y);
  }

  static public void text(String str, float x, float y) {
    sharedApplet.text(str, x, y);
  }

  static public void text(int num, float x, float y) {
    sharedApplet.text(num, x, y);
  }

  static public void text(float num, float x, float y) {
    sharedApplet.text(num, x, y);
  }

  static public void text(char c, float x, float y, float z) {
    sharedApplet.text(c, x, y, z);
  }

  static public void text(String str, float x, float y, float z) {
    sharedApplet.text(str, x, y, z);
  }

  static public void text(int num, float x, float y, float z) {
    sharedApplet.text(num, x, y, z);
  }

  static public void text(float num, float x, float y, float z) {
    sharedApplet.text(num, x, y, z);
  }

  static public void text(char[] chars, int start, int stop, float x, float y) {
    sharedApplet.text(chars, start, stop, x, y);
  }

  static public void text(String str, float x1, float y1, float x2, float y2) {
    sharedApplet.text(str, x1, y1, x2, y2);
  }

  static public void text(char[] chars, int start, int stop, float x, float y, float z) {
    sharedApplet.text(chars, start, stop, x, y, z);
  }

  static public void textAlign(int alignX) {
    sharedApplet.textAlign(alignX);
  }

  static public void textAlign(int alignX, int alignY) {
    sharedApplet.textAlign(alignX, alignY);
  }

  static public float textAscent() {
    return sharedApplet.textAscent();
  }

  static public float textDescent() {
    return sharedApplet.textDescent();
  }

  static public void textFont(PFont which) {
    sharedApplet.textFont(which);
  }

  static public void textFont(PFont which, float size) {
    sharedApplet.textFont(which, size);
  }

  static public void textLeading(float leading) {
    sharedApplet.textLeading(leading);
  }

  static public void textMode(int mode) {
    sharedApplet.textMode(mode);
  }

  static public void textSize(float size) {
    sharedApplet.textSize(size);
  }

  static public float textWidth(char c) {
    return sharedApplet.textWidth(c);
  }

  static public float textWidth(String str) {
    return sharedApplet.textWidth(str);
  }

  static public float textWidth(char[] chars, int start, int length) {
    return sharedApplet.textWidth(chars, start, length);
  }

  static public void texture(PImage image) {
    sharedApplet.texture(image);
  }

  static public void textureMode(int mode) {
    sharedApplet.textureMode(mode);
  }

  static public void textureWrap(int wrap) {
    sharedApplet.textureWrap(wrap);
  }

  static public void thread(String name) {
    sharedApplet.thread(name);
  }

  static public void tint(int rgb) {
    sharedApplet.tint(rgb);
  }

  static public void tint(float gray) {
    sharedApplet.tint(gray);
  }

  static public void tint(int rgb, float alpha) {
    sharedApplet.tint(rgb, alpha);
  }

  static public void tint(float gray, float alpha) {
    sharedApplet.tint(gray, alpha);
  }

  static public void tint(float v1, float v2, float v3) {
    sharedApplet.tint(v1, v2, v3);
  }

  static public void tint(float v1, float v2, float v3, float alpha) {
    sharedApplet.tint(v1, v2, v3, alpha);
  }

  static public void translate(float x, float y) {
    sharedApplet.translate(x, y);
  }

  static public void translate(float x, float y, float z) {
    sharedApplet.translate(x, y, z);
  }

  static public void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
    sharedApplet.triangle(x1, y1, x2, y2, x3, y3);
  }

  static public void unregisterMethod(String name, Object target) {
    sharedApplet.unregisterMethod(name, target);
  }

  static public void updatePixels() {
    sharedApplet.updatePixels();
  }

  static public void updatePixels(int x1, int y1, int x2, int y2) {
    sharedApplet.updatePixels(x1, y1, x2, y2);
  }

  static public void vertex(float[] v) {
    sharedApplet.vertex(v);
  }

  static public void vertex(float x, float y) {
    sharedApplet.vertex(x, y);
  }

  static public void vertex(float x, float y, float z) {
    sharedApplet.vertex(x, y, z);
  }

  static public void vertex(float x, float y, float u, float v) {
    sharedApplet.vertex(x, y, u, v);
  }

  static public void vertex(float x, float y, float z, float u, float v) {
    sharedApplet.vertex(x, y, z, u, v);
  }

  public static PApplet getSharedApplet() {
    return sharedApplet;
  }

  public static void setSharedApplet(PApplet sharedApplet) {
    SharedPApplet.sharedApplet = sharedApplet;
    SharedPApplet.keyEvents = new Subject<KeyEventsHandler>(sharedApplet);
    SharedPApplet.mouseEvents = new Subject<MouseEventsHandler>(sharedApplet);
  }

  public Subscription<?> subscribe(KeyEventsHandler observer, SubscriptionManager manager) {
    return keyEvents.subscribe(observer, manager);
  }

  public Subscription<?> subscribe(MouseEventsHandler observer, SubscriptionManager manager) {
    return mouseEvents.subscribe(observer, manager);
  }
}