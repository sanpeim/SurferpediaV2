package controllers;

import models.SurferDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
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
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = userInfo != null;
    return ok(Index.render("Index", isLoggedIn, userInfo, SurferDB.getSurfers()));
  }
  
  /**
   * Returns the manage surfer page.
   * @return The manage surfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = userInfo != null;
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render("Add", isLoggedIn, userInfo, formData, SurferTypes.getTypes(), SurferDB.getSurfers(), false, null));
    
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
  @Security.Authenticated(Secured.class)
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
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = userInfo != null;
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    data.checker = false;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render("New", isLoggedIn, userInfo, formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true, null));
  }
  
  /**
   * Returns the managed surfer page.
   * @return The manage surfer page.
   */
  public static Result postSurfer() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = userInfo != null;
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    //Unlocks the slug field if there is a slug related error, otherwise keep it locked
    if (formData.hasErrors() && formData.errors().containsKey("slug")) {
      return badRequest(ManageSurfer.render("New", isLoggedIn, userInfo, formData, SurferTypes.getTypes(), SurferDB.getSurfers(), false, null));
    }
    else if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render("New", isLoggedIn, userInfo, formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true, null));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      return ok(ManageSurfer.render("New", isLoggedIn, userInfo, formData, SurferTypes.getTypes(), SurferDB.getSurfers(), true, null));
    }
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", false, null, formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", false, null, formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
