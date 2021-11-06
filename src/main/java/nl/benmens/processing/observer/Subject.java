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

    for (WeakReference<Subscription<T>> ref: subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null) {
        result.add(subscription.observer);
      }
    }

    return result;
  }

  private ArrayList<WeakReference<Subscription<T>>> getSubscriptionsClone() {
    ArrayList<WeakReference<Subscription<T>>> result = new ArrayList<WeakReference<Subscription<T>>>();

    for (WeakReference<Subscription<T>> ref: subscriptions) {
      result.add(ref);
    }

    return result;
  }


  private Subscription<T> findSubscription(T observer) {
    for (WeakReference<Subscription<T>> ref: subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null && subscription.observer == observer) {
        return subscription;
      }
    }

    return null;
  }

  public boolean hasObserver(T observer) {
    for (WeakReference<Subscription<T>> ref: subscriptions) {
      Subscription<T> subscription = ref.get();

      if (subscription != null && subscription.observer == observer) {
        return true;
      }
    }

    return false;
  }

  private Subscription<?> getSubscription(T observer) {
    Subscription<T> subscription = findSubscription(observer);

    if (subscription == null) {
      subscription = new Subscription<T>(observer, this);
      subscriptions.add(new WeakReference<Subscription<T>>(subscription));
    } 

    return subscription;
  }

  public Subscription<?> subscribe(T observer, SubscriptionManager subscriptionManager) {
    return (Subscription<?>)subscriptionManager.add(this.getSubscription(observer));
  }

  protected void unsubscribe(Object observer) {
    ArrayList<WeakReference<Subscription<T>>> clonedList = getSubscriptionsClone();

    for (WeakReference<Subscription<T>> ref: clonedList) {
      Subscription<T> subscription = ref.get();
      
      if (subscription == null) {
        // remove cleared subscriptions
        subscriptions.remove(ref);
      } else if (subscription.observer == observer) {
        subscriptions.remove(ref);
      }
    }
  }

  public void unsubscribeAll() {
    ArrayList<WeakReference<Subscription<T>>> clonedList = getSubscriptionsClone();

    for (WeakReference<Subscription<T>> ref: clonedList) {
      Subscription<T> subscription = ref.get();

      if (subscription != null) {
        subscription.unsubscribe();
      }
    }

    subscriptions.clear();
  }
  
}