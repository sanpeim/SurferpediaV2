package views.formdata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * footstyle types.
 * @author marc
 *
 */
public class FootstyleTypes {

private static String[] types = {"Regular", "Goofy"};
  
  /**
  *
  * @return the type map.
  */
 public static List<String> getTypes() {
   List<String> foot = Arrays.asList(types);
   return foot;
 }

 /**
  *
  * @param surfType the type.
  * @return typemap.
  */
 public static List<String> getTypes(String footType) {
   List<String> foot = FootstyleTypes.getTypes();
   if (foot.equals("Regular")) {
     foot.add("Regular");
   }else if(foot.equals("Goofy")){
     foot.add("Goofy");
   }
   return foot;
 }


}
