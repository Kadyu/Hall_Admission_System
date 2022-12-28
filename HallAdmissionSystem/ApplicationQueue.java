package HallAdmissionSystem;

import java.util.PriorityQueue;

public class ApplicationQueue {
	private PriorityQueue<Application> nonLocalApplications;
	private PriorityQueue<Application> localApplications;

	public ApplicationQueue() {
		nonLocalApplications = new PriorityQueue<>();
		localApplications = new PriorityQueue<>();
	}

	public void addApplication(Application app) {
		if (app.getIsLocalStudent()) {
			localApplications.add(app);
		} else {
			nonLocalApplications.add(app);
		}
	}

	public Application getTopLocal() {
		return localApplications.poll();
	}

	public Application getTopNonLocal() {
		return nonLocalApplications.poll();
	}
}
