/***********************************************************************
 * Module:  GEN_Estudiantes.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Estudiantes
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 5aa94c32-d265-4dce-b1b3-dc7e977cbfa1 */
public class GEN_Estudiantes extends GEN_Personas {
   /** @pdOid ad4227e2-7242-49d9-a72b-30481d9fd1c9 */
   private String est_nro_carnet;
   
   /** @pdOid 80d76245-adb6-4356-a772-4179857486a3 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid 1006cd95-2892-4b06-af41-8c28619fa5ea */
   public String getEst_nro_carnet() {
      return est_nro_carnet;
   }
   
   /** @param newEst_nro_carnet
    * @pdOid 81611121-e605-4be7-8b0c-e05b281fcd19 */
   public void setEst_nro_carnet(String newEst_nro_carnet) {
      est_nro_carnet = newEst_nro_carnet;
   }
   
   /** @pdOid 22179cbc-644c-43c8-bfd0-d9fc5e484a8f */
   public GEN_Estudiantes() {
      // TODO: implement
   }

}