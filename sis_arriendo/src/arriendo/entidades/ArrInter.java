/***********************************************************************
 * Module:  ArrInter.java
 * Author:  jestevez
 * Purpose: Defines the Class ArrInter
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 1c44bd44-27fc-4c32-8e4a-7fb1d2e1b3b0 */
public class ArrInter {
   /** @pdOid f5edb3ce-3862-4dcb-8071-87e835a1f584 */
   private Integer intcId;
   
   /** @pdOid 4736cf4f-5d7e-44ef-a24d-4abada552dab */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ArrClausulas assc=association5 mult=1..1 */
   public ArrClausulas cla;
   /** @pdRoleInfo migr=no name=ArrContratoCab assc=association4 mult=1..1 side=A */
   public ArrContratoCab con_cab;
   
   /** @pdOid 67744c5e-aac4-4615-976c-7c38aaace25c */
   public ArrInter() {
      // TODO: implement
   }
   
   /** @pdOid c6b4823d-ce27-43cf-b9f0-4daf3b13c22d */
   public Integer getIntcId() {
      return intcId;
   }
   
   /** @param newIntcId
    * @pdOid 3f3166c1-0beb-4a6a-931a-9bf5cfd07428 */
   public void setIntcId(Integer newIntcId) {
      intcId = newIntcId;
   }
   
   
   /** @pdGenerated default parent getter */
   public ArrClausulas getCla() {
      return cla;
   }
   
   /** @pdGenerated default parent setter
     * @param newArrClausulas */
   public void setCla(ArrClausulas newArrClausulas) {
      if (this.cla == null || !this.cla.equals(newArrClausulas))
      {
         if (this.cla != null)
         {
            ArrClausulas oldArrClausulas = this.cla;
            this.cla = null;
            oldArrClausulas.removeIntc(this);
         }
         if (newArrClausulas != null)
         {
            this.cla = newArrClausulas;
            this.cla.addIntc(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public ArrContratoCab getCon_cab() {
      return con_cab;
   }
   
   /** @pdGenerated default parent setter
     * @param newArrContratoCab */
   public void setCon_cab(ArrContratoCab newArrContratoCab) {
      if (this.con_cab == null || !this.con_cab.equals(newArrContratoCab))
      {
         if (this.con_cab != null)
         {
            ArrContratoCab oldArrContratoCab = this.con_cab;
            this.con_cab = null;
            oldArrContratoCab.removeIntc(this);
         }
         if (newArrContratoCab != null)
         {
            this.con_cab = newArrContratoCab;
            this.con_cab.addIntc(this);
         }
      }
   }

}