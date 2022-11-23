package nl.benmens.processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
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

public class PAppletProxy {
  private static PApplet sharedApplet;
  private static Subject<KeyEvent> keyEvents = PublishSubject.create();
  private static Subject<MouseEvent> mouseEvents = PublishSubject.create();
  private static Observable<KeyEvent> keyPressedEvents = keyEvents
      .filter(keyEvent -> keyEvent.getAction() == KeyEvent.PRESS);
  private static Observable<KeyEvent> keyReleasedEvents = keyEvents
      .filter(keyEvent -> keyEvent.getAction() == KeyEvent.RELEASE);
  private static Observable<KeyEvent> keyTypedEvents = keyEvents
      .filter(keyEvent -> keyEvent.getAction() == KeyEvent.TYPE);

  private PAppletProxy() {
  }

  public static PApplet getSharedApplet() {
    return sharedApplet;
  }

  public static void setSharedApplet(PApplet sharedApplet) {
    PAppletProxy.sharedApplet = sharedApplet;
  }

  public static Subject<KeyEvent> keyEvents() {
    return keyEvents;
  }

  public static Observable<KeyEvent> keyPressedEvents() {
    return keyPressedEvents;
  }

  public static Observable<KeyEvent> keyReleasedEvents() {
    return keyReleasedEvents;
  }

  public static Observable<KeyEvent> keyTypedEvents() {
    return keyTypedEvents;
  }

  public static Subject<MouseEvent> mouseEvents() {
    return mouseEvents;
  }

  // Proxy functions

  public static PSurface getSurface() {
    return sharedApplet.getSurface();
  }

  public static void settings() {
    sharedApplet.settings();
  }

  public static final int sketchWidth() {
    return sharedApplet.sketchWidth();
  }

  public static final int sketchHeight() {
    return sharedApplet.sketchHeight();
  }

  public static final String sketchRenderer() {
    return sharedApplet.sketchRenderer();
  }

  public static final int sketchSmooth() {
    return sharedApplet.sketchSmooth();
  }

  public static final boolean sketchFullScreen() {
    return sharedApplet.sketchFullScreen();
  }

  public static final int sketchDisplay() {
    return sharedApplet.sketchDisplay();
  }

  public static final String sketchOutputPath() {
    return sharedApplet.sketchOutputPath();
  }

  public static final OutputStream sketchOutputStream() {
    return sharedApplet.sketchOutputStream();
  }

  public static final int sketchWindowColor() {
    return sharedApplet.sketchWindowColor();
  }

  public static final int sketchPixelDensity() {
    return sharedApplet.sketchPixelDensity();
  }

  public static int displayDensity() {
    return sharedApplet.displayDensity();
  }

  public static int displayDensity(int display) {
    return sharedApplet.displayDensity(display);
  }

  public static void pixelDensity(int density) {
    sharedApplet.pixelDensity(density);
  }

  public static void setSize(int width, int height) {
    sharedApplet.setSize(width, height);
  }

  public static void smooth() {
    sharedApplet.smooth();
  }

  public static void smooth(int level) {
    sharedApplet.smooth(level);
  }

  public static void noSmooth() {
    sharedApplet.noSmooth();
  }

  public static PGraphics getGraphics() {
    return sharedApplet.getGraphics();
  }

  public static void orientation(int which) {
    sharedApplet.orientation(which);
  }

  public static void start() {
    sharedApplet.start();
  }

  public static void stop() {
    sharedApplet.stop();
  }

  public static void pause() {
    sharedApplet.pause();
  }

  public static void resume() {
    sharedApplet.resume();
  }

  public static void registerMethod(String methodName, Object target) {
    sharedApplet.registerMethod(methodName, target);
  }

  public static void unregisterMethod(String name, Object target) {
    sharedApplet.unregisterMethod(name, target);
  }

  public static void setup() {
    sharedApplet.setup();
  }

  public static void draw() {
    sharedApplet.draw();
  }

  public static void fullScreen() {
    sharedApplet.fullScreen();
  }

  public static void fullScreen(int display) {
    sharedApplet.fullScreen(display);
  }

  public static void fullScreen(String renderer) {
    sharedApplet.fullScreen(renderer);
  }

  public static void fullScreen(String renderer, int display) {
    sharedApplet.fullScreen(renderer, display);
  }

  public static void size(int width, int height) {
    sharedApplet.size(width, height);
  }

  public static void size(int width, int height, String renderer) {
    sharedApplet.size(width, height, renderer);
  }

  public static void size(int width, int height, String renderer, String path) {
    sharedApplet.size(width, height, renderer, path);
  }

  public static PGraphics createGraphics(int w, int h) {
    return sharedApplet.createGraphics(w, h);
  }

  public static PGraphics createGraphics(int w, int h, String renderer) {
    return sharedApplet.createGraphics(w, h, renderer);
  }

  public static PGraphics createGraphics(int w, int h, String renderer, String path) {
    return sharedApplet.createGraphics(w, h, renderer, path);
  }

  public static PImage createImage(int w, int h, int format) {
    return sharedApplet.createImage(w, h, format);
  }

  public static void handleDraw() {
    sharedApplet.handleDraw();
  }

  public static void redraw() {
    sharedApplet.redraw();
  }

  public static void loop() {
    sharedApplet.loop();
  }

  public static void noLoop() {
    sharedApplet.noLoop();
  }

  public static boolean isLooping() {
    return sharedApplet.isLooping();
  }

