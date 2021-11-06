package nl.benmens.processing.observer;

import java.util.ArrayList;

public class SubscriptionManager {

  ArrayList<Subscription<?>> subscriptions = new ArrayList<Subscription<?>>();
  
  public SubscriptionManager() {
  }

  protected Subscription<?> add(Subscription<?> subscription) {
    this.subscriptions.add(subscription);

    return subscription;
  }

  public void unsubscribeAll() {
    for (Subscription<?> subscription :subscriptions) {
      subscription.unsubscribe();
    }

    subscriptions.clear();
  }

  public void unsubscribeAll(Object source) {
    ArrayList<Subscription<?>> toRemove = new ArrayList<Subscription<?>>();

    for (Subscription<?> subscription :subscriptions) {
      if (subscription.subject.source == source) {
        subscription.unsubscribe();
        toRemove.add(subscription);
      }
    }

    subscriptions.removeAll(toRemove);
  }

}