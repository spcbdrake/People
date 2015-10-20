import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by benjamindrake on 10/19/15.
 */
public class Peopleassignment {
    public static void main(String[] args) {
        HashMap<String, ArrayList<People>> people = new HashMap();

        String postPeople = readFile("people.csv");

        String[] lines = postPeople.split("\n");
        int lineNum = 0;
        for (String line : lines) {
            if (lineNum !=0) {
                String[] columns = line.split(",");
                People people1 = new People(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
                if (people.containsKey(columns[4])) {
                    people.get(columns[4]).add(people1);
                } else {
                    ArrayList<People> peopleList = new ArrayList();
                    peopleList.add(people1);
                    people.put(columns[4], peopleList);
                }
            }
            lineNum++;
        }

        for (Map.Entry<String, ArrayList<People>> list : people.entrySet()) {
            Collections.sort(list.getValue());
            System.out.println(String.format("%s %s", list.getKey(), list.getValue()));
        }
    }


    static String readFile(String fileName) {

        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }
}
