package week8.homework1;

import java.util.ArrayList;
import java.util.List;

public class NewQueueCreator {

    private int sizeOfComplaintsList;

    public List<LogFileRow> getListOfNewComplaints(List<LogFileRow> list) {
        int oldSizeOfComplaintsList = sizeOfComplaintsList;
        int newSizeOfComplaintsList = list.size();
        List<LogFileRow> complaints = new ArrayList<>();
        for (int i = oldSizeOfComplaintsList; i < newSizeOfComplaintsList; i++) {
            complaints.add(list.get(i));
        }
        sizeOfComplaintsList = newSizeOfComplaintsList;
        return complaints;
    }
}
