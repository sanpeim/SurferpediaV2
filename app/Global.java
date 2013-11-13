import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
 * 
 * @author marc
 *
 */
public class Global extends GlobalSettings {
  
  /**
  *Start up info.
  *@param app the application.
  */
  public void onStart(Application app) {
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
     
    SurferDB.addSurfer(new SurferFormData(
        "Kalani David",
        "North Shore, Hawaii",
        "2008 NSSA Title",
        "http://watermansappliedscience.com/blog/wp-content/uploads/2010/10/Kalani-David-Oct2.jpg",
        "http://www.seventeen.com/cm/seventeen/images/Fa/Kalani-David.jpg",
        "Kalani David. The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-surfer "
        + "is looking very uncomfortable seated across from me at a roadside eatery in Bali.  "
        + "His strengths are airs and his weaknesses are definitely turns. "
        + "He is working on turns. He has been filming a lot lately, and has some footage of his turns, "
        + "so he wants to improve that. If he could combine more rail surfing with airs, "
        + "he thinks he would do a lot better.  "
        + "As David confronts the painstaking decision of whether to pursue a career in skating or surfing, "
        + "you might think the injury toll alone would be enough to make up his mind. "
        + "But you would be wrong. If it was life or death, and I had to choose skating or surfing, "
        + "I would choose death, he says.",
        "kalanidavid",
        "Male"));
    
    SurferDB.addSurfer(new SurferFormData(
        "Clarissa Moore",
        "Honolulu, Hawaii",
        "6 ASP Women's World Tour events, 2 ASP WQS 6-Star events and 11 NSSA Titles",
        "http://media.outsideonline.com/images/719*488/Gallery_CarissaMoore1_08052011.jpg",
        "http://images.nationalgeographic.com/wpf/media-live/photos/000/425/cache/carissa-moore-portrait_42534_600x450.jpg",
        "Carissa Kainani Moore (born August 27, 1992) is an Hawaiian surfer "
        + "and the 2011 and 2013 ASP Women's World Tour Champion.  "
        + "Moore learned how to surf from her father. She has a younger sister Cayla.  "
        + "Carissa graduated from Punahou School in 2010.",
        "clarissamoore",
        "Female"));
    
    SurferDB.addSurfer(new SurferFormData(
        "Jake Marshall",
        "Encinitas, California",
        "2013 King of the Groms",
        "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg",
        "http://www.nssa.org/photogallery/gallery/2008-09_SEASON/JMarshallswO.jpg",
        "Many young surfers have the potential to make an impact on our sport, "
        + "but none look more poised to do so than Jake Marshall. "
        + "Raised on the rippable beachbreaks and reefs of San Diego's North County, "
        + "Jake has developed a solid base of smooth rail work as well as "
        + "the kind of flair that few 14-year-old surfers can match.  "
        + "Already, he's had remarkable success in a jersey, including a recent win at the U.S. Surfing Championships "
        + "at Lower Trestles. But while surf stardom seems inevitable for Jake, he's still just a kid, "
        + "and knows where his priorities should be. ",
        "jakemarshall",
        "Grom"));
  }
}