  public static void postEvent(Event pe) {
    sharedApplet.postEvent(pe);
  }

  public static void mousePressed() {
    sharedApplet.mousePressed();
  }

  public static void mousePressed(MouseEvent event) {
    sharedApplet.mousePressed(event);
  }

  public static void mouseReleased() {
    sharedApplet.mouseReleased();
  }

  public static void mouseReleased(MouseEvent event) {
    sharedApplet.mouseReleased(event);
  }

  public static void mouseClicked() {
    sharedApplet.mouseClicked();
  }

  public static void mouseClicked(MouseEvent event) {
    sharedApplet.mouseClicked(event);
  }

  public static void mouseDragged() {
    sharedApplet.mouseDragged();
  }

  public static void mouseDragged(MouseEvent event) {
    sharedApplet.mouseDragged(event);
  }

  public static void mouseMoved() {
    sharedApplet.mouseMoved();
  }

  public static void mouseMoved(MouseEvent event) {
    sharedApplet.mouseMoved(event);
  }

  public static void mouseEntered() {
    sharedApplet.mouseEntered();
  }

  public static void mouseEntered(MouseEvent event) {
    sharedApplet.mouseEntered(event);
  }

  public static void mouseExited() {
    sharedApplet.mouseExited();
  }

  public static void mouseExited(MouseEvent event) {
    sharedApplet.mouseExited(event);
  }

  public static void mouseWheel() {
    sharedApplet.mouseWheel();
  }

  public static void mouseWheel(MouseEvent event) {
    sharedApplet.mouseWheel(event);
  }

  public static void keyPressed() {
    sharedApplet.keyPressed();
  }

  public static void keyPressed(KeyEvent event) {
    sharedApplet.keyPressed(event);
  }

  public static void keyReleased() {
    sharedApplet.keyReleased();
  }

  public static void keyReleased(KeyEvent event) {
    sharedApplet.keyReleased(event);
  }

  public static void keyTyped() {
    sharedApplet.keyTyped();
  }

  public static void keyTyped(KeyEvent event) {
    sharedApplet.keyTyped(event);
  }

  public static void focusGained() {
    sharedApplet.focusGained();
  }

  public static void focusLost() {
    sharedApplet.focusLost();
  }

  public static int millis() {
    return sharedApplet.millis();
  }

  public static void delay(int napTime) {
    sharedApplet.delay(napTime);
  }

  public static void frameRate(float fps) {
    sharedApplet.frameRate(fps);
  }

  public static void link(String url) {
    sharedApplet.link(url);
  }

  public static void die(String what) {
    sharedApplet.die(what);
  }

  public static void die(String what, Exception e) {
    sharedApplet.die(what, e);
  }

  public static void exit() {
    sharedApplet.exit();
  }

  public static boolean exitCalled() {
    return sharedApplet.exitCalled();
  }

  public static void exitActual() {
    sharedApplet.exitActual();
  }

  public static void dispose() {
    sharedApplet.dispose();
  }

  public static void method(String name) {
    sharedApplet.method(name);
  }

  public static void thread(String name) {
    sharedApplet.thread(name);
  }

  public static void save(String filename) {
    sharedApplet.save(filename);
  }

  public static void saveFrame() {
    sharedApplet.saveFrame();
  }

  public static void saveFrame(String filename) {
    sharedApplet.saveFrame(filename);
  }

  public static String insertFrame(String what) {
    return sharedApplet.insertFrame(what);
  }

  public static void cursor(int kind) {
    sharedApplet.cursor(kind);
  }

  public static void cursor(PImage img) {
    sharedApplet.cursor(img);
  }

  public static void cursor(PImage img, int x, int y) {
    sharedApplet.cursor(img, x, y);
  }

  public static void cursor() {
    sharedApplet.cursor();
  }

  public static void noCursor() {
    sharedApplet.noCursor();
  }

  public static final float random(float high) {
    return sharedApplet.random(high);
  }

  public static final float randomGaussian() {
    return sharedApplet.randomGaussian();
  }

  public static final float random(float low, float high) {
    return sharedApplet.random(low, high);
  }

  public static final void randomSeed(long seed) {
    sharedApplet.randomSeed(seed);
  }

  public static float noise(float x) {
    return sharedApplet.noise(x);
  }

  public static float noise(float x, float y) {
    return sharedApplet.noise(x, y);
  }

  public static float noise(float x, float y, float z) {
    return sharedApplet.noise(x, y, z);
  }

  public static void noiseDetail(int lod) {
    sharedApplet.noiseDetail(lod);
  }

  public static void noiseDetail(int lod, float falloff) {
    sharedApplet.noiseDetail(lod, falloff);
  }

  public static void noiseSeed(long seed) {
    sharedApplet.noiseSeed(seed);
  }

  public static PImage loadImage(String filename) {
    return sharedApplet.loadImage(filename);
  }

  public static PImage loadImage(String filename, String extension) {
    return sharedApplet.loadImage(filename, extension);
  }

  public static PImage requestImage(String filename) {
    return sharedApplet.requestImage(filename);
  }

  public static PImage requestImage(String filename, String extension) {
    return sharedApplet.requestImage(filename, extension);
  }

  public static XML loadXML(String filename) {
    return sharedApplet.loadXML(filename);
  }

  public static XML loadXML(String filename, String options) {
    return sharedApplet.loadXML(filename, options);
  }

  public static XML parseXML(String xmlString) {
    return sharedApplet.parseXML(xmlString);
  }

