/***********************************************************************
 * Module:  ARR_Inter_Cla.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Inter_Cla
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 1c44bd44-27fc-4c32-8e4a-7fb1d2e1b3b0 */
public class ARR_Inter_Cla {
   /** @pdOid f5edb3ce-3862-4dcb-8071-87e835a1f584 */
   private Integer intc_id;
   
   /** @pdOid 4736cf4f-5d7e-44ef-a24d-4abada552dab */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Clausulas assc=association5 mult=1..1 */
   public ARR_Clausulas cla;
   /** @pdRoleInfo migr=no name=ARR_Contrato_Cab assc=association4 mult=1..1 side=A */
   public ARR_Contrato_Cab con_cab;
   
   /** @pdOid 67744c5e-aac4-4615-976c-7c38aaace25c */
   public ARR_Inter_Cla() {
      // TODO: implement
   }
   
   /** @pdOid c6b4823d-ce27-43cf-b9f0-4daf3b13c22d */
   public Integer getIntc_id() {
      return intc_id;
   }
   
   /** @param newIntc_id
    * @pdOid 3f3166c1-0beb-4a6a-931a-9bf5cfd07428 */
   public void setIntc_id(Integer newIntc_id) {
      intc_id = newIntc_id;
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
            oldARR_Clausulas.removeIntc(this);
         }
         if (newARR_Clausulas != null)
         {
            this.cla = newARR_Clausulas;
            this.cla.addIntc(this);
         }
      }
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
            oldARR_Contrato_Cab.removeIntc(this);
         }
         if (newARR_Contrato_Cab != null)
         {
            this.con_cab = newARR_Contrato_Cab;
            this.con_cab.addIntc(this);
         }
      }
   }

}