package models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kevin Paek
 * 
 */
public class UpdatesDB {

  private static List<Update> updates = new ArrayList<>();

  /**
   * Adds an Update.
   * 
   * @param update Update to add.
   * @return The added Update.
   */
  public static Update addUpdate(Update update) {
    updates.add(update);
    return update;
  }
}
