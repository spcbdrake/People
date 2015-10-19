import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;

/**
 * Created by benjamindrake on 10/19/15.
 */
public class People implements Comparable {
    int id;
    String first_name;
    String last_name;
    String email;
    String country;
    String ip_address;

    public People(int id, String first_name, String last_name, String email, String country, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
    }

    @Override
    public int compareTo(Object o) {
        People c = (People) o;
        return last_name.compareTo(c.last_name);

    }
    @Override
    public String toString () {
        return String.format("%s %s", first_name, last_name);
    }
}
