package controllers;

import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns the manage surfer page.
   * @return The manage surfer page.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers(), false));
    
  }
  
  /**
   * Returns the page containing the surfer info.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurfers()));
    
  }
  
  /**
   * Returns the index page and deletes the surfer with the given slug.
   * @param slug The slug used to retrieve the surfer.
   * @return The indexed surfer page.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurfers()));
    
  }
  
  /**
   * Returns the managed surfer page with the given slug.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    data.checker = false;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true));
  }
  
  /**
   * Returns the managed surfer page.
   * @return The manage surfer page.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors() && formData.errors().containsKey("slug")) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers(), false));
    }
    else if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      return ok(ManageSurfer.render(formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true));
    }
    
  }
}
