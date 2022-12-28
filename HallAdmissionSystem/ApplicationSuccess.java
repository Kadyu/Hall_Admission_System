package HallAdmissionSystem;

public class ApplicationSuccess implements ApplicationState {

  @Override
  public String notifyStudent() {
    return "Congratulations! Your application is successful!";

  }

  @Override
  public String getStateString() {
    return "Success";
  }

  @Override
  public Boolean isProcessed() {
    return true;
  }

}
