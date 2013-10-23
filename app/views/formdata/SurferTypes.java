package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author marc
 *
 */
public class SurferTypes {
  
  private static String[] types = {"Male", "Female", "Grom"};
  
  /**
  *
  * @return the type map.
  */
 public static Map<String, Boolean> getTypes() {
   Map<String, Boolean> typeMap = new HashMap<>();
   for (String type: types) {
     typeMap.put(type, false);
   }
   return typeMap;
 }

 /**
  *
  * @param surfType the type.
  * @return typemap.
  */
 public static Map<String, Boolean> getTypes(String surfType) {
   Map<String, Boolean> typeMap = SurferTypes.getTypes();
   if (isType(surfType)) {
     typeMap.put(surfType, true);
   }
   return typeMap;
 }

 /**
  *
  * @param surfType the type.
  * @return surfer type.
  */
 public static boolean isType(String surfType) {
   return SurferTypes.getTypes().keySet().contains(surfType);
 }

}
