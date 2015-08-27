/***********************************************************************
 * Module:  ARR_Inter_Per.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Inter_Per
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid deb75e41-bf50-43e4-a31b-740fcd71eb03 */
public class ARR_Inter_Per {
   /** @pdOid 68006ba9-36d8-4722-8b3f-e591febe1c4b */
   private Integer inp_id;
   /** @pdOid 9d8cd329-b9af-4a90-a0fd-4ca34dee1ff4 */
   private Integer per_id;
   
   /** @pdOid 14ad1ff2-157c-457f-8038-1301056cbca1 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contratos_Cab assc=association10 mult=1..1 */
   public ARR_Contratos_Cab con_cab;
   
   /** @pdOid 67b36a12-7ab9-405c-9696-4d142edb23e4 */
   public ARR_Inter_Per() {
      // TODO: implement
   }
   
   /** @pdOid 4b0671a4-a8c4-4f8f-acaf-aeb0c635ae08 */
   public Integer getInp_id() {
      return inp_id;
   }
   
   /** @param newInp_id
    * @pdOid f4515c5d-7f0d-491a-b10f-6aecf99e763e */
   public void setInp_id(Integer newInp_id) {
      inp_id = newInp_id;
   }
   
   /** @pdOid fc5a9fca-b396-4af4-bb6c-b54aac65d20d */
   public Integer getPer_id() {
      return per_id;
   }
   
   /** @param newPer_id
    * @pdOid 446fcaac-237d-4655-95be-ff35f77a5363 */
   public void setPer_id(Integer newPer_id) {
      per_id = newPer_id;
   }
   
   
   /** @pdGenerated default parent getter */
   public ARR_Contratos_Cab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Contratos_Cab */
   public void setCon_cab(ARR_Contratos_Cab newARR_Contratos_Cab) {
      if (this.con_cab == null || !this.con_cab.equals(newARR_Contratos_Cab))
      {
         if (this.con_cab != null)
         {
            ARR_Contratos_Cab oldARR_Contratos_Cab = this.con_cab;
            this.con_cab = null;
            oldARR_Contratos_Cab.removeIntp(this);
         }
         if (newARR_Contratos_Cab != null)
         {
            this.con_cab = newARR_Contratos_Cab;
            this.con_cab.addIntp(this);
         }
      }
   }

}