  public static XML parseXML(String xmlString, String options) {
    return sharedApplet.parseXML(xmlString, options);
  }

  public static boolean saveXML(XML xml, String filename) {
    return sharedApplet.saveXML(xml, filename);
  }

  public static boolean saveXML(XML xml, String filename, String options) {
    return sharedApplet.saveXML(xml, filename, options);
  }

  public static JSONObject parseJSONObject(String input) {
    return sharedApplet.parseJSONObject(input);
  }

  public static JSONObject loadJSONObject(String filename) {
    return sharedApplet.loadJSONObject(filename);
  }

  public static boolean saveJSONObject(JSONObject json, String filename) {
    return sharedApplet.saveJSONObject(json, filename);
  }

  public static boolean saveJSONObject(JSONObject json, String filename, String options) {
    return sharedApplet.saveJSONObject(json, filename, options);
  }

  public static JSONArray parseJSONArray(String input) {
    return sharedApplet.parseJSONArray(input);
  }

  public static JSONArray loadJSONArray(String filename) {
    return sharedApplet.loadJSONArray(filename);
  }

  public static boolean saveJSONArray(JSONArray json, String filename) {
    return sharedApplet.saveJSONArray(json, filename);
  }

  public static boolean saveJSONArray(JSONArray json, String filename, String options) {
    return sharedApplet.saveJSONArray(json, filename, options);
  }

  public static Table loadTable(String filename) {
    return sharedApplet.loadTable(filename);
  }

  public static Table loadTable(String filename, String options) {
    return sharedApplet.loadTable(filename, options);
  }

  public static boolean saveTable(Table table, String filename) {
    return sharedApplet.saveTable(table, filename);
  }

  public static boolean saveTable(Table table, String filename, String options) {
    return sharedApplet.saveTable(table, filename, options);
  }

  public static PFont loadFont(String filename) {
    return sharedApplet.loadFont(filename);
  }

  public static PFont createFont(String name, float size) {
    return sharedApplet.createFont(name, size);
  }

  public static PFont createFont(String name, float size, boolean smooth) {
    return sharedApplet.createFont(name, size, smooth);
  }

  public static PFont createFont(String name, float size, boolean smooth, char[] charset) {
    return sharedApplet.createFont(name, size, smooth, charset);
  }

  public static void selectInput(String prompt, String callback) {
    sharedApplet.selectInput(prompt, callback);
  }

  public static void selectInput(String prompt, String callback, File file) {
    sharedApplet.selectInput(prompt, callback, file);
  }

  public static void selectInput(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectInput(prompt, callback, file, callbackObject);
  }

  public static void selectOutput(String prompt, String callback) {
    sharedApplet.selectOutput(prompt, callback);
  }

  public static void selectOutput(String prompt, String callback, File file) {
    sharedApplet.selectOutput(prompt, callback, file);
  }

  public static void selectOutput(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectOutput(prompt, callback, file, callbackObject);
  }

  public static void selectFolder(String prompt, String callback) {
    sharedApplet.selectFolder(prompt, callback);
  }

  public static void selectFolder(String prompt, String callback, File file) {
    sharedApplet.selectFolder(prompt, callback, file);
  }

  public static void selectFolder(String prompt, String callback, File file, Object callbackObject) {
    sharedApplet.selectFolder(prompt, callback, file, callbackObject);
  }

  public static String[] listPaths(String path, String... options) {
    return sharedApplet.listPaths(path, options);
  }

  public static File[] listFiles(String path, String... options) {
    return sharedApplet.listFiles(path, options);
  }

  public static BufferedReader createReader(String filename) {
    return sharedApplet.createReader(filename);
  }

  public static PrintWriter createWriter(String filename) {
    return sharedApplet.createWriter(filename);
  }

  public static InputStream createInput(String filename) {
    return sharedApplet.createInput(filename);
  }

  public static InputStream createInputRaw(String filename) {
    return sharedApplet.createInputRaw(filename);
  }

  public static byte[] loadBytes(String filename) {
    return sharedApplet.loadBytes(filename);
  }

  public static String[] loadStrings(String filename) {
    return sharedApplet.loadStrings(filename);
  }

  public static OutputStream createOutput(String filename) {
    return sharedApplet.createOutput(filename);
  }

  public static boolean saveStream(String target, String source) {
    return sharedApplet.saveStream(target, source);
  }

  public static boolean saveStream(File target, String source) {
    return sharedApplet.saveStream(target, source);
  }

  public static boolean saveStream(String target, InputStream source) {
    return sharedApplet.saveStream(target, source);
  }

  public static void saveBytes(String filename, byte[] data) {
    sharedApplet.saveBytes(filename, data);
  }

  public static void saveStrings(String filename, String[] data) {
    sharedApplet.saveStrings(filename, data);
  }

  public static String sketchPath() {
    return sharedApplet.sketchPath();
  }

  public static String sketchPath(String where) {
    return sharedApplet.sketchPath(where);
  }

  public static File sketchFile(String where) {
    return sharedApplet.sketchFile(where);
  }

  public static String savePath(String where) {
    return sharedApplet.savePath(where);
  }

  public static File saveFile(String where) {
    return sharedApplet.saveFile(where);
  }

  public static String dataPath(String where) {
    return sharedApplet.dataPath(where);
  }

  public static File dataFile(String where) {
    return sharedApplet.dataFile(where);
  }

