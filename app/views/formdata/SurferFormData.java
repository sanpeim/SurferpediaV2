package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

/**
 * 
 * @author marc
 *
 */
public class SurferFormData {
  
  /** the name field. */
  public String name = "";
  /** the home field. */
  public String home = "";
  /** the award field. */
  public String awards = "";
  /** the carousel url field. */
  public String carouselUrl = "";
  /** the bio url field. */
  public String bioUrl = "";
  /** the bio field. */
  public String bio = "";
  /** the slug field. */
  public String slug = "";
  /** the type field. */
  public String surferType = "";
  /** checks if created. */
  public boolean checker = true;
  
  /**
   * Default constructor.
   */
  public SurferFormData() {
   //default constructor
  }
  
  /**
   * 
   * @param name name.
   * @param home home.
   * @param awards awards.
   * @param carouselUrl carousel url.
   * @param bioUrl bio url.
   * @param bio bio.
   * @param slug slug.
   * @param surferType the surfer types.
   */
  public SurferFormData(String name, String home, String awards, String carouselUrl, 
                        String bioUrl, String bio, String slug, String surferType) {
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.surferType = surferType;
  }

  /**
   * 
   * @param surfer the surfer.
   */
  public SurferFormData(Surfer surfer) {
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselUrl = surfer.getCarouselUrl();
    this.bioUrl = surfer.getBioUrl();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.surferType = surfer.getSurferType();
  }
  
  /**
   * 
   * @return the errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is Required"));
    }

    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is Required"));
    }

    if (carouselUrl == null || carouselUrl.length() == 0) {
      errors.add(new ValidationError("carouselUrl", "Carousel URL is Required"));
    }
    
    if (bioUrl == null || bioUrl.length() == 0) {
      errors.add(new ValidationError("bioUrl", "Bio URL is Required"));
    }
    
    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Bio paragraph is Required"));
    }
    
    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is Required"));
    }
    
    if (!slug.matches("^[a-zA-Z0-9]*$")) {
      errors.add(new ValidationError("slug", "Slug must be alphanumeric."));
    }
    
    if (checker && SurferDB.slugExists(slug)) {
      errors.add(new ValidationError("slug", "Slug '" + slug + "' already in use."));
    }

    if (!SurferTypes.isType(surferType)) {
      errors.add(new ValidationError("surferType", "Surfer Type is invalid"));
    }

    return errors.isEmpty() ? null : errors;
  }
}
