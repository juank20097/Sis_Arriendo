/***********************************************************************
 * Module:  ARR_Items.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Items
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 3ee7c526-195b-4a31-88be-15e664ae93b1 */
public class ARR_Items {
   /** @pdOid 8f85d3e2-3e4e-49a2-b7f0-9e7b595fd853 */
   private Integer ite_id;
   /** @pdOid 0ad2010d-aab0-471e-9e38-7569a70b2b35 */
   private String ite_descripcion;
   
   /** @pdOid 50b1f8b5-e5b4-454e-840c-b93813339a49 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Clausulas assc=association6 mult=1..1 side=A */
   public ARR_Clausulas cla;
   
   /** @pdOid ed00f2a3-6882-4c74-b6fd-bd9459040474 */
   public ARR_Items() {
      // TODO: implement
   }
   
   /** @pdOid 85c3e9ec-6e68-4ce7-8484-fb6a079cd463 */
   public Integer getIte_id() {
      return ite_id;
   }
   
   /** @param newIte_id
    * @pdOid 9a09602a-00a7-4958-bbc5-89b0fe92bda8 */
   public void setIte_id(Integer newIte_id) {
      ite_id = newIte_id;
   }
   
   /** @pdOid 0e41ae3e-90d4-44fd-9319-4f12dcb91017 */
   public String getIte_descripcion() {
      return ite_descripcion;
   }
   
   /** @param newIte_descripcion
    * @pdOid 58537e6c-74b4-4463-86d0-07841b2f72ce */
   public void setIte_descripcion(String newIte_descripcion) {
      ite_descripcion = newIte_descripcion;
   }
   
   
   /** @pdGenerated default parent getter */
   public ARR_Clausulas getCla() {
      return cla;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Clausulas */
   public void setCla(ARR_Clausulas newARR_Clausulas) {
      if (this.cla == null || !this.cla.equals(newARR_Clausulas))
      {
         if (this.cla != null)
         {
            ARR_Clausulas oldARR_Clausulas = this.cla;
            this.cla = null;
            oldARR_Clausulas.removeIte(this);
         }
         if (newARR_Clausulas != null)
         {
            this.cla = newARR_Clausulas;
            this.cla.addIte(this);
         }
      }
   }

}