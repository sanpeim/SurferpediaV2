package models;

/**
 * 
 * @author marc
 *
 */
public class Surfer {

  /** the name field. */
  private String name;
  /** the home field. */
  private String home;
  /** the award field. */
  private String awards;
  /** the carousel url field. */
  private String carouselUrl;
  /** the bio url field. */
  private String bioUrl;
  /** the bio field. */
  private String bio;
  /** the slug field. */
  private String slug;
  /** the type field. */
  private String surferType;
  /** checks if created. */
  private boolean checker = true;
  
  /**
   * Creates a surfer.
   * @param name name.
   * @param home home.
   * @param awards awards.
   * @param carouselUrl carousel url.
   * @param bioUrl bio url.
   * @param bio bio.
   * @param slug slug.
   * @param surferType the surfer types.
   */
  public Surfer(String name, String home, String awards, String carouselUrl, 
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
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the home
   */
  public String getHome() {
    return home;
  }

  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }

  /**
   * @return the carouselUrl
   */
  public String getCarouselUrl() {
    return carouselUrl;
  }

  /**
   * @param carouselUrl the carouselUrl to set
   */
  public void setCarouselUrl(String carouselUrl) {
    this.carouselUrl = carouselUrl;
  }

  /**
   * @return the bioUrl
   */
  public String getBioUrl() {
    return bioUrl;
  }

  /**
   * @param bioUrl the bioUrl to set
   */
  public void setBioUrl(String bioUrl) {
    this.bioUrl = bioUrl;
  }

  /**
   * @return the bio
   */
  public String getBio() {
    return bio;
  }

  /**
   * @param bio the bio to set
   */
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * @return the surferType
   */
  public String getSurferType() {
    return surferType;
  }

  /**
   * @param surferType the surferType to set
   */
  public void setSurferType(String surferType) {
    this.surferType = surferType;
  }

  /**
   * @return the checker
   */
  public boolean isChecker() {
    return checker;
  }

  /**
   * @param checker the checker to set
   */
  public void setChecker(boolean checker) {
    this.checker = checker;
  }
  
  
  
  
}