  public static final int color(int gray) {
    return sharedApplet.color(gray);
  }

  public static final int color(float fgray) {
    return sharedApplet.color(fgray);
  }

  public static final int color(int gray, int alpha) {
    return sharedApplet.color(gray, alpha);
  }

  public static final int color(float fgray, float falpha) {
    return sharedApplet.color(fgray, falpha);
  }

  public static final int color(int v1, int v2, int v3) {
    return sharedApplet.color(v1, v2, v3);
  }

  public static final int color(int v1, int v2, int v3, int alpha) {
    return sharedApplet.color(v1, v2, v3, alpha);
  }

  public static final int color(float v1, float v2, float v3) {
    return sharedApplet.color(v1, v2, v3);
  }

  public static final int color(float v1, float v2, float v3, float alpha) {
    return sharedApplet.color(v1, v2, v3, alpha);
  }

  public static int lerpColor(int c1, int c2, float amt) {
    return sharedApplet.lerpColor(c1, c2, amt);
  }

  public static void windowTitle(String title) {
    sharedApplet.windowTitle(title);
  }

  public static void windowResize(int newWidth, int newHeight) {
    sharedApplet.windowResize(newWidth, newHeight);
  }

  public static void postWindowResized(int newWidth, int newHeight) {
    sharedApplet.postWindowResized(newWidth, newHeight);
  }

  public static void windowResized() {
    sharedApplet.windowResized();
  }

  public static void windowResizable(boolean resizable) {
    sharedApplet.windowResizable(resizable);
  }

  public static void windowMove(int x, int y) {
    sharedApplet.windowMove(x, y);
  }

  public static void frameMoved(int newX, int newY) {
    sharedApplet.frameMoved(newX, newY);
  }

  public static void postWindowMoved(int newX, int newY) {
    sharedApplet.postWindowMoved(newX, newY);
  }

  public static void windowMoved() {
    sharedApplet.windowMoved();
  }

  public static void windowRatio(int wide, int high) {
    sharedApplet.windowRatio(wide, high);
  }

  public static PGraphics beginRecord(String renderer, String filename) {
    return sharedApplet.beginRecord(renderer, filename);
  }

  public static void beginRecord(PGraphics recorder) {
    sharedApplet.beginRecord(recorder);
  }

  public static void endRecord() {
    sharedApplet.endRecord();
  }

  public static PGraphics beginRaw(String renderer, String filename) {
    return sharedApplet.beginRaw(renderer, filename);
  }

  public static void beginRaw(PGraphics rawGraphics) {
    sharedApplet.beginRaw(rawGraphics);
  }

  public static void endRaw() {
    sharedApplet.endRaw();
  }

  public static void loadPixels() {
    sharedApplet.loadPixels();
  }

  public static void updatePixels() {
    sharedApplet.updatePixels();
  }

  public static void updatePixels(int x1, int y1, int x2, int y2) {
    sharedApplet.updatePixels(x1, y1, x2, y2);
  }

  public static PGL beginPGL() {
    return sharedApplet.beginPGL();
  }

  public static void endPGL() {
    sharedApplet.endPGL();
  }

  public static void flush() {
    sharedApplet.flush();
  }

  public static void hint(int which) {
    sharedApplet.hint(which);
  }

  public static void beginShape() {
    sharedApplet.beginShape();
  }

  public static void beginShape(int kind) {
    sharedApplet.beginShape(kind);
  }

  public static void edge(boolean edge) {
    sharedApplet.edge(edge);
  }

  public static void normal(float nx, float ny, float nz) {
    sharedApplet.normal(nx, ny, nz);
  }

  public static void attribPosition(String name, float x, float y, float z) {
    sharedApplet.attribPosition(name, x, y, z);
  }

  public static void attribNormal(String name, float nx, float ny, float nz) {
    sharedApplet.attribNormal(name, nx, ny, nz);
  }

  public static void attribColor(String name, int color) {
    sharedApplet.attribColor(name, color);
  }

  public static void attrib(String name, float... values) {
    sharedApplet.attrib(name, values);
  }

  public static void attrib(String name, int... values) {
    sharedApplet.attrib(name, values);
  }

  public static void attrib(String name, boolean... values) {
    sharedApplet.attrib(name, values);
  }

  public static void textureMode(int mode) {
    sharedApplet.textureMode(mode);
  }

  public static void textureWrap(int wrap) {
    sharedApplet.textureWrap(wrap);
  }

  public static void texture(PImage image) {
    sharedApplet.texture(image);
  }

  public static void noTexture() {
    sharedApplet.noTexture();
  }

  public static void vertex(float x, float y) {
    sharedApplet.vertex(x, y);
  }

  public static void vertex(float x, float y, float z) {
    sharedApplet.vertex(x, y, z);
  }

  public static void vertex(float[] v) {
    sharedApplet.vertex(v);
  }

  public static void vertex(float x, float y, float u, float v) {
    sharedApplet.vertex(x, y, u, v);
  }

  public static void vertex(float x, float y, float z, float u, float v) {
    sharedApplet.vertex(x, y, z, u, v);
  }

  public static void beginContour() {
    sharedApplet.beginContour();
  }

  public static void endContour() {
    sharedApplet.endContour();
  }

  public static void endShape() {
    sharedApplet.endShape();
  }

  public static void endShape(int mode) {
    sharedApplet.endShape(mode);
  }

  public static PShape loadShape(String filename) {
    return sharedApplet.loadShape(filename);
  }

