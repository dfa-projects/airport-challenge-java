package airport.java.challenge;

import java.util.ArrayList;

public class Airport {
    int capacity = 5;
    ArrayList<String> hangar = new ArrayList<>();

    public Airport() {
        this.capacity = capacity;
        this.hangar = hangar;
    }

    public int override(int newCapacity) {
      this.capacity = newCapacity;
      return this.capacity;
    }

    public String land(String plane) {
        if (this.hangar.contains(plane)) {
            return "This plane has already landed.";
        } else if (this.hangar.size() < this.capacity) {
            this.hangar.add(plane);
            return plane + " has landed.";
        } else {
            return "Cannot land plane. Hangar is full.";
        }
    }

    public String takeOff(String plane) {
        if (this.hangar.contains(plane)) {
            this.hangar.remove(plane);
            return plane + " has left the airport.";
        } else {
            return "This plane has already taken off.";
        }
    }
}

