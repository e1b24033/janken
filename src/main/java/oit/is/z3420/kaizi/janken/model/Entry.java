package oit.is.z3420.kaizi.janken.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Entry {
  private ArrayList<String> users = new ArrayList<>();

  public void addUser(String name) {
    if (!users.contains(name)) {
      users.add(name);
    }
  }

  public ArrayList<String> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<String> users) {
    this.users = users;
  }
}