  public static PShape loadShape(String filename, String options) {
    return sharedApplet.loadShape(filename, options);
  }

  public static PShape createShape() {
    return sharedApplet.createShape();
  }

  public static PShape createShape(int type) {
    return sharedApplet.createShape(type);
  }

  public static PShape createShape(int kind, float... p) {
    return sharedApplet.createShape(kind, p);
  }

  public static PShader loadShader(String fragFilename) {
    return sharedApplet.loadShader(fragFilename);
  }

  public static PShader loadShader(String fragFilename, String vertFilename) {
    return sharedApplet.loadShader(fragFilename, vertFilename);
  }

  public static void shader(PShader shader) {
    sharedApplet.shader(shader);
  }

  public static void shader(PShader shader, int kind) {
    sharedApplet.shader(shader, kind);
  }

  public static void resetShader() {
    sharedApplet.resetShader();
  }

  public static void resetShader(int kind) {
    sharedApplet.resetShader(kind);
  }

  public static void filter(PShader shader) {
    sharedApplet.filter(shader);
  }

  public static void clip(float a, float b, float c, float d) {
    sharedApplet.clip(a, b, c, d);
  }

  public static void noClip() {
    sharedApplet.noClip();
  }

  public static void blendMode(int mode) {
    sharedApplet.blendMode(mode);
  }

  public static void bezierVertex(float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.bezierVertex(x2, y2, x3, y3, x4, y4);
  }

