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
   
   /** @pdOid 14ad1ff2-157c-457f-8038-1301056cbca1 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Contrato_Cab assc=association10 mult=1..1 */
   public ARR_Contrato_Cab con_cab;
   /** @pdRoleInfo migr=no name=GEN_Persona assc=association11 mult=1..1 */
   public GEN_Persona per;
   
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
   
   
   /** @pdGenerated default parent getter */
   public ARR_Contrato_Cab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newARR_Contrato_Cab */
   public void setCon_cab(ARR_Contrato_Cab newARR_Contrato_Cab) {
      if (this.con_cab == null || !this.con_cab.equals(newARR_Contrato_Cab))
      {
         if (this.con_cab != null)
         {
            ARR_Contrato_Cab oldARR_Contrato_Cab = this.con_cab;
            this.con_cab = null;
            oldARR_Contrato_Cab.removeIntp(this);
         }
         if (newARR_Contrato_Cab != null)
         {
            this.con_cab = newARR_Contrato_Cab;
            this.con_cab.addIntp(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public GEN_Persona getPer() {
      return per;
   }
   
   /** @pdGenerated default parent setter
     * @param newGEN_Persona */
   public void setPer(GEN_Persona newGEN_Persona) {
      if (this.per == null || !this.per.equals(newGEN_Persona))
      {
         if (this.per != null)
         {
            GEN_Persona oldGEN_Persona = this.per;
            this.per = null;
            oldGEN_Persona.removeIntp(this);
         }
         if (newGEN_Persona != null)
         {
            this.per = newGEN_Persona;
            this.per.addIntp(this);
         }
      }
   }

}