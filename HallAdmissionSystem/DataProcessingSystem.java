package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DataProcessingSystem {
	private ArrayList<Application> unprocessedApplications;

	private HashMap<Hall, ApplicationQueue> queueMap;
	private HashMap<Hall, ArrayList<Application>> admittedMap;
	private PriorityQueue<Application> pendingApplications;

	public DataProcessingSystem(ArrayList<Application> app) {
		queueMap = new HashMap<>();
		admittedMap = new HashMap<>();
		pendingApplications = new PriorityQueue<>();
	}

	public void initializeLists(ArrayList<Application> allApplications, ArrayList<Hall> hList) {
		unprocessedApplications = allApplications;

		for (Hall hall : hList) {
			queueMap.put(hall, new ApplicationQueue());
			admittedMap.put(hall, new ArrayList<>());
		}
	}

	public void loadApplicationQueues() {
		for (Application application : unprocessedApplications) {
			ApplicationQueue applicationQueue = queueMap.get(application.getHall());
			if (!application.isProcessed()) {
				applicationQueue.addApplication(application);
			}
		}
	}

	public void processApplications() {
		Application application;
		for (Entry<Hall, ApplicationQueue> entry : queueMap.entrySet()) {
			Hall hall = entry.getKey();
			ApplicationQueue applicationQueue = entry.getValue();

			while ((application = applicationQueue.getTopNonLocal()) != null) {
				filterApplication(hall, application);
			}
			while ((application = applicationQueue.getTopLocal()) != null) {
				filterApplication(hall, application);
			}
		}
		while ((application = pendingApplications.poll()) != null) {
			Hall hall = getEmptyHall();
			if (hall != null) {
				admittedMap.get(hall).add(application);
				application.setState(new ApplicationSuccess());
			} else {
				application.setState(new ApplicationFail());
			}
		}
	}

	private void filterApplication(Hall hall, Application application) {
		ArrayList<Application> admittedList = admittedMap.get(hall);
		if (admittedList.size() < hall.getCapacity()) {
			admittedList.add(application);
			application.setState(new ApplicationSuccess());
		} else {
			pendingApplications.add(application);
		}
	}

	private Hall getEmptyHall() {
		for (Entry<Hall, ArrayList<Application>> entry : admittedMap.entrySet()) {
			if (entry.getValue().size() < entry.getKey().getCapacity()) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void startProcessingApplications(ArrayList<Application> raw, ArrayList<Hall> hList) {
		initializeLists(raw, hList);
		loadApplicationQueues();
		processApplications();
	}
	
	//For Testing
	public ArrayList<Application> getunprocessedApplications(){return unprocessedApplications;}
	public HashMap<Hall, ApplicationQueue> getqueueMap(){return queueMap;}
	public HashMap<Hall, ArrayList<Application>> getadmittedMap(){return admittedMap;}
	public PriorityQueue<Application> getpendingApplications(){return pendingApplications;}

}
