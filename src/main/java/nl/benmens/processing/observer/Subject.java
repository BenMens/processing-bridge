package nl.benmens.processing.observer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class Subject<T> {
  private ArrayList<WeakReference<Subscription<T>>> subscriptions = new ArrayList<WeakReference<Subscription<T>>>(); 
  protected Object source;

  public Subject(Object source) {
    this.source = source;
  }

  public ArrayList<T> getObservers() {
    ArrayList<T> result = new ArrayList<T>();

    for (WeakReference<Subscription<T>> ref : subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null) {
        result.add(subscription.observer);
      }
    }

    return result;
  }

  private Subscription<T> findSubscription(T observer) {
    for (WeakReference<Subscription<T>> ref : subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null && subscription.observer == observer) {
        return subscription;
      }
    }

    return null;
  }

  public boolean hasObserver(T observer) {
    for (WeakReference<Subscription<T>> ref : subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null && subscription.observer == observer) {
        return true;
      }
    }

    return false;
  }

  protected void add(Subscription<T> subscription) {
    subscriptions.add(new WeakReference<Subscription<T>>(subscription));
  }

  protected void remove(Subscription<T> subscription) {
    ArrayList<WeakReference<Subscription<T>>> clonedSubscriptions = 
      new ArrayList<WeakReference<Subscription<T>>>(subscriptions);

    for (WeakReference<Subscription<T>> ref : clonedSubscriptions) {
      Subscription<T> currentSubscription = ref.get();
      
      if (subscription == null) {
        // remove cleared subscriptions
        subscriptions.remove(ref);
      } else if (currentSubscription == subscription) {
        subscriptions.remove(ref);
      }
    }
  }

  public Subscription<?> subscribe(T observer, SubscriptionManager subscriptionManager) {
    return this.getSubscription(observer, subscriptionManager);
  }

  private Subscription<?> getSubscription(T observer,SubscriptionManager subscriptionManager) {
    Subscription<T> subscription = findSubscription(observer);

    if (subscription == null) {
      subscription = new Subscription<T>(observer, this, subscriptionManager);
    } 

    return subscription;
  }

  public void unsubscribeAll() {
    ArrayList<WeakReference<Subscription<T>>> clonedSubscriptions = 
      new ArrayList<WeakReference<Subscription<T>>>(subscriptions);

    for (WeakReference<Subscription<T>> ref : clonedSubscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null) {
        subscription.unsubscribe();
      }
    }

    subscriptions.clear();
  }
  
}