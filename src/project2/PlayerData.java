
package project2;

import java.util.UUID;
import java.time.LocalDateTime;

public class PlayerData {
    private UUID guid;
    private boolean isActive;
    private String firstName;
    private String lastName;
    private String email;
    private int rank;
    private int winRate;
    private LocalDateTime registered;
    private LocalDateTime lastPlayed;
    
    
    public PlayerData(UUID guid, boolean isActive, String firstName,
            String lastName, String email, int rank, int winRate,
            LocalDateTime registered, LocalDateTime lastPlayed) {
        this.guid = guid;
        this.isActive = isActive;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
        this.winRate = winRate;
        this.registered = registered;
        this.lastPlayed = lastPlayed;
    }

    public UUID getGUID() {
        return guid;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getRank() {
        return rank;
    }

    public int getWinRate() {
        return winRate;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

 
}
