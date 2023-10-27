/**
 * @author Braden Schlueter (plr61)
 * @author Ibrahim Qafisheh (nmq6)
 * @author Nicholas Rodriguez (dub7)
 * @author Quetzin Pimentel (q_p12)
 */

/**
 * The PlayerData class represents data for a player in a gaming system.
 * It contains information about the player, including their unique ID, 
 * activity status, name, email, rank, win rate, and registration and 
 * last played timestamps.
 */
package project2;

import java.util.UUID;
import java.time.LocalDateTime;

public class PlayerData {
    private UUID guid;          //Unique identifier for the player.
    private boolean isActive;   //Whether the player is active or not.
    private String firstName;   //The player's first name.
    private String lastName;    //The player's last name.
    private String email;       //The player's email address.
    private int rank;           //The player's rank.
    private int winRate;        //The player's win rate.
    private LocalDateTime registered;   //The date and time the player 
                                            //registered.
    private LocalDateTime lastPlayed;   //The date and time the player 
                                            //last played.
    
    /**
     * Constructs a new PlayerData instance with the provided data.
     *
     * @param guid        The unique identifier for the player.
     * @param isActive    Indicates whether the player is active.
     * @param firstName   The first name of the player.
     * @param lastName    The last name of the player.
     * @param email       The email address of the player.
     * @param rank        The player's rank.
     * @param winRate     The player's win rate as a percentage.
     * @param registered  The timestamp when the player registered.
     * @param lastPlayed  The timestamp of the player's last activity.
     */

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
    /**
     * Get the unique identifier for the player.
     *
     * @return The unique identifier (GUID) of the player.
     */
    public UUID getGUID() {
        return guid;
    }
    /**
     * Check if the player is active.
     *
     * @return True if the player is active, false otherwise.
     */
    public boolean getIsActive() {
        return isActive;
    }
    /**
     * Get the first name of the player.
     *
     * @return The first name of the player.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Get the last name of the player.
     *
     * @return The last name of the player.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Get the email address of the player.
     *
     * @return The email address of the player.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Get the rank of the player in the gaming system.
     *
     * @return The player's rank.
     */
    public int getRank() {
        return rank;
    }
    /**
     * Get the win rate of the player as a percentage.
     *
     * @return The player's win rate as a percentage.
     */
    public int getWinRate() {
        return winRate;
    }
    /**
     * Get the timestamp when the player registered.
     *
     * @return The registration timestamp.
     */
    public LocalDateTime getRegistered() {
        return registered;
    }
    /**
     * Get the timestamp of the player's last activity.
     *
     * @return The timestamp of the last activity.
     */
    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

 
}