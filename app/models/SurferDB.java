package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * 
 * @author marc
 * 
 */
public class SurferDB {

  private static Map<String, Surfer> surfers = new HashMap<>();

  /**
   * Adds a surfer.
   * 
   * @param formData form for data.
   * @return a contact.
   */
  public static Surfer addSurfer(SurferFormData formData) {
    String slug = formData.slug;
    Surfer surfer =
        new Surfer(formData.name, formData.home, formData.awards, formData.carouselUrl, formData.bioUrl,
            formData.bio, slug, formData.surferType, formData.footType);
    surfers.put(slug, surfer);
    return surfer;
  }
  
  /**
   * Deletes a surfer.
   * @param slug slug.
   */
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
  
  /**
   * Checks if slug exists.
   * @param slug slug.
   * @return True if exits.
   */
  public static boolean slugExists(String slug) {
    return surfers.containsKey(slug);
  }

  /**
   * Returns a list of all surfers.
   * @return a list.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }

  /**
   * @param slug the slug.
   * @return Returns a contact with given ID.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      throw new RuntimeException("Bad Input" + slug);
    }
    return surfer;
  }

}
