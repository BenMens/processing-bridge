package nl.benmens.processing.observer;

public class Subscription<T> {

  T observer;
  Subject<T> subject;
  SubscriptionManager manager;

  protected Subscription(T observer, Subject<T> subject, SubscriptionManager manager) {
    this.observer = observer;
    this.subject = subject;
    this.manager = manager;

    manager.add(this);
    subject.add(this);
  }

  void unsubscribe() {
    if (subject != null) {
      subject.remove(this);
      manager.remove(this);
      subject = null;
      observer = null;
    }
  }
  
}