package HallAdmissionSystem;

public class ApplicationInProgress implements ApplicationState {

  @Override
  public String notifyStudent() {
    return "You application is still in progress!";
  }

  @Override
  public String getStateString() {
    return "In Progress";
  }

  @Override
  public Boolean isProcessed() {
    return false;
  }

}
