import java.util.LinkedList;
import java.util.List;

public class Twitter implements IObservable {

    private List<IObserver> _observers = new LinkedList<IObserver>();
    private final LinkedList<String> _twits = new LinkedList<String>();

    public Twitter() { }

    public Twitter(List<IObserver> observers) {
        subscribe(observers);
    }

    public List<IObserver> getObservers(){
        return _observers;
    }


    public List<String> getTwits(){
        return _twits;
    }

    /// <summary>
    /// This method is designed to trigger update to each subscriber
    /// </summary>
    /// <exception cref="NotImplementedException"></exception>
    public void notifyObservers() {
        if(_observers.isEmpty()){
            throw new EmptyListOfSubscribersException();
        }
        for(var observer : _observers){
            observer.update(this);
        }
    }

    /// <summary>
    /// This method is designed to add a subscriber in the list of observers
    /// </summary>
    /// <param name="observers">Observers to add to the list of observers</param>
    /// <exception cref="NotImplementedException"></exception>
    public void subscribe(List<IObserver> observers) {
        for(var obs : observers){
            if(_observers.contains(obs)){
                throw new SubscriberAlreadyExistsException();
            }
            _observers.add(obs);
        }
    }

    /// <summary>
    /// This method is designed to remove a subscriber from the existing list of observers
    /// </summary>
    /// <param name="observer">Observer to remove from the list of observers</param>
    /// <exception cref="NotImplementedException"></exception>
    public void unsubscribe(IObserver observer) {
        if(_observers.isEmpty()){
            throw new EmptyListOfSubscribersException();
        }
        if(!_observers.contains(observer)){
            throw new SubscriberNotFoundException();
        }
        _observers.remove(observer);
    }

    /// <summary>
    /// This method is designed to post a twit
    /// </summary>
    /// <param name="twit">Twit to post</param>
    /// <exception cref="NotImplementedException"></exception>
    public void post(String twit) {
        throw new UnsupportedOperationException();
    }

    public String lastTwit() {
        throw new UnsupportedOperationException();
    }


    private Boolean exists(IObserver followerToFind) {
        throw new UnsupportedOperationException();
    }


    public class TwitterException extends RuntimeException {
        public TwitterException(){
            super();
        }
    }

    public class EmptyListOfSubscribersException extends TwitterException {
        public EmptyListOfSubscribersException() {
            super();
        }
    }

    public class SubscriberAlreadyExistsException extends TwitterException {
        public SubscriberAlreadyExistsException() {
            super();
        }
    }

    public class SubscriberNotFoundException extends TwitterException {

        public SubscriberNotFoundException() {
            super();
        }
    }

}