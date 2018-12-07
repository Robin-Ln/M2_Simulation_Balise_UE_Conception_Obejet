package observeur;

public class Evenement {

  Observable source;

  public Evenement(Observable source) {
    this.source = source;
  }

  public Observable source() {
    return source;
  }

}