  public static void bezierVertex(float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4,
      float z4) {
    sharedApplet.bezierVertex(x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  public static void quadraticVertex(float cx, float cy, float x3, float y3) {
    sharedApplet.quadraticVertex(cx, cy, x3, y3);
  }

  public static void quadraticVertex(float cx, float cy, float cz, float x3, float y3, float z3) {
    sharedApplet.quadraticVertex(cx, cy, cz, x3, y3, z3);
  }

  public static void curveVertex(float x, float y) {
    sharedApplet.curveVertex(x, y);
  }

  public static void curveVertex(float x, float y, float z) {
    sharedApplet.curveVertex(x, y, z);
  }

  public static void point(float x, float y) {
    sharedApplet.point(x, y);
  }

  public static void point(float x, float y, float z) {
    sharedApplet.point(x, y, z);
  }

  public static void line(float x1, float y1, float x2, float y2) {
    sharedApplet.line(x1, y1, x2, y2);
  }

  public static void line(float x1, float y1, float z1, float x2, float y2, float z2) {
    sharedApplet.line(x1, y1, z1, x2, y2, z2);
  }

  public static void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
    sharedApplet.triangle(x1, y1, x2, y2, x3, y3);
  }

  public static void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.quad(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  public static void rectMode(int mode) {
    sharedApplet.rectMode(mode);
  }

  public static void rect(float a, float b, float c, float d) {
    sharedApplet.rect(a, b, c, d);
  }

  public static void rect(float a, float b, float c, float d, float r) {
    sharedApplet.rect(a, b, c, d, r);
  }

  public static void rect(float a, float b, float c, float d, float tl, float tr, float br, float bl) {
    sharedApplet.rect(a, b, c, d, tl, tr, br, bl);
  }

  public static void square(float x, float y, float extent) {
    sharedApplet.square(x, y, extent);
  }

  public static void ellipseMode(int mode) {
    sharedApplet.ellipseMode(mode);
  }

  public static void ellipse(float a, float b, float c, float d) {
    sharedApplet.ellipse(a, b, c, d);
  }

  public static void arc(float a, float b, float c, float d, float start, float stop) {
    sharedApplet.arc(a, b, c, d, start, stop);
  }

  public static void arc(float a, float b, float c, float d, float start, float stop, int mode) {
    sharedApplet.arc(a, b, c, d, start, stop, mode);
  }

  public static void circle(float x, float y, float extent) {
    sharedApplet.circle(x, y, extent);
  }

  public static void box(float size) {
    sharedApplet.box(size);
  }

  public static void box(float w, float h, float d) {
    sharedApplet.box(w, h, d);
  }

  public static void sphereDetail(int res) {
    sharedApplet.sphereDetail(res);
  }

  public static void sphereDetail(int ures, int vres) {
    sharedApplet.sphereDetail(ures, vres);
  }

  public static void sphere(float r) {
    sharedApplet.sphere(r);
  }

  public static float bezierPoint(float a, float b, float c, float d, float t) {
    return sharedApplet.bezierPoint(a, b, c, d, t);
  }

  public static float bezierTangent(float a, float b, float c, float d, float t) {
    return sharedApplet.bezierTangent(a, b, c, d, t);
  }

  public static void bezierDetail(int detail) {
    sharedApplet.bezierDetail(detail);
  }

  public static void bezier(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.bezier(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  public static void bezier(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
      float x4,
      float y4, float z4) {
    sharedApplet.bezier(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  public static float curvePoint(float a, float b, float c, float d, float t) {
    return sharedApplet.curvePoint(a, b, c, d, t);
  }

  public static float curveTangent(float a, float b, float c, float d, float t) {
    return sharedApplet.curveTangent(a, b, c, d, t);
  }

  public static void curveDetail(int detail) {
    sharedApplet.curveDetail(detail);
  }

  public static void curveTightness(float tightness) {
    sharedApplet.curveTightness(tightness);
  }

  public static void curve(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
    sharedApplet.curve(x1, y1, x2, y2, x3, y3, x4, y4);
  }

  public static void curve(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3,
      float x4,
      float y4, float z4) {
    sharedApplet.curve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
  }

  public static void imageMode(int mode) {
    sharedApplet.imageMode(mode);
  }

  public static void image(PImage img, float a, float b) {
    sharedApplet.image(img, a, b);
  }

  public static void image(PImage img, float a, float b, float c, float d) {
    sharedApplet.image(img, a, b, c, d);
  }

  public static void image(PImage img, float a, float b, float c, float d, int u1, int v1, int u2, int v2) {
    sharedApplet.image(img, a, b, c, d, u1, v1, u2, v2);
  }

  public static void shapeMode(int mode) {
    sharedApplet.shapeMode(mode);
  }

  public static void shape(PShape shape) {
    sharedApplet.shape(shape);
  }

  public static void shape(PShape shape, float x, float y) {
    sharedApplet.shape(shape, x, y);
  }

  public static void shape(PShape shape, float a, float b, float c, float d) {
    sharedApplet.shape(shape, a, b, c, d);
  }

  public static void textAlign(int alignX) {
    sharedApplet.textAlign(alignX);
  }

  public static void textAlign(int alignX, int alignY) {
    sharedApplet.textAlign(alignX, alignY);
  }

  public static float textAscent() {
    return sharedApplet.textAscent();
  }

  public static float textDescent() {
    return sharedApplet.textDescent();
  }

  public static void textFont(PFont which) {
    sharedApplet.textFont(which);
  }

  public static void textFont(PFont which, float size) {
    sharedApplet.textFont(which, size);
  }

  public static void textLeading(float leading) {
    sharedApplet.textLeading(leading);
  }

  public static void textMode(int mode) {
    sharedApplet.textMode(mode);
  }

  public static void textSize(float size) {
    sharedApplet.textSize(size);
  }

  public static float textWidth(char c) {
    return sharedApplet.textWidth(c);
  }

  public static float textWidth(String str) {
    return sharedApplet.textWidth(str);
  }

  public static float textWidth(char[] chars, int start, int length) {
    return sharedApplet.textWidth(chars, start, length);
  }

  public static void text(char c, float x, float y) {
    sharedApplet.text(c, x, y);
  }

  public static void text(char c, float x, float y, float z) {
    sharedApplet.text(c, x, y, z);
  }

  public static void text(String str, float x, float y) {
    sharedApplet.text(str, x, y);
  }

  public static void text(char[] chars, int start, int stop, float x, float y) {
    sharedApplet.text(chars, start, stop, x, y);
  }

  public static void text(String str, float x, float y, float z) {
    sharedApplet.text(str, x, y, z);
  }

  public static void text(char[] chars, int start, int stop, float x, float y, float z) {
    sharedApplet.text(chars, start, stop, x, y, z);
  }

  public static void text(String str, float x1, float y1, float x2, float y2) {
    sharedApplet.text(str, x1, y1, x2, y2);
  }

  public static void text(int num, float x, float y) {
    sharedApplet.text(num, x, y);
  }

  public static void text(int num, float x, float y, float z) {
    sharedApplet.text(num, x, y, z);
  }

  public static void text(float num, float x, float y) {
    sharedApplet.text(num, x, y);
  }

  public static void text(float num, float x, float y, float z) {
    sharedApplet.text(num, x, y, z);
  }

  public static void push() {
    sharedApplet.push();
  }

  public static void pop() {
    sharedApplet.pop();
  }

  public static void pushMatrix() {
    sharedApplet.pushMatrix();
  }

  public static void popMatrix() {
    sharedApplet.popMatrix();
  }

  public static void translate(float x, float y) {
    sharedApplet.translate(x, y);
  }

  public static void translate(float x, float y, float z) {
    sharedApplet.translate(x, y, z);
  }

  public static void rotate(float angle) {
    sharedApplet.rotate(angle);
  }

  public static void rotateX(float angle) {
    sharedApplet.rotateX(angle);
  }

  public static void rotateY(float angle) {
    sharedApplet.rotateY(angle);
  }

  public static void rotateZ(float angle) {
    sharedApplet.rotateZ(angle);
  }

  public static void rotate(float angle, float x, float y, float z) {
    sharedApplet.rotate(angle, x, y, z);
  }

  public static void scale(float s) {
    sharedApplet.scale(s);
  }

  public static void scale(float x, float y) {
    sharedApplet.scale(x, y);
  }

  public static void scale(float x, float y, float z) {
    sharedApplet.scale(x, y, z);
  }

  public static void shearX(float angle) {
    sharedApplet.shearX(angle);
  }

  public static void shearY(float angle) {
    sharedApplet.shearY(angle);
  }

  public static void resetMatrix() {
    sharedApplet.resetMatrix();
  }

  public static void applyMatrix(PMatrix source) {
    sharedApplet.applyMatrix(source);
  }

  public static void applyMatrix(PMatrix2D source) {
    sharedApplet.applyMatrix(source);
  }

  public static void applyMatrix(float n00, float n01, float n02, float n10, float n11, float n12) {
    sharedApplet.applyMatrix(n00, n01, n02, n10, n11, n12);
  }

  public static void applyMatrix(PMatrix3D source) {
    sharedApplet.applyMatrix(source);
  }

  public static void applyMatrix(float n00, float n01, float n02, float n03, float n10, float n11, float n12, float n13,
      float n20, float n21, float n22, float n23, float n30, float n31, float n32, float n33) {
    sharedApplet.applyMatrix(n00, n01, n02, n03, n10, n11, n12, n13, n20, n21, n22, n23, n30, n31, n32, n33);
  }

  public static PMatrix getMatrix() {
    return sharedApplet.getMatrix();
  }

  public static PMatrix2D getMatrix(PMatrix2D target) {
    return sharedApplet.getMatrix(target);
  }

  public static PMatrix3D getMatrix(PMatrix3D target) {
    return sharedApplet.getMatrix(target);
  }

  public static void setMatrix(PMatrix source) {
    sharedApplet.setMatrix(source);
  }

  public static void setMatrix(PMatrix2D source) {
    sharedApplet.setMatrix(source);
  }

  public static void setMatrix(PMatrix3D source) {
    sharedApplet.setMatrix(source);
  }

  public static void printMatrix() {
    sharedApplet.printMatrix();
  }

  public static void beginCamera() {
    sharedApplet.beginCamera();
  }

  public static void endCamera() {
    sharedApplet.endCamera();
  }

  public static void camera() {
    sharedApplet.camera();
  }

  public static void camera(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX,
      float upY, float upZ) {
    sharedApplet.camera(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
  }

  public static void printCamera() {
    sharedApplet.printCamera();
  }

  public static void ortho() {
    sharedApplet.ortho();
  }

  public static void ortho(float left, float right, float bottom, float top) {
    sharedApplet.ortho(left, right, bottom, top);
  }

  public static void ortho(float left, float right, float bottom, float top, float near, float far) {
    sharedApplet.ortho(left, right, bottom, top, near, far);
  }

  public static void perspective() {
    sharedApplet.perspective();
  }

  public static void perspective(float fovy, float aspect, float zNear, float zFar) {
    sharedApplet.perspective(fovy, aspect, zNear, zFar);
  }

  public static void frustum(float left, float right, float bottom, float top, float near, float far) {
    sharedApplet.frustum(left, right, bottom, top, near, far);
  }

  public static void printProjection() {
    sharedApplet.printProjection();
  }

  public static float screenX(float x, float y) {
    return sharedApplet.screenX(x, y);
  }

  public static float screenY(float x, float y) {
    return sharedApplet.screenY(x, y);
  }

  public static float screenX(float x, float y, float z) {
    return sharedApplet.screenX(x, y, z);
  }

  public static float screenY(float x, float y, float z) {
    return sharedApplet.screenY(x, y, z);
  }

  public static float screenZ(float x, float y, float z) {
    return sharedApplet.screenZ(x, y, z);
  }

  public static float modelX(float x, float y, float z) {
    return sharedApplet.modelX(x, y, z);
  }

  public static float modelY(float x, float y, float z) {
    return sharedApplet.modelY(x, y, z);
  }

  public static float modelZ(float x, float y, float z) {
    return sharedApplet.modelZ(x, y, z);
  }

  public static void pushStyle() {
    sharedApplet.pushStyle();
  }

  public static void popStyle() {
    sharedApplet.popStyle();
  }

  public static void style(PStyle s) {
    sharedApplet.style(s);
  }

  public static void strokeWeight(float weight) {
    sharedApplet.strokeWeight(weight);
  }

  public static void strokeJoin(int join) {
    sharedApplet.strokeJoin(join);
  }

  public static void strokeCap(int cap) {
    sharedApplet.strokeCap(cap);
  }

  public static void noStroke() {
    sharedApplet.noStroke();
  }

  public static void stroke(int rgb) {
    sharedApplet.stroke(rgb);
  }

  public static void stroke(int rgb, float alpha) {
    sharedApplet.stroke(rgb, alpha);
  }

  public static void stroke(float gray) {
    sharedApplet.stroke(gray);
  }

  public static void stroke(float gray, float alpha) {
    sharedApplet.stroke(gray, alpha);
  }

  public static void stroke(float v1, float v2, float v3) {
    sharedApplet.stroke(v1, v2, v3);
  }

  public static void stroke(float v1, float v2, float v3, float alpha) {
    sharedApplet.stroke(v1, v2, v3, alpha);
  }

  public static void noTint() {
    sharedApplet.noTint();
  }

  public static void tint(int rgb) {
    sharedApplet.tint(rgb);
  }

  public static void tint(int rgb, float alpha) {
    sharedApplet.tint(rgb, alpha);
  }

  public static void tint(float gray) {
    sharedApplet.tint(gray);
  }

  public static void tint(float gray, float alpha) {
    sharedApplet.tint(gray, alpha);
  }

  public static void tint(float v1, float v2, float v3) {
    sharedApplet.tint(v1, v2, v3);
  }

  public static void tint(float v1, float v2, float v3, float alpha) {
    sharedApplet.tint(v1, v2, v3, alpha);
  }

  public static void noFill() {
    sharedApplet.noFill();
  }

  public static void fill(int rgb) {
    sharedApplet.fill(rgb);
  }

  public static void fill(int rgb, float alpha) {
    sharedApplet.fill(rgb, alpha);
  }

  public static void fill(float gray) {
    sharedApplet.fill(gray);
  }

  public static void fill(float gray, float alpha) {
    sharedApplet.fill(gray, alpha);
  }

  public static void fill(float v1, float v2, float v3) {
    sharedApplet.fill(v1, v2, v3);
  }

  public static void fill(float v1, float v2, float v3, float alpha) {
    sharedApplet.fill(v1, v2, v3, alpha);
  }

  public static void ambient(int rgb) {
    sharedApplet.ambient(rgb);
  }

  public static void ambient(float gray) {
    sharedApplet.ambient(gray);
  }

  public static void ambient(float v1, float v2, float v3) {
    sharedApplet.ambient(v1, v2, v3);
  }

  public static void specular(int rgb) {
    sharedApplet.specular(rgb);
  }

  public static void specular(float gray) {
    sharedApplet.specular(gray);
  }

  public static void specular(float v1, float v2, float v3) {
    sharedApplet.specular(v1, v2, v3);
  }

  public static void shininess(float shine) {
    sharedApplet.shininess(shine);
  }

  public static void emissive(int rgb) {
    sharedApplet.emissive(rgb);
  }

  public static void emissive(float gray) {
    sharedApplet.emissive(gray);
  }

  public static void emissive(float v1, float v2, float v3) {
    sharedApplet.emissive(v1, v2, v3);
  }

  public static void lights() {
    sharedApplet.lights();
  }

  public static void noLights() {
    sharedApplet.noLights();
  }

  public static void ambientLight(float v1, float v2, float v3) {
    sharedApplet.ambientLight(v1, v2, v3);
  }

  public static void ambientLight(float v1, float v2, float v3, float x, float y, float z) {
    sharedApplet.ambientLight(v1, v2, v3, x, y, z);
  }

  public static void directionalLight(float v1, float v2, float v3, float nx, float ny, float nz) {
    sharedApplet.directionalLight(v1, v2, v3, nx, ny, nz);
  }

  public static void pointLight(float v1, float v2, float v3, float x, float y, float z) {
    sharedApplet.pointLight(v1, v2, v3, x, y, z);
  }

  public static void spotLight(float v1, float v2, float v3, float x, float y, float z, float nx, float ny, float nz,
      float angle, float concentration) {
    sharedApplet.spotLight(v1, v2, v3, x, y, z, nx, ny, nz, angle, concentration);
  }

  public static void lightFalloff(float constant, float linear, float quadratic) {
    sharedApplet.lightFalloff(constant, linear, quadratic);
  }

  public static void lightSpecular(float v1, float v2, float v3) {
    sharedApplet.lightSpecular(v1, v2, v3);
  }

  public static void background(int rgb) {
    sharedApplet.background(rgb);
  }

  public static void background(int rgb, float alpha) {
    sharedApplet.background(rgb, alpha);
  }

  public static void background(float gray) {
    sharedApplet.background(gray);
  }

  public static void background(float gray, float alpha) {
    sharedApplet.background(gray, alpha);
  }

  public static void background(float v1, float v2, float v3) {
    sharedApplet.background(v1, v2, v3);
  }

  public static void background(float v1, float v2, float v3, float alpha) {
    sharedApplet.background(v1, v2, v3, alpha);
  }

  public static void clear() {
    sharedApplet.clear();
  }

  public static void background(PImage image) {
    sharedApplet.background(image);
  }

  public static void colorMode(int mode) {
    sharedApplet.colorMode(mode);
  }

  public static void colorMode(int mode, float max) {
    sharedApplet.colorMode(mode, max);
  }

  public static void colorMode(int mode, float max1, float max2, float max3) {
    sharedApplet.colorMode(mode, max1, max2, max3);
  }

  public static void colorMode(int mode, float max1, float max2, float max3, float maxA) {
    sharedApplet.colorMode(mode, max1, max2, max3, maxA);
  }

  public static final float alpha(int rgb) {
    return sharedApplet.alpha(rgb);
  }

  public static final float red(int rgb) {
    return sharedApplet.red(rgb);
  }

  public static final float green(int rgb) {
    return sharedApplet.green(rgb);
  }

  public static final float blue(int rgb) {
    return sharedApplet.blue(rgb);
  }

  public static final float hue(int rgb) {
    return sharedApplet.hue(rgb);
  }

  public static final float saturation(int rgb) {
    return sharedApplet.saturation(rgb);
  }

  public static final float brightness(int rgb) {
    return sharedApplet.brightness(rgb);
  }

  public static void checkAlpha() {
    sharedApplet.checkAlpha();
  }

  public static int get(int x, int y) {
    return sharedApplet.get(x, y);
  }

  public static PImage get(int x, int y, int w, int h) {
    return sharedApplet.get(x, y, w, h);
  }

  public static PImage get() {
    return sharedApplet.get();
  }

  public static PImage copy() {
    return sharedApplet.copy();
  }

  public static void set(int x, int y, int c) {
    sharedApplet.set(x, y, c);
  }

  public static void set(int x, int y, PImage img) {
    sharedApplet.set(x, y, img);
  }

  public static void mask(PImage img) {
    sharedApplet.mask(img);
  }

  public static void filter(int kind) {
    sharedApplet.filter(kind);
  }

  public static void filter(int kind, float param) {
    sharedApplet.filter(kind, param);
  }

  public static void copy(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
    sharedApplet.copy(sx, sy, sw, sh, dx, dy, dw, dh);
  }

  public static void copy(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
    sharedApplet.copy(src, sx, sy, sw, sh, dx, dy, dw, dh);
  }

  public static void blend(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
    sharedApplet.blend(sx, sy, sw, sh, dx, dy, dw, dh, mode);
  }

  public static void blend(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
    sharedApplet.blend(src, sx, sy, sw, sh, dx, dy, dw, dh, mode);
  }
}