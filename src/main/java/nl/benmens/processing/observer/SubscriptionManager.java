package nl.benmens.processing.observer;

import java.util.ArrayList;

public class SubscriptionManager {

  private ArrayList<Subscription<?>> subscriptions = new ArrayList<Subscription<?>>();
  
  public SubscriptionManager() {
  }

  protected void add(Subscription<?> subscription) {
    subscriptions.add(subscription);
  }

  protected void remove(Subscription<?> subscription) {
    subscriptions.remove(subscription);
  }

  public void unsubscribeAll() {
    ArrayList<Subscription<?>> clonedSubscription = new ArrayList<Subscription<?>>(subscriptions);

    for (Subscription<?> subscription : clonedSubscription) {
      subscription.unsubscribe();
    }

    subscriptions.clear();
  }

  public void unsubscribeAll(Object source) {
    ArrayList<Subscription<?>> clonedSubscription = new ArrayList<Subscription<?>>(subscriptions);

    for (Subscription<?> subscription : clonedSubscription) {
      if (subscription.subject.source == source) {
        subscription.unsubscribe();
      }
    }
  }

}