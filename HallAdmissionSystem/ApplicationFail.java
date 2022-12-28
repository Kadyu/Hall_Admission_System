package HallAdmissionSystem;

public class ApplicationFail implements ApplicationState {

  @Override
  public String notifyStudent() {
    return "Unfortunately, your application is unsuccessful";
  }

  @Override
  public String getStateString() {
    return "Failed";
  }

  @Override
  public Boolean isProcessed() {
    return true;
  }

}
